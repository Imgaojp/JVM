package com.gabongao.jvm;

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
    private static void startJvm(Cmd cmd) {
        /* ch01
        System.out.printf("classpath: %s class: %s args:%s\n", cmd.getCpOption(), cmd.getClassName(), Arrays.asList(cmd.getArgs()).toString());
        */

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
    }
}
