/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.rtda;

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
public class LocalVars {
    private Slot[] slots;

    LocalVars(int maxLocals) {
        if (maxLocals > 0) {
            slots = new Slot[maxLocals];
        } else {
            throw new RuntimeException("LocalVars Count Error");
        }
    }

    public void setInt(int index, int val) {
        slots[index] = new Slot();
        slots[index].setNum(val);
    }

    public int getInt(int index) {
        return slots[index].getNum();
    }

    public void setFloat(int index, float val) {
        slots[index] = new Slot();
        slots[index].setNum(Float.floatToRawIntBits(val));
    }

    public float getFloat(int index) {
        return Float.intBitsToFloat(slots[index].getNum());
    }

    public void setLong(int index, long val) {
        slots[index] = new Slot();
        slots[index].setNum((int) val);
        slots[index + 1] = new Slot();
        slots[index + 1].setNum((int) (val >> 32));
    }

    public long getLong(int index) {
        int low = slots[index].getNum();
        int high = slots[index + 1].getNum();
        return ((((long) high) << 32) & 0xffffffff00000000L) | (((long) low) & 0x00000000ffffffffL);
    }

    public void setRef(int index, Object ref) {
        slots[index] = new Slot();
        slots[index].setRef(ref);
    }

    public Object getRef(int index) {
        return slots[index].getRef();
    }

    public void setDouble(int index, double val) {
        setLong(index, Double.doubleToRawLongBits(val));
    }

    public double getDouble(int index) {
        return Double.longBitsToDouble(getLong(index));
    }
}
