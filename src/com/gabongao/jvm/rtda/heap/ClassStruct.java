/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

import com.gabongao.jvm.classfile.*;

import java.lang.*;
import java.lang.Object;
import java.util.Arrays;

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
public class ClassStruct {
    private char accessFlags;
    private String className, superClassName;
    private String[] interfaceNames;
    private ConstantPool constantPool;
    private Field[] fields;
    private Method[] methods;
    private ClassLoader classLoader;
    private ClassStruct superClass;
    private ClassStruct[] interfaces;
    private int instanceSlotCount, staticSlotCount;
    private Slots staticVars;

    public ClassStruct(ClassFile classFile) {
        this.accessFlags = classFile.getAccessFlags();
        this.className = classFile.thisClassName();
        this.superClassName = classFile.superClassName();
        this.interfaceNames = classFile.interfaceNames();
        this.constantPool = newConstantPool(classFile.getConstantPool());
        this.fields = newFields(classFile.getFields());
        this.methods = newMethods(classFile.getMethods());
    }

    public com.gabongao.jvm.rtda.heap.Object newObject() {
        return new com.gabongao.jvm.rtda.heap.Object(this);
    }

    private ConstantPool newConstantPool(com.gabongao.jvm.classfile.ConstantPool cfCp) {
        int cpCount = cfCp.getConstantInfos().length;
        Constant[] constants = new Constant[cpCount];
        ConstantPool rtCp = new ConstantPool(this, constants);
        for (int i = 1; i < cpCount; i++) {
            ConstantInfo cpInfo = cfCp.getConstantInfos()[i];
            switch (cpInfo.getClass().getName()) {
                case "com.gabongao.jvm.classfile.ConstantIntegerInfo":
                    ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo) cpInfo;
                    constants[i] = new Constant(constantIntegerInfo.getVal());
                    break;
                case "com.gabongao.jvm.classfile.ConstantLongInfo":
                    ConstantLongInfo constantLongInfo = (ConstantLongInfo) cpInfo;
                    constants[i] = new Constant(constantLongInfo.getVal());
                    i++;
                    break;
                case "com.gabongao.jvm.classfile.ConstantDoubleInfo":
                    ConstantDoubleInfo constantDoubleInfo = (ConstantDoubleInfo) cpInfo;
                    constants[i] = new Constant(constantDoubleInfo.getVal());
                    break;
                case "com.gabongao.jvm.classfile.ConstantStringInfo":
                    ConstantStringInfo constantStringInfo = (ConstantStringInfo) cpInfo;
                    constants[i] = new Constant(constantStringInfo.getString());
                    break;
                case "com.gabongao.jvm.classfile.ConstantClassInfo":
                    ConstantClassInfo classInfo = (ConstantClassInfo) cpInfo;
                    ClassRef classRef = new ClassRef(rtCp, classInfo);
//                    classRef.setClassStruct(this);
                    constants[i] = new Constant(classRef);
                    break;
                case "com.gabongao.jvm.classfile.ConstantFieldrefInfo":
                    ConstantFieldrefInfo fieldrefInfo = (ConstantFieldrefInfo) cpInfo;
                    FieldRef ref = new FieldRef(rtCp, fieldrefInfo);
//                    ref.setClassStruct(this);
                    constants[i] = new Constant(ref);
                    break;
                case "com.gabongao.jvm.classfile.ConstantMethodrefInfo":
                    ConstantMethodrefInfo methodrefInfo = (ConstantMethodrefInfo) cpInfo;
                    MethodRef methodRef = new MethodRef(rtCp, methodrefInfo);
//                    methodRef.setClassStruct(this);
                    constants[i] = new Constant(methodRef);
                    break;
                case "com.gabongao.jvm.classfile.ConstantInterfaceMethodrefInfo":
                    ConstantInterfaceMethodrefInfo interfaceMethodrefInfo = (ConstantInterfaceMethodrefInfo) cpInfo;
                    InterfaceMethodRef interfaceMethodRef = new InterfaceMethodRef(rtCp, interfaceMethodrefInfo);
//                    interfaceMethodRef.setClassStruct(this);
                    constants[i] = new Constant(interfaceMethodRef);
                    break;
            }
        }
        return rtCp;
    }

    private Method[] newMethods(MemberInfo[] cfMethods) {
        Method[] methods = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i] = new Method(cfMethods[i]);
            methods[i].getClassMember().setClassStruct(this);
        }
        return methods;
    }

    private Field[] newFields(MemberInfo[] cfFields) {
        Field[] fields = new Field[cfFields.length];
        for (int i = 0; i < cfFields.length; i++) {
            fields[i] = new Field(cfFields[i]);
            fields[i].setClassStruct(this);
        }
        return fields;
    }

    public boolean isAccessibleTo(ClassStruct other) {
        return this.IsPublic() || this.getPackageName().equals(other.getPackageName());
    }

    public boolean isSubClassOf(ClassStruct other) {
        for (ClassStruct c = superClass; c != null; c = c.superClass) {
            if (c == other) {
                return true;
            }
        }
        return false;
    }

    public String getPackageName() {
        int i = className.lastIndexOf("/");
        if (i >= 0) {
            return className.substring(0, i);
        }
        return "";
    }

    public boolean IsPublic() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_PUBLIC.getValue());
    }

    public boolean IsFinal() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_FINAL.getValue());
    }

    public boolean IsSuper() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_SUPER.getValue());
    }

    public boolean IsInterface() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_INTERFACE.getValue());
    }

    public boolean IsAbstract() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_ABSTRACT.getValue());
    }

    public boolean IsSynthetic() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_SYNTHETIC.getValue());
    }

    public boolean IsAnnotation() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_ANNOTATION.getValue());
    }

    public boolean IsEnum() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_ENUM.getValue());
    }

    public char getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(char accessFlags) {
        this.accessFlags = accessFlags;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public String[] getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(String[] interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassStruct getSuperClass() {
        return superClass;
    }

    public void setSuperClass(ClassStruct superClass) {
        this.superClass = superClass;
    }

    public ClassStruct[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(ClassStruct[] interfaces) {
        this.interfaces = interfaces;
    }

    public int getInstanceSlotCount() {
        return instanceSlotCount;
    }

    public void setInstanceSlotCount(int instanceSlotCount) {
        this.instanceSlotCount = instanceSlotCount;
    }

    public int getStaticSlotCount() {
        return staticSlotCount;
    }

    public void setStaticSlotCount(int staticSlotCount) {
        this.staticSlotCount = staticSlotCount;
    }

    public Slots getStaticVars() {
        return staticVars;
    }

    public void setStaticVars(Slots staticVars) {
        this.staticVars = staticVars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassStruct)) return false;

        ClassStruct that = (ClassStruct) o;

        if (getAccessFlags() != that.getAccessFlags()) return false;
        if (getInstanceSlotCount() != that.getInstanceSlotCount()) return false;
        if (getStaticSlotCount() != that.getStaticSlotCount()) return false;
        if (!getClassName().equals(that.getClassName())) return false;
        if (!getSuperClassName().equals(that.getSuperClassName())) return false;
        if (!getConstantPool().equals(that.getConstantPool())) return false;
        if (!getClassLoader().equals(that.getClassLoader())) return false;
        if (!getSuperClass().equals(that.getSuperClass())) return false;
        return getStaticVars().equals(that.getStaticVars());
    }

    @Override
    public int hashCode() {
        int result = (int) getAccessFlags();
        result = 31 * result + (getClassName() != null ? getClassName().hashCode() : 0);
        result = 31 * result + (getSuperClassName() != null ? getSuperClassName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getInterfaceNames());
        result = 31 * result + (getConstantPool() != null ? getConstantPool().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFields());
        result = 31 * result + Arrays.hashCode(getMethods());
        result = 31 * result + (getClassLoader() != null ? getClassLoader().hashCode() : 0);
        result = 31 * result + (getSuperClass() != null ? getSuperClass().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getInterfaces());
        result = 31 * result + getInstanceSlotCount();
        result = 31 * result + getStaticSlotCount();
        result = 31 * result + (getStaticVars() != null ? getStaticVars().hashCode() : 0);
        return result;
    }

    public boolean isAssignableFrom(ClassStruct other) {
        ClassStruct s = other;
        ClassStruct t = this;
        if (s.equals(t)) {
            return true;
        }
        if (!t.IsInterface()) {
            return s.isSubClassOf(t);
        } else {
            return s.isImplements(t);
        }
    }

    public boolean isImplements(ClassStruct iface) {
        for (ClassStruct c = this.superClass; c != null; c = c.getSuperClass()) {
            for (ClassStruct cs : c.interfaces
                    ) {
                if (cs.equals(iface) || cs.isSubInterfaceOf(iface)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubInterfaceOf(ClassStruct iface) {
        for (ClassStruct superInterface : this.interfaces
                ) {
            if (superInterface.equals(iface) || superInterface.isSubInterfaceOf(iface)) {
                return true;
            }
        }
        return false;
    }

    public Method getMainMethod() {
        return this.getStaticMethod("main", "([Ljava/lang/String;)V");
    }

    public Method getStaticMethod(String name, String descriptor) {
        for (Method method : methods
                ) {
            if (method.IsStatic() && method.getClassMember().getName().equals(name) && method.getClassMember().getDescriptor().equals(descriptor)) {
                return method;
            }
        }
        return null;
    }
}
