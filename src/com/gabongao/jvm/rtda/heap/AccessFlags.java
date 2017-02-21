/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda.heap;

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
public enum AccessFlags {
    ACCESS_PUBLIC(0X0001),              //class field method
    ACCESS_PRIVATE(0X0002),             //      field method
    ACCESS_PROTECTED(0X0004),           //      field method
    ACCESS_STATIC(0X0008),              //      field method
    ACCESS_FINAL(0X0010),               //class field method
    ACCESS_SUPER(0X0020),               //class
    ACCESS_SYNCHRONIZED(0X0020),        //            method
    ACCESS_VOLATILE(0X0040),            //      field
    ACCESS_BRIDGE(0X0040),              //            method
    ACCESS_TRANSIENT(0X0080),           //      field
    ACCESS_VARARGS(0X0080),             //            method
    ACCESS_NATIVE(0X0100),              //            method
    ACCESS_INTERFACE(0X0200),           //class
    ACCESS_ABSTRACT(0X0400),            //class       method
    ACCESS_STRICT(0X0800),              //            method
    ACCESS_SYNTHETIC(0X1000),           //class field method
    ACCESS_ANNOTATION(0X2000),          //class
    ACCESS_ENUM(0X4000),                //class field
    ;
    private int value;

    AccessFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
