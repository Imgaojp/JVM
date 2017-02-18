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
public class OperandStack {
    private int size = 0;
    private Slot[] slots;

    public OperandStack(int maxStacks) {
        if (maxStacks > 0) {
            slots = new Slot[maxStacks];
        } else {
            throw new RuntimeException("Operands Count Error");
        }
    }

    public void pushInt(int val) {
        slots[size] = new Slot();
        slots[size].setNum(val);
        size++;
    }

    public int popInt() {
        size--;
        return slots[size].getNum();
    }

    public void pushFloat(float val) {
        slots[size] = new Slot();
        slots[size].setNum(Float.floatToRawIntBits(val));
        size++;
    }

    public float popFloat() {
        size--;
        return Float.intBitsToFloat(slots[size].getNum());
    }

    public void pushLong(long val) {
        slots[size] = new Slot();
        slots[size].setNum((int) val);
        slots[size + 1] = new Slot();
        slots[size + 1].setNum((int) (val >> 32));
        size += 2;
    }

    public long popLong() {
        size -= 2;
        int high = slots[size + 1].getNum();
        int low = slots[size].getNum();
        return ((((long) high) << 32) & 0xffffffff00000000L) | (((long) low) & 0x00000000ffffffffL);
    }

    public void pushRef(Object ref) {
        slots[size] = new Slot();
        slots[size].setRef(ref);
        size++;
    }

    public Object popRef() {
        size--;
        Object ref = slots[size].getRef();
        slots[size].setRef(null);
        return ref;
    }


    public void pushDouble(double val) {
        pushLong(Double.doubleToRawLongBits(val));
    }

    public double popDouble() {
        return Double.longBitsToDouble(popLong());
    }
}
