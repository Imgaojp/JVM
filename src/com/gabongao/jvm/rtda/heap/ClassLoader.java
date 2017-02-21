/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

import com.gabongao.jvm.classfile.ClassFile;
import com.gabongao.jvm.classpath.ClassPath;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * Created by Imgaojp on 2017/2/20.
 */
public class ClassLoader {
    private ClassPath classPath;
    private HashMap<String, ClassStruct> classStructHashMap;

    public ClassLoader(ClassPath classPath) {
        this.classPath = classPath;
        classStructHashMap = new LinkedHashMap<>();
    }

    public ClassStruct loadClass(String name) {
        ClassStruct classStruct = classStructHashMap.get(name);
        if (classStruct == null) {
            return loadNonArrayClass(name);
        }
        return classStruct;
    }

    private ClassStruct loadNonArrayClass(String name) {
        byte[] classData = classPath.readClass(name);
        ClassStruct classStruct = defineClass(classData);
        link(classStruct);
        System.out.printf("Loaded class %s \n", name);
        return classStruct;
    }

    private ClassStruct defineClass(byte[] classData) {
        ClassStruct classStruct = parseClass(classData);
        classStruct.setClassLoader(this);
        resolveSuperClass(classStruct);
        resolveInterfaces(classStruct);
        classStructHashMap.put(classStruct.getClassName(), classStruct);
        return classStruct;
    }

    private ClassStruct parseClass(byte[] classData) {
        ClassFile classFile = new ClassFile(classData);
        classFile.read();
        return new ClassStruct(classFile);
    }

    private void resolveSuperClass(ClassStruct classStruct) {
        if (!classStruct.getClassName().equals("java/lang/Object")) {
            classStruct.setSuperClass(classStruct.getClassLoader().loadClass(classStruct.getSuperClassName()));
        }
    }

    private void resolveInterfaces(ClassStruct classStruct) {
        int interfaceCount = classStruct.getInterfaceNames() == null ? 0 : classStruct.getInterfaceNames().length;
        if (interfaceCount > 0) {
            classStruct.setInterfaces(new ClassStruct[interfaceCount]);
            for (int i = 0; i < interfaceCount; i++) {
                classStruct.getInterfaces()[i] = classStruct.getClassLoader().loadClass(classStruct.getInterfaceNames()[i]);
            }
        }
    }

    private void link(ClassStruct classStruct) {
        verify(classStruct);
        prepare(classStruct);
    }

    private void verify(ClassStruct classStruct) {
        //todo:verify class
    }

    private void prepare(ClassStruct classStruct) {
        calcInstanceFieldSlotIds(classStruct);
        calcStaticFieldSlotIds(classStruct);
        allocAndInitStaticVars(classStruct);
    }

    private void calcInstanceFieldSlotIds(ClassStruct classStruct) {
        int slotId = 0;
        if (classStruct.getSuperClassName() != null) {
            slotId = classStruct.getSuperClass() == null ? 0 : classStruct.getSuperClass().getInstanceSlotCount();
        }
        Field[] fields = classStruct.getFields();
        int len = fields.length;
        for (int i = 0; i < len; i++) {
            if (!fields[i].IsStatic()) {
                fields[i].setSlotId(slotId);
                slotId++;
                if (fields[i].isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        classStruct.setInstanceSlotCount(slotId);
    }

    private void calcStaticFieldSlotIds(ClassStruct classStruct) {
        int slotId = 0;
        Field[] fields = classStruct.getFields();
        int len = fields.length;
        for (int i = 0; i < len; i++) {
            if (fields[i].IsStatic()) {
                fields[i].setSlotId(slotId);
                slotId++;
                if (fields[i].isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        classStruct.setStaticSlotCount(slotId);
    }

    private void allocAndInitStaticVars(ClassStruct classStruct) {
        classStruct.setStaticVars(new Slots(classStruct.getStaticSlotCount()));
        Field[] fields = classStruct.getFields();
        int len = fields.length;
        for (int i = 0; i < len; i++) {
            if (fields[i].IsStatic() && fields[i].IsFinal()) {
                initStaticFinalVar(classStruct, fields[i]);
            }
        }
    }

    private void initStaticFinalVar(ClassStruct classStruct, Field field) {
        Slots slots = classStruct.getStaticVars();
        ConstantPool cp = classStruct.getConstantPool();
        int cpIndex = field.getConstValueIndex();
        int slotId = field.getSlotId();
        if (cpIndex > 0) {
            switch (field.getDescriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    int vali = (int) cp.getConstant(cpIndex).getObject();
                    slots.setInt(slotId, vali);
                    break;
                case "J":
                    long vall = (Long) cp.getConstant(cpIndex).getObject();
                    slots.setLong(slotId, vall);
                    break;
                case "F":
                    float valf = (Float) cp.getConstant(cpIndex).getObject();
                    slots.setFloat(slotId, valf);
                    break;
                case "D":
                    double vald = (Double) cp.getConstant(cpIndex).getObject();
                    slots.setDouble(cpIndex, vald);
                    break;
                case "Ljava/lang/String;":
                    throw new RuntimeException("todo");
                    //todo
            }
        }
    }
}
