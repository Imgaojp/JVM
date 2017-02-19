/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.instructions;

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
public class BytecodeReader {
    private byte[] code;
    private int pc;

    public void reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    public int getPc() {
        return pc;
    }

    public char readUint8() {
        byte b = code[pc];
        pc++;
        return (char) b;
    }

    public char readUint16() {
//        Byte.toUnsignedInt((byte) readUint8());
        char high = (char) (readUint8() << 8);
        char low = readUint8();
        char res = (char) ((high & 0xff00) | (low & 0x00ff));
        return res;
    }

    public int readInt8() {
        return (int) readUint8();
    }

    public int readInt16() {
        char uint16 = readUint16();
        if (uint16 >> 15 == 1) {
            return (((~(uint16 - 1)) & 0x000000007f) * -1);
        } else {
            return uint16;
        }
    }

    public int readInt32() {
        return (((((int) readUint8()) << 24) & 0xff000000) | ((((int) readUint8()) << 16) & 0x00ff0000) | ((((int) readUint8()) << 8) & 0x0000ff00) | ((((int) readUint8())) & 0x000000ff));
    }

    public void skipPadding() {
        while ((pc % 4) != 0) {
            readInt8();
        }
    }

    public int[] readInt32s(int count) {
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = readInt32();
        }
        return ints;
    }
}
