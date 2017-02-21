/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.instructions;

import com.gabongao.jvm.rtda.Frame;
import com.gabongao.jvm.rtda.heap.Object;
import com.gabongao.jvm.rtda.OperandStack;

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
public class BranchInstruction implements Instruction {
    private int offset;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        offset = bytecodeReader.readInt16();
    }

    @Override
    public void execute(Frame frame) {
    }


    public void branch(Frame frame, int offset) {
        int pc = frame.getThread().getPc();
        int nextPc = pc + offset;
        frame.setNextPc(nextPc);
    }

    public class Ifeq extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val == 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class Ifne extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val != 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class Iflt extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val < 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class Ifle extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val <= 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class Ifgt extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val > 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class Ifge extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int val = frame.getOperandStack().popInt();
            if (val >= 0) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmpne extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 != val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmpeq extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 == val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmplt extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 < val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmple extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 <= val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmpgt extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 > val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_icmpge extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            int val2 = operandStack.popInt();
            int val1 = operandStack.popInt();
            if (val1 >= val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_acmpeq extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Object val2 = operandStack.popRef();
            Object val1 = operandStack.popRef();
            if (val1 == val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class If_acmpne extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Object val2 = operandStack.popRef();
            Object val1 = operandStack.popRef();
            if (val1 != val2) {
                branch(frame, super.offset);
            }
        }
    }

    public class Goto extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            branch(frame, super.offset);
        }
    }

    public class Goto_W extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            branch(frame, super.offset);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.offset = bytecodeReader.readInt32();
        }
    }

    public class TableSwitch extends BranchInstruction {
        int low, high, defaultOffset;
        int[] jumpOffsets;

        @Override
        public void execute(Frame frame) {
            int index = frame.getOperandStack().popInt();
            int offset;
            if ((index >= low) && (index <= high)) {
                offset = (jumpOffsets[index - low]);
            } else {
                offset = defaultOffset;
            }
            branch(frame, offset);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            bytecodeReader.skipPadding();
            defaultOffset = bytecodeReader.readInt32();
            low = bytecodeReader.readInt32();
            high = bytecodeReader.readInt32();
            int jumpOffsetsCount = high - low + 1;
            jumpOffsets = bytecodeReader.readInt32s(jumpOffsetsCount);
        }
    }

    public class LookUpSwitch extends BranchInstruction {
        int defaultOffset, npairs;
        int[] matchOffsets;

        @Override
        public void execute(Frame frame) {
            int key = frame.getOperandStack().popInt();
            for (int i = 0; i < npairs * 2; i += 2) {
                if (matchOffsets[i] == key) {
                    branch(frame, matchOffsets[i + 1]);
                    return;
                }
            }
            branch(frame, defaultOffset);
        }

        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            bytecodeReader.skipPadding();
            defaultOffset = bytecodeReader.readInt32();
            npairs = bytecodeReader.readInt32();
            matchOffsets = bytecodeReader.readInt32s(npairs * 2);
        }
    }

    public class Ifnull extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            Object ref = frame.getOperandStack().popRef();
            if (ref == null) {
                branch(frame, super.offset);
            }
        }
    }

    public class Ifnonnull extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            Object ref = frame.getOperandStack().popRef();
            if (ref != null) {
                branch(frame, super.offset);
            }
        }
    }
}
