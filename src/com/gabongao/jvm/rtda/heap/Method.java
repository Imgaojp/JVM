/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

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
public class Method {
    ClassMember classMember;
    int maxStack, maxLocals;
    byte[] code;

    Method(MemberInfo memberInfo) {
        classMember = new ClassMember(memberInfo);
        maxLocals = memberInfo.getCodeAttribure() == null ? 0 : memberInfo.getCodeAttribure().getMaxLocals();
        maxStack = memberInfo.getCodeAttribure() == null ? 0 : memberInfo.getCodeAttribure().getMaxStack();
        code = memberInfo.getCodeAttribure() == null ? null : memberInfo.getCodeAttribure().getCode();
    }

    public ClassMember getClassMember() {
        return classMember;
    }

    public void setClassMember(ClassMember classMember) {
        this.classMember = classMember;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public boolean IsFinal() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_FINAL.getValue());
    }

    public boolean IsAbstract() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_ABSTRACT.getValue());
    }

    public boolean IsSynthetic() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_SYNTHETIC.getValue());
    }

    public boolean IsPublic() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_PUBLIC.getValue());
    }

    public boolean IsPrivate() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_PRIVATE.getValue());
    }

    public boolean IsProtected() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_PROTECTED.getValue());
    }

    public boolean IsStatic() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_STATIC.getValue());
    }

    public boolean IsSynchronized() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_SYNCHRONIZED.getValue());
    }

    public boolean IsBridge() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_BRIDGE.getValue());
    }

    public boolean IsVarargs() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_VARARGS.getValue());
    }

    public boolean IsNative() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_NATIVE.getValue());
    }

    public boolean IsStrict() {
        return 0 != (((int) classMember.accessFlags) & AccessFlags.ACCESS_STRICT.getValue());
    }

    public char getAccessFlags() {
        return classMember.accessFlags;
    }

    public void setAccessFlags(char accessFlags) {
        this.classMember.accessFlags = accessFlags;
    }


}
