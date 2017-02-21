/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

import com.gabongao.jvm.classfile.*;

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
public class FieldRef extends MemberRef {
    private Field field;

    public FieldRef(ConstantPool constantPool, ConstantMemberrefInfo memberrefInfo) {
        super(constantPool, memberrefInfo);
    }

    public Field resolvedField() {
        if (field == null) {
            resolveFieldRef();
        }
        return field;
    }

    public void resolveFieldRef() {
        ClassStruct d = constantPool.getClassStruct();
        ClassStruct c = resolvedClass();
        field = lookupField(c, name, descriptor);
        if (field == null) {
            throw new RuntimeException("NoSuchFieldError");
        }
        if (!field.isAccessibleTo(d)) {
            throw new RuntimeException("IllegalAccessError");
        }
    }

    public Field lookupField(ClassStruct c, String name, String descriptor) {
        for (Field f : c.getFields()
                ) {
            if (f.getName().equals(name) && f.descriptor.equals(descriptor)) {
                return f;
            }
        }
        for (ClassStruct cs : c.getInterfaces()
                ) {
            Field field = lookupField(cs, name, descriptor);
            if (field != null) {
                return field;
            }
        }
        if (c.getSuperClass() != null) {
            return lookupField(c.getSuperClass(), name, descriptor);
        }
        return null;
    }
}
