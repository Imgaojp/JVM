package com.gabongao.jvm.classfile;

import java.awt.*;

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
 * Created by Imgaojp on 2017/2/17.
 */
public class ClassReader {
    public byte[] data;

    public ClassReader(byte[] classData) {
        this.data = classData;
    }

    public byte readUint8() {
        byte[] tempData = this.data;
        data = new byte[tempData.length - 1];
        System.arraycopy(tempData, 1, data, 0, tempData.length - 1);
        return tempData[0];
    }

    public char readUint16() {
        byte[] tempData = this.data;
        data = new byte[tempData.length - 2];
        System.arraycopy(tempData, 2, data, 0, tempData.length - 2);
        return (char) (((((char) tempData[0]) << 8) & 0xff00) | (((char) tempData[1]) & 0x00ff));
    }

    public int readUint32() {
        byte[] tempData = this.data;
        data = new byte[tempData.length - 4];
        System.arraycopy(tempData, 4, data, 0, tempData.length - 4);
        return ((((int) tempData[0]) << 24) & 0xff000000) | ((((int) tempData[1]) << 16) & 0x00ff0000) | ((((int) tempData[2]) << 8) & 0x0000ff00) | (((int) tempData[3]) & 0x000000ff);
    }

    public long readUint64() {
        byte[] tempData = this.data;
        data = new byte[tempData.length - 8];
        System.arraycopy(tempData, 8, data, 0, tempData.length - 8);
        return (((((long) tempData[0]) << 56) & 0xff00000000000000L) | ((((long) tempData[1]) << 48) & 0x00ff000000000000L) | ((((long) tempData[2]) << 40) & 0x0000ff0000000000L) | (((long) tempData[3] << 32) & 0x000000ff00000000L)) & 0xffffffff00000000L | (((((long) tempData[4]) << 24) & 0xff000000) | ((((long) tempData[5]) << 16) & 0x00ff0000) | ((((long) tempData[6]) << 8) & 0x0000ff00) | (((long) tempData[7]) & 0x000000ff)) & 0x00000000ffffffffL;
    }

    public char[] readUint16s() {
        int n = readUint16();
        if (n == 0) {
            return null;
        }
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = readUint16();
        }
//        byte[] tempData = this.data;
//        data = new byte[tempData.length - (n )];
//        System.arraycopy(tempData, (n + 1), data, 0, tempData.length - (n + 1));
        return chars;
    }

    public byte[] readBytes(int length) {
        byte[] tempData = this.data;
        data = new byte[tempData.length - length];
        System.arraycopy(tempData, length, data, 0, tempData.length - length);
        byte[] res = new byte[length];
        System.arraycopy(tempData, 0, res, 0, length);
        return res;
    }
}
