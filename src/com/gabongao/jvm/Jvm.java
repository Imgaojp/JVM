package com.gabongao.jvm;

import com.gabongao.jvm.classfile.ClassFile;
import com.gabongao.jvm.classfile.MemberInfo;
import com.gabongao.jvm.classpath.ClassPath;
import com.gabongao.jvm.rtda.Frame;
import com.gabongao.jvm.rtda.LocalVars;
import com.gabongao.jvm.rtda.OperandStack;
import com.gabongao.jvm.rtda.heap.ClassLoader;
import com.gabongao.jvm.rtda.heap.ClassStruct;
import com.gabongao.jvm.rtda.heap.Method;

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
 * Created by Imgaojp on 2017/2/16.
 */
public class Jvm {
    public static void main(String[] args) throws Exception {
        Cmd cmd = new Cmd();
        cmd.parseCmd(args);
        if (cmd.isVersionFlag()) {
            System.out.println("version 0.0.1");
        } else if (cmd.isHelpFlag()) {
            Cmd.printUsage(args);
        } else {
            startJvm(cmd);
        }
    }

    public static void startJvm(Cmd cmd) {
        /* ch01
        System.out.printf("classpath: %s class: %s args:%s\n", cmd.getCpOption(), cmd.getClassName(), Arrays.asList(cmd.getArgs()).toString());
        */

        /* ch02
        ClassPath cp = new ClassPath();
        cp.parse(cmd.jreOption, cmd.cpOption);
        System.out.printf("classpath: %s\tclass: %s\targs: %s\n",cmd.cpOption,cmd.getClassName, Arrays.asList(cmd.args));
        String getClassName = cmd.getClassName.replace(".", "/").concat(".class");
        byte[] classData = cp.readClass(getClassName);
        if (classData == null) {
            System.out.printf("Could not load main class %s\n",getClassName);
            System.exit(1);
        }
        for (byte b:classData
             ) {
            System.out.printf("%X",b);
        }
        */


        /* ch03
        ClassPath cp = new ClassPath();
        cp.parse(cmd.jreOption, cmd.cpOption);
        String getClassName = cmd.getClassName.replace(".", "/").concat(".class");
        ClassFile classFile = new ClassFile(cp.readClass(getClassName));
        classFile.read();
        System.out.println(cmd.getClassName);
        printClassInfo(classFile);
    }

    public static void printClassInfo(ClassFile classFile) {
        System.out.printf("version: %d.%d\n", (int) classFile.getMajorVersion(), (int) classFile.getMinorVersion());
        System.out.printf("constants count: %d\n", (classFile.getConstantPool()).getConstantInfos().length);
        System.out.printf("access flags: 0X%X\n", (int) classFile.getAccessFlags());
        System.out.printf("this class: %s\n", classFile.thisClassName());
        System.out.printf("super class: %s\n", classFile.superClassName());
        if (classFile.interfaceNames().length > 0) {
            System.out.printf("interfaces: %s\n", Arrays.asList(classFile.interfaceNames()));
        }
        System.out.printf("fields: %d\n", (classFile.getFields()).length);
        for (int i = 0; i < classFile.getFields().length; i++) {
            System.out.printf("\t\t%s\n", classFile.getFields()[i].getName());
        }
        System.out.println("methods count : " + classFile.getMethods().length);
        for (int i = 0; i < classFile.getMethods().length; i++) {
            System.out.printf("\t\t%s\n", classFile.getMethods()[i].getName());
        }
        */

        // ch04
        /*
        Frame frame = new Frame(100, 100);
        testLocalVars(frame.getLocalVars());
        testOperandStack(frame.getOperandStack());
        */

        //ch05

//        Interpreter interpreter = new Interpreter();
//        ClassPath cp = new ClassPath();
//        cp.parse(cmd.jreOption, cmd.cpOption);
//        String className = cmd.className.replace(".", "/").concat(".class");
//        ClassFile classFile = loadClass(className, cp);
//        classFile.read();
//        MemberInfo mainMethod = getMainMethod(classFile);
//        if (mainMethod != null) {
//            interpreter.doInterpreter(mainMethod);
//        } else {
//            System.out.printf("Main method not found in class %s\n", className);
//        }


        Interpreter interpreter = new Interpreter();
        ClassPath cp = new ClassPath();

        ClassLoader classLoader = new ClassLoader(cp);
        cp.parse(cmd.jreOption, cmd.cpOption);
//        String className = cmd.className.replace(".", "/").concat(".class");
        String className = cmd.className;
        ClassStruct mainClass = classLoader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();
//        ClassFile classFile = loadClass(className, cp);
//        classFile.read();
//        MemberInfo mainMethod = getMainMethod(classFile);
        if (mainMethod != null) {
            interpreter.doInterpreter(mainMethod);
        } else {
            System.out.printf("Main method not found in class %s\n", className);
        }


    }

    public static MemberInfo getMainMethod(ClassFile classFile) {
        for (MemberInfo methodInfo : classFile.getMethods()
                ) {
            if ("main".equals(methodInfo.getName()) && methodInfo.getDescriptor().equals("([Ljava/lang/String;)V")) {
                return methodInfo;
            }
        }
        return null;
    }


    public static ClassFile loadClass(String className, ClassPath classPath) {
        byte[] classData = classPath.readClass(className);
        return new ClassFile(classData);
    }

    private static void testLocalVars(LocalVars localVars) {
        localVars.setInt(0, 100);
        localVars.setInt(1, -100);
        localVars.setInt(2, -100000);
        localVars.setLong(3, 2997924580L);
        localVars.setLong(5, -2997924580L);
        localVars.setFloat(7, 3.1415926f);
        localVars.setDouble(8, -2.7814897347028520974);
        localVars.setRef(10, null);
        System.out.println(localVars.getInt(0));
        System.out.println(localVars.getInt(1));
        System.out.println(localVars.getInt(2));
        System.out.println(localVars.getLong(3));
        System.out.println(localVars.getLong(5));
        System.out.println(localVars.getFloat(7));
        System.out.println(localVars.getDouble(8));
        System.out.println(localVars.getRef(10));
    }

    private static void testOperandStack(OperandStack operandStack) {
        operandStack.pushInt(100);
        operandStack.pushInt(-100);
        operandStack.pushInt(-100000);
        operandStack.pushLong(2997924580L);
        operandStack.pushLong(-2997924580L);
        operandStack.pushFloat(3.1415926f);
        operandStack.pushDouble(-2.7814897347028520974);
        operandStack.pushRef(null);
        System.out.println(operandStack.popRef());
        System.out.println(operandStack.popDouble());
        System.out.println(operandStack.popFloat());
        System.out.println(operandStack.popLong());
        System.out.println(operandStack.popLong());
        System.out.println(operandStack.popInt());
        System.out.println(operandStack.popInt());
        System.out.println(operandStack.popInt());
    }

}
