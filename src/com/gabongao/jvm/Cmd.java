package com.gabongao.jvm;

import org.apache.commons.cli.*;

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
public class Cmd {

    boolean helpFlag = false;
    boolean versionFlag = false;
    String cpOption = "";
    String className = "";
    String Xjre = "";
    String[] args;

    /**
     * getter
     *
     * @return
     */
    public boolean isHelpFlag() {
        return helpFlag;
    }

    public boolean isVersionFlag() {
        return versionFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public String getClassName() {
        return className;
    }

    public String[] getArgs() {
        return args;
    }

    public String getXjre() {
        return Xjre;
    }

    /**
     * reset properties
     */
    public void reset() {
        this.helpFlag = false;
        this.versionFlag = false;
        this.cpOption = "";
        this.className = "";
        this.args = null;
        this.Xjre = "";
    }

    /**
     * ParseCmd
     *
     * @param args
     * @throws Exception
     */
    public void parseCmd(String[] args) throws Exception {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("version", false, "print version and exit");
        options.addOption("?", "help", false, "print help message");
        options.addOption("cp", "classpath", true, "classpath");
        options.addOption("Xjre", true, "path to jre");
        CommandLine commandLine = parser.parse(options, args);
        if (commandLine.hasOption("help") || commandLine.hasOption("?")) {
            this.helpFlag = true;
        }
        if (commandLine.hasOption("version")) {
            this.versionFlag = true;
        }

        if (commandLine.hasOption("cp")) {
            this.cpOption = commandLine.getOptionValue("cp");
        } else if (commandLine.hasOption("classpath")) {
            this.cpOption = commandLine.getOptionValue("classpath");
        }

        if (commandLine.hasOption("Xjre")) {
            this.Xjre = commandLine.getOptionValue("Xjre");
        }
        String[] commandLineArgs = commandLine.getArgs();
        if (commandLineArgs.length > 0) {
            this.className = commandLineArgs[0];
        }
        if (commandLineArgs.length > 1) {
            this.args = new String[commandLineArgs.length - 1];
            System.arraycopy(commandLineArgs, 1, this.args, 0, commandLineArgs.length - 1);
        }
    }

    /**
     * print usage
     *
     * @param args
     */
    public static void printUsage(String[] args) {
        System.out.println("Usage: java [-options] class [args...]\n");
    }

}
