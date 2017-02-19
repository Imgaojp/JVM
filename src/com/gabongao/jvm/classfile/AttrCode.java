/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.classfile;

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
 * Created by Imgaojp on 2017/2/18.
 */
public class AttrCode implements AttributeInfo {
    byte[] code;
    private char maxStack, maxLocals;
    private ConstantPool constantPool;
    private AttributeInfo[] attributes;
    private ExceptionTableEntry[] exceptionTableEntries;


    public AttrCode(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        maxStack = classReader.readUint16();
        maxLocals = classReader.readUint16();
        int codeLength = classReader.readUint32();
        code = classReader.readBytes(codeLength);
        exceptionTableEntries = readExceptionTable(classReader);
        attributes = ClassFile.readAttributes(classReader, constantPool);
    }

    public char getMaxStack() {
        return maxStack;
    }

    public char getMaxLocals() {
        return maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public ExceptionTableEntry[] getExceptionTableEntries() {
        return exceptionTableEntries;
    }

    public ExceptionTableEntry[] readExceptionTable(ClassReader classReader) {
        char exceptionTableLength = classReader.readUint16();
        ExceptionTableEntry[] exceptionTableEntries = new ExceptionTableEntry[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTableEntries[i] = new ExceptionTableEntry(classReader.readUint16(), classReader.readUint16(), classReader.readUint16(), classReader.readUint16());
        }
        return exceptionTableEntries;
    }

    class ExceptionTableEntry {
        char startPc, endPc, handlerPc, catchType;

        ExceptionTableEntry(char startPc, char endPc, char handlerPc, char catchType) {
            this.startPc = startPc;
            this.endPc = endPc;
            this.handlerPc = handlerPc;
            this.catchType = catchType;
        }
    }
}
