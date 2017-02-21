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
public class Field extends ClassMember {
    private int slotId;
    private int constValueIndex;

    public Field(MemberInfo memberInfo) {
        super(memberInfo);
        AttrConstantValue attr = memberInfo.getConstantValueAttribute();
        if (attr != null) {
            constValueIndex = attr.getConstantValueIndex();
        }
    }

    public int getConstValueIndex() {
        return constValueIndex;
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


    public char getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(char accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isLongOrDouble() {
        return descriptor.equals("J") || descriptor.equals("D");
    }
}
