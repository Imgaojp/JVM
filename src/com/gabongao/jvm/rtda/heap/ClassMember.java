/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

import com.gabongao.jvm.classfile.AttrConstantValue;
import com.gabongao.jvm.classfile.MemberInfo;

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
public class ClassMember {
    protected char accessFlags;
    protected String name, descriptor;
    private ClassStruct classStruct;

    public ClassMember(MemberInfo memberInfo) {
        this.accessFlags = memberInfo.getAccessFlags();
        this.name = memberInfo.getName();
        this.descriptor = memberInfo.getDescriptor();
    }

    public boolean isAccessibleTo(ClassStruct d) {
        if (IsPublic()) {
            return true;
        }
        ClassStruct c = classStruct;
        if (IsProtected()) {
            return d.equals(c) || d.isSubClassOf(c) || c.getPackageName().equals(d.getPackageName());
        }
        if (!IsPrivate()) {
            return c.getPackageName().equals(d.getPackageName());
        }
        return d.equals(c);
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public ClassStruct getClassStruct() {
        return classStruct;
    }

    public void setClassStruct(ClassStruct classStruct) {
        this.classStruct = classStruct;
    }

    public char getAccessFlags() {
        return accessFlags;
    }

    public boolean IsFinal() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_FINAL.getValue());
    }

    public boolean IsSynthetic() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_SYNTHETIC.getValue());
    }

    public boolean IsEnum() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_ENUM.getValue());
    }

    public boolean IsPublic() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_PUBLIC.getValue());
    }

    public boolean IsPrivate() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_PRIVATE.getValue());
    }

    public boolean IsProtected() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_PROTECTED.getValue());
    }

    public boolean IsStatic() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_STATIC.getValue());
    }

    public boolean IsVolatile() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_VOLATILE.getValue());
    }

    public boolean IsTransient() {
        return 0 != (((int) accessFlags) & AccessFlags.ACCESS_TRANSIENT.getValue());
    }

}
