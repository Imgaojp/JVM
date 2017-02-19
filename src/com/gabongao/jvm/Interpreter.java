/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm;

import com.gabongao.jvm.classfile.AttrCode;
import com.gabongao.jvm.classfile.AttributeInfo;
import com.gabongao.jvm.classfile.MemberInfo;
import com.gabongao.jvm.instructions.*;
import com.gabongao.jvm.rtda.Frame;
import com.gabongao.jvm.rtda.Thread;

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
 * Created by Imgaojp on 2017/2/19.
 */
public class Interpreter {
    public void doInterpreter(MemberInfo memberInfo) {
        AttrCode codeAttr = memberInfo.getCodeAttribure();
        int maxLocals = codeAttr.getMaxLocals();
        int maxStack = codeAttr.getMaxStack();
        byte[] byteCode = codeAttr.getCode();
        Thread thread = new Thread();
        Frame frame = new Frame(thread, maxLocals, maxStack);
        thread.pushFrame(frame);
        try {
            loop(thread, byteCode);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            System.out.printf("LocalVars: %s\n", frame.getLocalVars());
            System.out.printf("OperandStack: %s\n", frame.getOperandStack());
        }
    }

    public void loop(Thread thread, byte[] byteCode) {
        Frame frame = thread.popFrame();
        BytecodeReader bytecodeReader = new BytecodeReader();
        int n = 1;
        for (; ; ) {
            int pc = frame.getNextPc();
            thread.setPc(pc);
            System.out.printf("loop: %2d\t", n);
            bytecodeReader.reset(byteCode, pc);
            char opcode = (char) bytecodeReader.readInt8();
            Instruction instruction = Factory.newInstruction((byte) opcode);
            instruction.fetchOperands(bytecodeReader);
            if (n == 13 || n == 14) {
                System.out.printf("%d\t", bytecodeReader.getPc());
            }
            frame.setNextPc(bytecodeReader.getPc());
            System.out.printf("pc:%2d\t inst:%s\n", pc, instruction.getClass().getName());
            instruction.execute(frame);
            n++;
        }
    }


}
