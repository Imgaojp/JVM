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
import com.gabongao.jvm.rtda.heap.*;
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
public class Index16Instruction implements Instruction {
    protected char index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readUint16();
    }

    @Override
    public void execute(Frame frame) {
    }

    public class New extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            ClassRef classRef = (ClassRef) cp.getConstant(index).getObject();
            ClassStruct classStruct = classRef.resolvedClass();

            if (classStruct.IsInterface() || classStruct.IsAbstract()) {
                throw new RuntimeException("InstantiationError");
            }
            Object ref = classStruct.newObject();
            frame.getOperandStack().pushRef(ref);
        }

        //todo: index传值失败，父类的index为private，子类不能访问父类的值，因此默认初始值0.
        @Override
        public void fetchOperands(BytecodeReader bytecodeReader) {
            super.fetchOperands(bytecodeReader);
        }
    }

    public class PutStatic extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            Method currentMethod = frame.getMethod();
            ClassStruct currentClass = currentMethod.getClassMember().getClassStruct();
            ConstantPool cp = currentClass.getConstantPool();
            FieldRef fieldRef = (FieldRef) cp.getConstant(index).getObject();
            Field field = fieldRef.resolvedField();
            ClassStruct classStruct = field.getClassStruct();
            if (!field.IsStatic()) {
                throw new RuntimeException("IncompatibleClassChangeError");
            }
            if (field.IsFinal()) {
                if (currentClass != classStruct || !currentMethod.getClassMember().getName().equals("<clinit>")) {
                    throw new RuntimeException("IllegalAccessError");
                }
            }
            String descriptor = field.getDescriptor();
            int slotId = field.getSlotId();
            Slots slots = classStruct.getStaticVars();
            OperandStack operandStack = frame.getOperandStack();
            char[] des = descriptor.toCharArray();
            switch (des[0]) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    slots.setInt(slotId, operandStack.popInt());
                    break;
                case 'F':
                    slots.setFloat(slotId, operandStack.popFloat());
                    break;
                case 'J':
                    slots.setLong(slotId, operandStack.popLong());
                    break;
                case 'D':
                    slots.setDouble(slotId, operandStack.popDouble());
                    break;
                case 'L':
                case '[':
                    slots.setRef(slotId, operandStack.popRef());
                    break;
            }
        }
    }

    public class GetStatic extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            FieldRef fieldRef = (FieldRef) cp.getConstant(index).getObject();
            Field field = fieldRef.resolvedField();
            ClassStruct classStruct = field.getClassStruct();
            if (!field.IsStatic()) {
                throw new RuntimeException("IncompatibleClassChangeError");
            }
            String descriptor = field.getDescriptor();
            int slotId = field.getSlotId();
            Slots slots = classStruct.getStaticVars();
            OperandStack operandStack = frame.getOperandStack();
            char[] des = descriptor.toCharArray();
            switch (des[0]) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    operandStack.pushInt(slots.getInt(slotId));
                    break;
                case 'F':
                    operandStack.pushFloat(slots.getFloat(slotId));
                    break;
                case 'J':
                    operandStack.pushLong(slots.getLong(slotId));
                    break;
                case 'D':
                    operandStack.pushDouble(slots.getDouble(slotId));
                    break;
                case 'L':
                case '[':
                    operandStack.pushRef(slots.getRef(slotId));
                    break;
            }
        }
    }

    public class PutField extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            Method currentMethod = frame.getMethod();
            ClassStruct currentClass = currentMethod.getClassMember().getClassStruct();
            ConstantPool cp = currentClass.getConstantPool();
            FieldRef fieldRef = (FieldRef) cp.getConstant(index).getObject();
            Field field = fieldRef.resolvedField();
            if (field.IsStatic()) {
                throw new RuntimeException("IncompatibleClassChangeError");
            }
            if (field.IsFinal()) {
                if (currentClass != field.getClassStruct() || !currentMethod.getClassMember().getName().equals("<init>")) {
                    throw new RuntimeException("IllegalAccessError");
                }
            }
            String descriptor = field.getDescriptor();
            int slotId = field.getSlotId();
            OperandStack operandStack = frame.getOperandStack();
            char[] des = descriptor.toCharArray();
            switch (des[0]) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    int vali = operandStack.popInt();
                    Object refi = operandStack.popRef();
                    if (refi == null) {
                        throw new RuntimeException("NullPointerException");
                    }
                    refi.getFields().setInt(slotId, vali);
                    break;
                case 'F':
                    float valf = operandStack.popFloat();
                    Object reff = operandStack.popRef();
                    if (reff == null) {
                        throw new RuntimeException("NullPointerException");
                    }
                    reff.getFields().setFloat(slotId, valf);
                    break;
                case 'J':
                    long vall = operandStack.popLong();
                    Object refl = operandStack.popRef();
                    if (refl == null) {
                        throw new RuntimeException("NullPointerException");
                    }
                    refl.getFields().setLong(slotId, vall);
                    break;
                case 'D':
                    double vald = operandStack.popDouble();
                    Object refd = operandStack.popRef();
                    if (refd == null) {
                        throw new RuntimeException("NullPointerException");
                    }
                    refd.getFields().setDouble(slotId, vald);
                    break;
                case 'L':
                case '[':
                    Object valr = operandStack.popRef();
                    Object ref = operandStack.popRef();
                    if (ref == null) {
                        throw new RuntimeException("NullPointerException");
                    }
                    ref.getFields().setRef(slotId, valr);
                    break;
            }
        }
    }

    public class GetField extends Index16Instruction {

        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            FieldRef fieldRef = (FieldRef) cp.getConstant(index).getObject();
            Field field = fieldRef.resolvedField();
            if (field.IsStatic()) {
                throw new RuntimeException("IncompatibleClassChangeError");
            }

            OperandStack operandStack = frame.getOperandStack();
            Object ref = operandStack.popRef();
            if (ref == null) {
                throw new RuntimeException("NullPointerException");
            }
            String descriptor = field.getDescriptor();
            int slotId = field.getSlotId();
            Slots slots = ref.getFields();
            char[] des = descriptor.toCharArray();

            switch (des[0]) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    operandStack.pushInt(slots.getInt(slotId));
                    break;
                case 'F':
                    operandStack.pushFloat(slots.getFloat(slotId));
                    break;
                case 'J':
                    operandStack.pushLong(slots.getLong(slotId));
                    break;
                case 'D':
                    operandStack.pushDouble(slots.getDouble(slotId));
                    break;
                case 'L':
                case '[':
                    operandStack.pushRef(slots.getRef(slotId));
                    break;
            }
        }
    }

    public class InstanceOf extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Object ref = operandStack.popRef();
            if (ref == null) {
                operandStack.pushInt(0);
            }
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            ClassRef classRef = (ClassRef) cp.getConstant(index).getObject();
            ClassStruct classStruct = classRef.resolvedClass();
            if (ref.isInstanceOf(classStruct)) {
                operandStack.pushInt(1);
            } else {
                operandStack.pushInt(0);
            }
        }
    }

    public class CheckCast extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            OperandStack operandStack = frame.getOperandStack();
            Object ref = operandStack.popRef();
            operandStack.pushRef(ref);
            if (ref == null) {
                return;
            }
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            ClassRef classRef = (ClassRef) cp.getConstant(index).getObject();
            ClassStruct classStruct = classRef.resolvedClass();
            if (!ref.isInstanceOf(classStruct)) {
                throw new RuntimeException("ClassCastException");
            }
        }
    }

    public class InvokeSpecial extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().popRef();
        }
    }

    public class InvokeVirtual extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getClassStruct().getConstantPool();
            MethodRef methodRef = (MethodRef) cp.getConstant(index).getObject();
            if (methodRef.getName().equals("println")) {
                OperandStack operandStack = frame.getOperandStack();
                switch (methodRef.getDescriptor()) {
                    case "(Z)V":
                        System.out.println(operandStack.popInt() != 0);
                        break;
                    case "(C)V":
                        System.out.printf("%c\n", operandStack.popInt());
                        break;
                    case "(B)V":
                        System.out.println(operandStack.popInt());
                        break;
                    case "(S)V":
                        System.out.println(operandStack.popInt());
                        break;
                    case "(I)V":
                        System.out.println(operandStack.popInt());
                        break;
                    case "(J)V":
                        System.out.println(operandStack.popLong());
                        break;
                    case "(F)V":
                        System.out.println(operandStack.popFloat());
                        break;
                    case "(D)V":
                        System.out.println(operandStack.popDouble());
                        break;
                    default:
                        throw new RuntimeException("println:" + methodRef.getDescriptor());
                }
                operandStack.popRef();
            }
        }
    }
}
