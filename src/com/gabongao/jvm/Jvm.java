package com.gabongao.jvm;

import com.gabongao.jvm.classfile.ClassFile;
import com.gabongao.jvm.classpath.ClassPath;

import java.io.File;
import java.util.Arrays;

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
        System.out.printf("classpath: %s\tclass: %s\targs: %s\n",cmd.cpOption,cmd.className, Arrays.asList(cmd.args));
        String className = cmd.className.replace(".", "/").concat(".class");
        byte[] classData = cp.readClass(className);
        if (classData == null) {
            System.out.printf("Could not load main class %s\n",className);
            System.exit(1);
        }
        for (byte b:classData
             ) {
            System.out.printf("%X",b);
        }
        */

        ClassPath cp = new ClassPath();
        cp.parse(cmd.jreOption, cmd.cpOption);
        String className = cmd.className.replace(".", "/").concat(".class");
        ClassFile classFile = new ClassFile(cp.readClass(className));
        classFile.read();
        System.out.println(cmd.className);
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

    }

}
