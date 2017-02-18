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
public class AttrLocalVariableTable implements AttributeInfo {
    LocalVariableTableEntry[] localVariableTable;

    @Override
    public void readInfo(ClassReader classReader) {
        char localVariableTableLength = classReader.readUint16();
        localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
        for (int i = 0; i < localVariableTableLength; i++) {
            localVariableTable[i] = new LocalVariableTableEntry(classReader.readUint16(), classReader.readUint16(), classReader.readUint16(), classReader.readUint16(), classReader.readUint16());
        }
    }

    class LocalVariableTableEntry {
        char startPc, length, nameIndex, descriptorIndex, index;

        LocalVariableTableEntry(char startPc, char length, char nameIndex, char descriptorIndex, char index) {
            this.startPc = startPc;
            this.length = length;
            this.nameIndex = nameIndex;
            this.descriptorIndex = descriptorIndex;
            this.index = index;
        }

        public char getStartPc() {
            return startPc;
        }

        public void setStartPc(char startPc) {
            this.startPc = startPc;
        }

        public char getLength() {
            return length;
        }

        public void setLength(char length) {
            this.length = length;
        }

        public char getNameIndex() {
            return nameIndex;
        }

        public void setNameIndex(char nameIndex) {
            this.nameIndex = nameIndex;
        }

        public char getDescriptorIndex() {
            return descriptorIndex;
        }

        public void setDescriptorIndex(char descriptorIndex) {
            this.descriptorIndex = descriptorIndex;
        }

        public char getIndex() {
            return index;
        }

        public void setIndex(char index) {
            this.index = index;
        }
    }
}
