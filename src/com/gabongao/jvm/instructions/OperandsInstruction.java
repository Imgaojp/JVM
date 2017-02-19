/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.instructions;

import com.gabongao.jvm.rtda.Frame;
import com.gabongao.jvm.rtda.OperandStack;
import com.gabongao.jvm.rtda.Slot;
import com.gabongao.jvm.rtda.Stack;
import org.ietf.jgss.Oid;
import sun.awt.OSInfo;

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
public class OperandsInstruction implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        //TODO
    }

    public void execute(Frame frame) {
    }

    ;

    public class Nop extends OperandsInstruction {

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {

        }
    }

    public class Aconst_null extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushRef(null);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }
    }

    public class Dconst_0 extends OperandsInstruction {

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushDouble(0.0);
        }
    }

    public class Dconst_1 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushDouble(1.0);
        }
    }

    public class Fconst_0 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushFloat(0.0f);
        }
    }

    public class Fconst_1 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushFloat(1.0f);
        }
    }

    public class Fconst_2 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushDouble(2.0f);
        }
    }

    public class Iconst_M1 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(-1);
        }
    }

    public class Iconst_0 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(0);
        }
    }

    public class Iconst_1 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(1);
        }
    }

    public class Iconst_2 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(2);
        }
    }

    public class Iconst_3 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(3);
        }
    }

    public class Iconst_4 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(4);
        }
    }

    public class Iconst_5 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(5);
        }
    }

    public class Lconst_0 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushLong(0L);
        }
    }

    public class Lconst_1 extends OperandsInstruction {
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushLong(1L);
        }
    }

    public class Bipush extends OperandsInstruction {
        byte val;

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            val = (byte) bytecodeReader.readUint8();
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt((int) val);
        }
    }

    public class Sipush extends OperandsInstruction {
        char val;

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            val = bytecodeReader.readUint16();
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt((int) val);
        }
    }

    public class Pop extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            operandStack.popSlot();
        }
    }

    public class Pop2 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            operandStack.popSlot();
            operandStack.popSlot();
        }
    }

    public class Dup extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot = operandStack.popSlot();
            operandStack.pushSlot(slot);
            operandStack.pushSlot(slot);
        }
    }

    public class Dup_X1 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
        }
    }

    public class Dup_X2 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            Slot slot3 = operandStack.popSlot();
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot3);
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
        }
    }

    public class Dup2 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
        }
    }

    public class Dup2_X1 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            Slot slot3 = operandStack.popSlot();
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot3);
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
        }
    }

    public class Dup2_X2 extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            Slot slot3 = operandStack.popSlot();
            Slot slot4 = operandStack.popSlot();
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot4);
            operandStack.pushSlot(slot3);
            operandStack.pushSlot(slot2);
            operandStack.pushSlot(slot1);
        }
    }

    public class Swap extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Slot slot1 = operandStack.popSlot();
            Slot slot2 = operandStack.popSlot();
            operandStack.pushSlot(slot1);
            operandStack.pushSlot(slot2);
        }
    }

    public class Irem extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            int v2 = stack.popInt();
            int v1 = stack.popInt();
            if (v2 == 0) {
                throw new RuntimeException("ArithmeticException");
            }
            stack.pushInt(v1 % v2);
        }
    }

    public class Lrem extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            long v2 = stack.popLong();
            long v1 = stack.popLong();
            if (v2 == 0) {
                throw new RuntimeException("ArithmeticException");
            }
            stack.pushLong(v1 % v2);
        }
    }

    public class Frem extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            float v2 = stack.popFloat();
            float v1 = stack.popFloat();
            stack.pushFloat(v1 % v2);
        }
    }

    public class Drem extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            double v2 = stack.popDouble();
            double v1 = stack.popDouble();
            stack.pushDouble(v1 % v2);
        }
    }

    public class Idiv extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            int v2 = stack.popInt();
            int v1 = stack.popInt();
            if (v2 == 0) {
                throw new RuntimeException("ArithmeticException");
            }
            stack.pushInt(v1 / v2);
        }
    }

    public class Ldiv extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            long v2 = stack.popLong();
            long v1 = stack.popLong();
            if (v2 == 0) {
                throw new RuntimeException("ArithmeticException");
            }
            stack.pushLong(v1 / v2);
        }
    }

    public class Fdiv extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            float v2 = stack.popFloat();
            float v1 = stack.popFloat();
            stack.pushFloat(v1 / v2);
        }
    }

    public class Ddiv extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            double v2 = stack.popDouble();
            double v1 = stack.popDouble();
            stack.pushDouble(v1 / v2);
        }
    }

    public class Iadd extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 + v2);
        }
    }

    public class Dadd extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double v2 = operandStack.popDouble();
            double v1 = operandStack.popDouble();
            operandStack.pushDouble(v1 + v2);
        }
    }

    public class Fadd extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float v2 = operandStack.popFloat();
            float v1 = operandStack.popFloat();
            operandStack.pushFloat(v1 + v2);
        }
    }

    public class Ladd extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 + v2);
        }
    }

    public class Isub extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 - v2);
        }
    }

    public class Dsub extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double v2 = operandStack.popDouble();
            double v1 = operandStack.popDouble();
            operandStack.pushDouble(v1 - v2);
        }
    }

    public class Fsub extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float v2 = operandStack.popFloat();
            float v1 = operandStack.popFloat();
            operandStack.pushFloat(v1 - v2);
        }
    }

    public class Lsub extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 - v2);
        }
    }

    public class Imul extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 * v2);
        }
    }

    public class Dmul extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double v2 = operandStack.popDouble();
            double v1 = operandStack.popDouble();
            operandStack.pushDouble(v1 * v2);
        }
    }

    public class Fmul extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float v2 = operandStack.popFloat();
            float v1 = operandStack.popFloat();
            operandStack.pushFloat(v1 * v2);
        }
    }

    public class Lmul extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 * v2);
        }
    }

    public class Ineg extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val = operandStack.popInt();
            operandStack.pushInt(-val);
        }
    }

    public class Dneg extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double val = operandStack.popDouble();
            operandStack.pushDouble(-val);
        }
    }

    public class Fneg extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float val = operandStack.popFloat();
            operandStack.pushFloat(-val);
        }
    }

    public class Lneg extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long val = operandStack.popLong();
            operandStack.pushLong(-val);
        }
    }

    public class Ishl extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 << v2);
        }
    }

    public class Ishr extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 >> v2);
        }
    }

    public class Iushr extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 >>> v2);
        }
    }

    public class Lshl extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 << v2);
        }
    }

    public class Lshr extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 >> v2);
        }
    }

    public class Lushr extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 >>> v2);
        }
    }

    public class Iand extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 & v2);
        }
    }

    public class Land extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 & v2);
        }
    }

    public class Ior extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 | v2);
        }
    }

    public class Lor extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 | v2);
        }
    }

    public class Ixor extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int v2 = operandStack.popInt();
            int v1 = operandStack.popInt();
            operandStack.pushInt(v1 ^ v2);
        }
    }

    public class Lxor extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            operandStack.pushLong(v1 ^ v2);
        }
    }

    public class D2f extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double d = operandStack.popDouble();
            operandStack.pushFloat((float) d);
        }
    }

    public class D2i extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double d = operandStack.popDouble();
            operandStack.pushInt((int) d);
        }
    }

    public class D2l extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            double d = operandStack.popDouble();
            operandStack.pushLong((long) d);
        }
    }

    public class I2f extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int i = operandStack.popInt();
            operandStack.pushFloat((float) i);
        }
    }

    public class I2d extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int i = operandStack.popInt();
            operandStack.pushDouble((double) i);
        }
    }

    public class I2l extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int i = operandStack.popInt();
            operandStack.pushLong((long) i);
        }
    }

    public class F2i extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float f = operandStack.popFloat();
            operandStack.pushInt((int) f);
        }
    }

    public class F2d extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float f = operandStack.popFloat();
            operandStack.pushDouble((double) f);
        }
    }

    public class F2l extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            float f = operandStack.popFloat();
            operandStack.pushLong((long) f);
        }
    }

    public class L2i extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long l = operandStack.popLong();
            operandStack.pushInt((int) l);
        }
    }

    public class L2d extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long l = operandStack.popLong();
            operandStack.pushDouble((double) l);
        }
    }

    public class L2f extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long l = operandStack.popLong();
            operandStack.pushFloat((float) l);
        }
    }

    public class Lcmp extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            long v2 = operandStack.popLong();
            long v1 = operandStack.popLong();
            if (v1 > v2) {
                operandStack.pushInt(1);
            } else if (v1 == v2) {
                operandStack.pushInt(0);
            } else {
                operandStack.pushInt(-1);
            }
        }
    }

    public class Fcmp extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
        }

        public void _fcmp(Frame frame, boolean gFlag) {
            OperandStack operandStack = frame.getOperandStack();
            float v2 = operandStack.popFloat();
            float v1 = operandStack.popFloat();
            if (v1 > v2) {
                operandStack.pushInt(1);
            } else if (v1 == v2) {
                operandStack.pushInt(0);
            } else if (v1 < v2) {
                operandStack.pushInt(-1);
            } else if (gFlag) {
                operandStack.pushInt(1);
            } else {
                operandStack.pushInt(-1);
            }
        }

        public class Fcmpg extends Fcmp {
            @Override
            public void execute(Frame frame) {
                _fcmp(frame, true);
            }
        }

        public class Fcmpl extends Fcmp {
            @Override
            public void execute(Frame frame) {
                _fcmp(frame, false);
            }
        }
    }

    public class Dcmp extends OperandsInstruction {
        @Override
        public void execute(Frame frame) {
        }

        public void _dcmp(Frame frame, boolean gFlag) {
            OperandStack operandStack = frame.getOperandStack();
            double v2 = operandStack.popDouble();
            double v1 = operandStack.popDouble();
            if (v1 > v2) {
                operandStack.pushInt(1);
            } else if (v1 == v2) {
                operandStack.pushInt(0);
            } else if (v1 < v2) {
                operandStack.pushInt(-1);
            } else if (gFlag) {
                operandStack.pushInt(1);
            } else {
                operandStack.pushInt(-1);
            }
        }

        public class Dcmpg extends Dcmp {
            @Override
            public void execute(Frame frame) {
                _dcmp(frame, true);
            }
        }

        public class Dcmpl extends Dcmp {
            @Override
            public void execute(Frame frame) {
                _dcmp(frame, false);
            }
        }
    }

}
