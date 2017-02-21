/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.instructions;

import com.gabongao.jvm.rtda.Frame;
import com.gabongao.jvm.rtda.LocalVars;
import com.gabongao.jvm.rtda.OperandStack;
import com.gabongao.jvm.rtda.heap.ConstantPool;
import com.gabongao.jvm.rtda.heap.Object;

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
public class Index8Instruction implements Instruction {
    private char Index;

    public char getIndex() {
        return Index;
    }

    public void setIndex(char index) {
        Index = index;
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        Index = bytecodeReader.readUint8();
    }

    public void execute(Frame frame) {
    }

    ;

    public class Iload extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _iload(frame, getIndex());
        }

        public void _iload(Frame frame, int index) {
            int val = frame.getLocalVars().getInt(index);
            frame.getOperandStack().pushInt(val);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }

        public class Iload_0 extends Iload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _iload(frame, 0);
            }
        }

        public class Iload_1 extends Iload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _iload(frame, 1);
            }
        }

        public class Iload_2 extends Iload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _iload(frame, 2);
            }
        }

        public class Iload_3 extends Iload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _iload(frame, 3);
            }
        }

    }

    public class Aload extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _aload(frame, getIndex());
        }

        public void _aload(Frame frame, int index) {
            Object val = frame.getLocalVars().getRef(index);
            frame.getOperandStack().pushRef(val);
        }


        public class Aload_0 extends Aload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _aload(frame, 0);
            }
        }

        public class Aload_1 extends Aload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _aload(frame, 1);
            }
        }

        public class Aload_2 extends Aload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _aload(frame, 2);
            }
        }

        public class Aload_3 extends Aload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _aload(frame, 3);
            }
        }
    }

    public class Dload extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _dload(frame, getIndex());
        }

        public void _dload(Frame frame, int index) {
            double val = frame.getLocalVars().getDouble(index);
            frame.getOperandStack().pushDouble(val);
        }

        public class Dload_0 extends Dload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dload(frame, 0);
            }
        }

        public class Dload_1 extends Dload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dload(frame, 1);
            }
        }

        public class Dload_2 extends Dload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dload(frame, 2);
            }
        }

        public class Dload_3 extends Dload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dload(frame, 3);
            }
        }

    }

    public class Fload extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _fload(frame, getIndex());
        }

        public void _fload(Frame frame, int index) {
            float val = frame.getLocalVars().getFloat(index);
            frame.getOperandStack().pushFloat(val);
        }

        public class Fload_0 extends Fload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fload(frame, 0);
            }
        }

        public class Fload_1 extends Fload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fload(frame, 1);
            }
        }

        public class Fload_2 extends Fload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fload(frame, 2);
            }
        }

        public class Fload_3 extends Fload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fload(frame, 3);
            }
        }

    }

    public class Lload extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _lload(frame, getIndex());
        }

        public void _lload(Frame frame, int index) {
            long val = frame.getLocalVars().getLong(index);
            frame.getOperandStack().pushLong(val);
        }

        public class Lload_0 extends Lload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lload(frame, 0);
            }
        }

        public class Lload_1 extends Lload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lload(frame, 1);
            }
        }

        public class Lload_2 extends Lload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lload(frame, 2);
            }
        }

        public class Lload_3 extends Lload {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lload(frame, 3);
            }
        }

    }

    public class Lstore extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _lstore(frame, getIndex());
        }

        public void _lstore(Frame frame, int index) {
            Long val = frame.getOperandStack().popLong();
            frame.getLocalVars().setLong(index, val);
        }

        public class Lstore_0 extends Lstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lstore(frame, 0);
            }
        }

        public class Lstore_1 extends Lstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lstore(frame, 1);
            }
        }

        public class Lstore_2 extends Lstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lstore(frame, 2);
            }
        }

        public class Lstore_3 extends Lstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _lstore(frame, 3);
            }
        }

    }

    public class Astore extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _astore(frame, getIndex());
        }

        public void _astore(Frame frame, int index) {
            Object val = frame.getOperandStack().popRef();
            frame.getLocalVars().setRef(index, val);
        }

        public class Astore_0 extends Astore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _astore(frame, 0);
            }
        }

        public class Astore_1 extends Astore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _astore(frame, 1);
            }
        }

        public class Astore_2 extends Astore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _astore(frame, 2);
            }
        }

        public class Astore_3 extends Astore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _astore(frame, 3);
            }
        }

    }

    public class Istore extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _istore(frame, getIndex());
        }

        public void _istore(Frame frame, int index) {
            int val = frame.getOperandStack().popInt();
            frame.getLocalVars().setInt(index, val);
        }

        public class Istore_0 extends Istore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _istore(frame, 0);
            }
        }

        public class Istore_1 extends Istore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _istore(frame, 1);
            }
        }

        public class Istore_2 extends Istore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _istore(frame, 2);
            }
        }

        public class Istore_3 extends Istore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _istore(frame, 3);
            }
        }

    }

    public class Dstore extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _dstore(frame, getIndex());
        }

        public void _dstore(Frame frame, int index) {
            double val = frame.getOperandStack().popDouble();
            frame.getLocalVars().setDouble(index, val);
        }

        public class Dstore_0 extends Dstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dstore(frame, 0);
            }
        }

        public class Dstore_1 extends Dstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dstore(frame, 1);
            }
        }

        public class Dstore_2 extends Dstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dstore(frame, 2);
            }
        }

        public class Dstore_3 extends Dstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _dstore(frame, 3);
            }
        }
    }

    public class Fstore extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _fstore(frame, getIndex());
        }

        public void _fstore(Frame frame, int index) {
            float val = frame.getOperandStack().popFloat();
            frame.getLocalVars().setFloat(index, val);
        }

        public class Fstore_0 extends Fstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fstore(frame, 0);
            }
        }

        public class Fstore_1 extends Fstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fstore(frame, 1);
            }
        }

        public class Fstore_2 extends Fstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fstore(frame, 2);
            }
        }

        public class Fstore_3 extends Fstore {
            @Override
            public void fetchOperands(BytecodeReader bytecodeReader) {

            }

            @Override
            public void execute(Frame frame) {
                _fstore(frame, 3);
            }
        }
    }

    public class Iinc extends Index8Instruction {
        private int constVal;

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.setIndex(bytecodeReader.readUint8());
            constVal = bytecodeReader.readInt8();
        }

        @Override
        public void execute(Frame frame) {
            LocalVars localVars = frame.getLocalVars();
            localVars.setInt(super.getIndex(), localVars.getInt(super.getIndex()) + constVal);
        }
    }

    public class Ldc extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            _ldc(frame, super.getIndex());
        }

        public void _ldc(Frame frame, int index) {
            OperandStack operandStack = frame.getOperandStack();
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            java.lang.Object c = cp.getConstant(index).getObject();
            if (c instanceof Integer) {
                operandStack.pushInt((int) c);
            } else if (c instanceof Float) {
                operandStack.pushFloat((float) c);
            } else {
                throw new RuntimeException("todo : ldc");
            } //todo
        }
    }

    public class Ldc_W extends Ldc {
        @Override
        public void execute(Frame frame) {
            super.execute(frame);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            Index = bytecodeReader.readUint16();
        }
    }

    public class Ldc2_W extends Ldc_W {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            java.lang.Object c = cp.getConstant(Index).getObject();
            if (c instanceof Long) {
                operandStack.pushLong((long) c);
            } else if (c instanceof Double) {
                operandStack.pushDouble((double) c);
            } else {
                throw new RuntimeException("ClassFormatError");
            }
        }
    }



}