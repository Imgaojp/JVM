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
 * Created by Imgaojp on 2017/2/19.
 */
public class Factory {

    static OperandsInstruction operandsInstruction = new OperandsInstruction();
    static BranchInstruction branchInstruction = new BranchInstruction();
    static Index8Instruction index8Instruction = new Index8Instruction();

    public static Instruction newInstruction(byte opcode) {
        switch (Byte.toUnsignedInt(opcode)) {
            case 0x00:
                return operandsInstruction.new Nop();
            case 0x01:
                return operandsInstruction.new Aconst_null();
            case 0x02:
                return operandsInstruction.new Iconst_M1();
            case 0x03:
                return operandsInstruction.new Iconst_0();
            case 0x04:
                return operandsInstruction.new Iconst_1();
            case 0x05:
                return operandsInstruction.new Iconst_2();
            case 0x06:
                return operandsInstruction.new Iconst_3();
            case 0x07:
                return operandsInstruction.new Iconst_4();
            case 0x08:
                return operandsInstruction.new Iconst_5();
            case 0x09:
                return operandsInstruction.new Lconst_0();
            case 0x0a:
                return operandsInstruction.new Lconst_1();
            case 0x0b:
                return operandsInstruction.new Fconst_0();
            case 0x0c:
                return operandsInstruction.new Fconst_1();
            case 0x0d:
                return operandsInstruction.new Fconst_2();
            case 0x0e:
                return operandsInstruction.new Dconst_0();
            case 0x0f:
                return operandsInstruction.new Dconst_1();
            case 0x10:
                return operandsInstruction.new Bipush();
            case 0x11:
                return operandsInstruction.new Sipush();
            //case 0x12:
            //	return &LDC{}
            //case 0x13:
            //	return &LDC_W{}
            //case 0x14:
            //	return &LDC2_W{}
            case 0x15:
                return index8Instruction.new Iload();
            case 0x16:
                return index8Instruction.new Lload();
            case 0x17:
                return index8Instruction.new Fload();
            case 0x18:
                return index8Instruction.new Dload();
            case 0x19:
                return index8Instruction.new Aload();
            case 0x1a:
                return (index8Instruction.new Iload()).new Iload_0();
            case 0x1b:
                return (index8Instruction.new Iload()).new Iload_1();
            case 0x1c:
                return (index8Instruction.new Iload()).new Iload_2();
            case 0x1d:
                return (index8Instruction.new Iload()).new Iload_3();
            case 0x1e:
                return (index8Instruction.new Lload()).new Lload_0();
            case 0x1f:
                return (index8Instruction.new Lload()).new Lload_1();
            case 0x20:
                return (index8Instruction.new Lload()).new Lload_2();
            case 0x21:
                return (index8Instruction.new Lload()).new Lload_3();
            case 0x22:
                return (index8Instruction.new Fload()).new Fload_0();
            case 0x23:
                return (index8Instruction.new Fload()).new Fload_1();
            case 0x24:
                return (index8Instruction.new Fload()).new Fload_2();
            case 0x25:
                return (index8Instruction.new Fload()).new Fload_3();
            case 0x26:
                return (index8Instruction.new Dload()).new Dload_0();
            case 0x27:
                return (index8Instruction.new Dload()).new Dload_1();
            case 0x28:
                return (index8Instruction.new Dload()).new Dload_2();
            case 0x29:
                return (index8Instruction.new Dload()).new Dload_3();
            case 0x2a:
                return (index8Instruction.new Aload()).new Aload_0();
            case 0x2b:
                return (index8Instruction.new Aload()).new Aload_1();
            case 0x2c:
                return (index8Instruction.new Aload()).new Aload_2();
            case 0x2d:
                return (index8Instruction.new Aload()).new Aload_3();
            //case 0x2e:
            //	return iaload
            //case 0x2f:
            //	return laload
            //case 0x30:
            //	return faload
            //case 0x31:
            //	return daload
            //case 0x32:
            //	return aaload
            //case 0x33:
            //	return baload
            //case 0x34:
            //	return caload
            //case 0x35:
            //	return saload
            case 0x36:
                return index8Instruction.new Istore();
            case 0x37:
                return index8Instruction.new Lstore();

            case 0x38:
                return index8Instruction.new Fstore();

            case 0x39:
                return index8Instruction.new Dstore();

            case 0x3a:
                return index8Instruction.new Astore();

            case 0x3b:
                return (index8Instruction.new Istore()).new Istore_0();
            case 0x3c:
                return (index8Instruction.new Istore()).new Istore_1();
            case 0x3d:
                return (index8Instruction.new Istore()).new Istore_2();
            case 0x3e:
                return (index8Instruction.new Istore()).new Istore_3();
            case 0x3f:
                return (index8Instruction.new Lstore()).new Lstore_0();
            case 0x40:
                return (index8Instruction.new Lstore()).new Lstore_1();
            case 0x41:
                return (index8Instruction.new Lstore()).new Lstore_2();
            case 0x42:
                return (index8Instruction.new Lstore()).new Lstore_3();
            case 0x43:
                return (index8Instruction.new Fstore()).new Fstore_0();
            case 0x44:
                return (index8Instruction.new Fstore()).new Fstore_1();
            case 0x45:
                return (index8Instruction.new Fstore()).new Fstore_2();
            case 0x46:
                return (index8Instruction.new Fstore()).new Fstore_3();
            case 0x47:
                return (index8Instruction.new Dstore()).new Dstore_0();
            case 0x48:
                return (index8Instruction.new Dstore()).new Dstore_1();
            case 0x49:
                return (index8Instruction.new Dstore()).new Dstore_2();
            case 0x4a:
                return (index8Instruction.new Dstore()).new Dstore_3();
            case 0x4b:
                return (index8Instruction.new Astore()).new Astore_0();
            case 0x4c:
                return (index8Instruction.new Astore()).new Astore_1();
            case 0x4d:
                return (index8Instruction.new Astore()).new Astore_2();
            case 0x4e:
                return (index8Instruction.new Astore()).new Astore_3();
            //case 0x4f:
            //	return iastore
            //case 0x50:
            //	return lastore
            //case 0x51:
            //	return fastore
            //case 0x52:
            //	return dastore
            //case 0x53:
            //	return aastore
            //case 0x54:
            //	return bastore
            //case 0x55:
            //	return castore
            //case 0x56:
            //	return sastore
            case 0x57:
                return operandsInstruction.new Pop();
            case 0x58:
                return operandsInstruction.new Pop2();
            case 0x59:
                return operandsInstruction.new Dup();
            case 0x5a:
                return operandsInstruction.new Dup_X1();
            case 0x5b:
                return operandsInstruction.new Dup_X2();
            case 0x5c:
                return operandsInstruction.new Dup2();
            case 0x5d:
                return operandsInstruction.new Dup2_X1();
            case 0x5e:
                return operandsInstruction.new Dup2_X2();
            case 0x5f:
                return operandsInstruction.new Swap();
            case 0x60:
                return operandsInstruction.new Iadd();
            case 0x61:
                return operandsInstruction.new Ladd();
            case 0x62:
                return operandsInstruction.new Fadd();
            case 0x63:
                return operandsInstruction.new Dadd();
            case 0x64:
                return operandsInstruction.new Isub();
            case 0x65:
                return operandsInstruction.new Lsub();
            case 0x66:
                return operandsInstruction.new Fsub();
            case 0x67:
                return operandsInstruction.new Dsub();
            case 0x68:
                return operandsInstruction.new Imul();
            case 0x69:
                return operandsInstruction.new Lmul();
            case 0x6a:
                return operandsInstruction.new Fmul();
            case 0x6b:
                return operandsInstruction.new Dmul();
            case 0x6c:
                return operandsInstruction.new Idiv();
            case 0x6d:
                return operandsInstruction.new Ldiv();
            case 0x6e:
                return operandsInstruction.new Fdiv();
            case 0x6f:
                return operandsInstruction.new Ddiv();
            case 0x70:
                return operandsInstruction.new Irem();
            case 0x71:
                return operandsInstruction.new Lrem();
            case 0x72:
                return operandsInstruction.new Frem();
            case 0x73:
                return operandsInstruction.new Drem();
            case 0x74:
                return operandsInstruction.new Ineg();
            case 0x75:
                return operandsInstruction.new Lneg();
            case 0x76:
                return operandsInstruction.new Fneg();
            case 0x77:
                return operandsInstruction.new Dneg();
            case 0x78:
                return operandsInstruction.new Ishl();
            case 0x79:
                return operandsInstruction.new Lshl();
            case 0x7a:
                return operandsInstruction.new Ishr();
            case 0x7b:
                return operandsInstruction.new Lshr();
            case 0x7c:
                return operandsInstruction.new Iushr();
            case 0x7d:
                return operandsInstruction.new Lushr();
            case 0x7e:
                return operandsInstruction.new Iand();
            case 0x7f:
                return operandsInstruction.new Land();
            case 0x80:
                return operandsInstruction.new Ior();
            case 0x81:
                return operandsInstruction.new Lor();
            case 0x82:
                return operandsInstruction.new Ixor();
            case 0x83:
                return operandsInstruction.new Lxor();
            case 0x84:
                return index8Instruction.new Iinc();
            case 0x85:
                return operandsInstruction.new I2l();
            case 0x86:
                return operandsInstruction.new I2f();
            case 0x87:
                return operandsInstruction.new I2d();
            case 0x88:
                return operandsInstruction.new L2i();
            case 0x89:
                return operandsInstruction.new L2f();
            case 0x8a:
                return operandsInstruction.new L2d();
            case 0x8b:
                return operandsInstruction.new F2i();
            case 0x8c:
                return operandsInstruction.new F2l();
            case 0x8d:
                return operandsInstruction.new F2d();
            case 0x8e:
                return operandsInstruction.new D2i();
            case 0x8f:
                return operandsInstruction.new D2l();
            case 0x90:
                return operandsInstruction.new D2f();
//            case 0x91:
//                return operandsInstruction.new I2b();
//            case 0x92:
//                return i2c
//            case 0x93:
//                return i2s
            case 0x94:
                return operandsInstruction.new Lcmp();
            case 0x95:
                return (operandsInstruction.new Fcmp()).new Fcmpl();
            case 0x96:
                return (operandsInstruction.new Fcmp()).new Fcmpg();
            case 0x97:
                return (operandsInstruction.new Dcmp()).new Dcmpl();
            case 0x98:
                return (operandsInstruction.new Dcmp()).new Dcmpg();
            case 0x99:
                return branchInstruction.new Ifeq();
            case 0x9a:
                return branchInstruction.new Ifne();
            case 0x9b:
                return branchInstruction.new Iflt();
            case 0x9c:
                return branchInstruction.new Ifge();
            case 0x9d:
                return branchInstruction.new Ifgt();
            case 0x9e:
                return branchInstruction.new Ifle();
            case 0x9f:
                return branchInstruction.new If_icmpeq();
            case 0xa0:
                return branchInstruction.new If_icmpne();
            case 0xa1:
                return branchInstruction.new If_icmplt();
            case 0xa2:
                return branchInstruction.new If_icmpge();
            case 0xa3:
                return branchInstruction.new If_icmpgt();
            case 0xa4:
                return branchInstruction.new If_icmple();
            case 0xa5:
                return branchInstruction.new If_acmpeq();
            case 0xa6:
                return branchInstruction.new If_acmpne();
            case 0xa7:
                return branchInstruction.new Goto();
//            case 0xa8:
//                return &control.JSR {
//            }
//            case 0xa9:
//                return &control.RET {
//            }
            case 0xaa:
                return branchInstruction.new TableSwitch();
            case 0xab:
                return branchInstruction.new LookUpSwitch();
//
//            case 0xac:
//                return ireturn
//            case 0xad:
//                return lreturn
//            case 0xae:
//                return freturn
//            case 0xaf:
//                return dreturn
//            case 0xb0:
//                return areturn
//            case 0xb1:
//                return _return
            //case 0xb2:
            //	return &GET_STATIC{}
            //case 0xb3:
            //	return &PUT_STATIC{}
            //case 0xb4:
            //	return &GET_FIELD{}
            //case 0xb5:
            //	return &PUT_FIELD{}
            //case 0xb6:
            //	return &INVOKE_VIRTUAL{}
            //case 0xb7:
            //	return &INVOKE_SPECIAL{}
            //case 0xb8:
            //	return &INVOKE_STATIC{}
            //case 0xb9:
            //	return &INVOKE_INTERFACE{}
            //case 0xba:
            //	return &INVOKE_DYNAMIC{}
            //case 0xbb:
            //	return &NEW{}
            //case 0xbc:
            //	return &NEW_ARRAY{}
            //case 0xbd:
            //	return &ANEW_ARRAY{}
            //case 0xbe:
            //	return arraylength
            //case 0xbf:
            //	return athrow
            //case 0xc0:
            //	return &CHECK_CAST{}
            //case 0xc1:
            //	return &INSTANCE_OF{}
            //case 0xc2:
            //	return monitorenter
            //case 0xc3:
            //	return monitorexit
//            case 0xc4:
//                return &extended.WIDE {
//            }
            //case 0xc5:
            //	return &MULTI_ANEW_ARRAY{}
            case 0xc6:
                return branchInstruction.new Ifnull();
            case 0xc7:
                return branchInstruction.new Ifnonnull();
            case 0xc8:
                return branchInstruction.new Goto_W();
//            case 0xc9:
//                return &control.JSR_W {
//            }
            ////case 0xca: todo breakpoint
            //case 0xfe:
            //	return invoke_native // impdep1
            //case 0xff:
            //	return &BOOTSTRAP{} // impdep2
            default:
                throw new RuntimeException(String.format("Bad opcode: 0X%X", opcode));
        }

    }
}
