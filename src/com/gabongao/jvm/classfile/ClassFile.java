/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gabongao.jvm.classfile;

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
public class ClassFile {
    static final int CONSTANT_Class = 7;
    static final int CONSTANT_Fieldref = 9;
    static final int CONSTANT_Methodref = 10;
    static final int CONSTANT_InterfaceMethodref = 11;
    static final int CONSTANT_String = 8;
    static final int CONSTANT_Integer = 3;
    static final int CONSTANT_Float = 4;
    static final int CONSTANT_Long = 5;
    static final int CONSTANT_Double = 6;
    static final int CONSTANT_NameAndType = 12;
    static final int CONSTANT_Utf8 = 1;
    static final int CONSTANT_MethodHandle = 15;
    static final int CONSTANT_MethodType = 16;
    static final int CONSTANT_InvokeDynamic = 18;
    char majorVersion;
    ConstantPool constantPool;
    char accessFlags;
    char thisClass;
    char superClass;
    char[] interfaces;
    MemberInfo[] fields;
    MemberInfo[] methods;
    AttributeInfo[] attributes;
    ClassReader classReader;
    private char minorVersion;

    public ClassFile(byte[] classData) {
        this.classReader = new ClassReader(classData);
    }

    public static AttributeInfo[] readAttributes(ClassReader classReader, ConstantPool constantPool) {
        char attributesCount = classReader.readUint16();
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = readAttribute(classReader, constantPool);
        }
        return attributes;
    }

    public static AttributeInfo readAttribute(ClassReader cr, ConstantPool cp) {
        char attrNameIndex = cr.readUint16();
        String attrName = cp.getUTF8(attrNameIndex);
        int attrlen = cr.readUint32();
        AttributeInfo attrInfo = newAttributeInfo(attrName, attrlen, cp);
        attrInfo.readInfo(cr);
        return attrInfo;
    }

    public static AttributeInfo newAttributeInfo(String attrName, int attrlen, ConstantPool cp) {
        switch (attrName) {
            case "Code":
                return new AttrCode(cp);
            case "ConstantValue":
                return new AttrConstantValue();
            case "Deprecated":
                return new AttrDeprecated();
            case "Exceptions":
                return new AttrExceptions();
            case "LineNumberTable":
                return new AttrLineNumberTable();
            case "LocalVariableTable":
                return new AttrLocalVariableTable();
            case "SourceFile":
                return new AttrSourceFile(cp);
            case "Synthetic":
                return new AttrSynthetic();
            default:
                return new AttrUnparsed(attrName, attrlen);
        }
    }

    public void read() {
        readAndCheckMagic();
        readAndCheckVersion();
        constantPool = readConstantPool();
        accessFlags = classReader.readUint16();
        thisClass = classReader.readUint16();
        superClass = classReader.readUint16();
        interfaces = classReader.readUint16s();
        fields = readMembers(constantPool);
        methods = readMembers(constantPool);
        attributes = readAttributes(classReader, constantPool);
    }

    public void readAndCheckMagic() {
        int magicReadFromFile = classReader.readUint32();
        int magic = ((0xcafe << 16) & 0xffff0000) | ((0xbabe) & 0x0000ffff);
        if (magicReadFromFile != magic) {
            throw new RuntimeException("Class format error:Magic");
        }
    }

    public MemberInfo[] readMembers(ConstantPool cp) {
        int memberCount = classReader.readUint16();
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i++) {
            members[i] = new MemberInfo(classReader, cp);
        }
        return members;
    }

    public ConstantPool readConstantPool() {
        int cpCount = classReader.readUint16();
        ConstantInfo[] constantInfos = new ConstantInfo[cpCount];
        for (int i = 1; i < cpCount; i++) {
            constantInfos[i] = readConstantInfo();
            if (constantInfos[i] instanceof ConstantLongInfo || constantInfos[i] instanceof ConstantDoubleInfo) {
                i++;
            }
        }
        ConstantPool cp = new ConstantPool();
        cp.setConstantInfos(constantInfos);
        return cp;
    }

    public ConstantInfo readConstantInfo() {
        int tag = classReader.readUint8();
        ConstantInfo constantInfo = newConstantInfo(tag, constantPool);
        constantInfo.readInfo(classReader);
        return constantInfo;
    }

    public ConstantInfo newConstantInfo(int tag, ConstantPool constantPool) {
        switch (tag) {
            case CONSTANT_Integer:
                return new ConstantIntegerInfo();
            case CONSTANT_Float:
                return new ConstantFloatInfo();
            case CONSTANT_Long:
                return new ConstantLongInfo();
            case CONSTANT_Double:
                return new ConstantDoubleInfo();
            case CONSTANT_Utf8:
                return new ConstantUtf8Info();
            case CONSTANT_String:
                return new ConstantStringInfo(constantPool);
            case CONSTANT_Class:
                return new ConstantClassInfo(constantPool);
            case CONSTANT_Fieldref:
                return new ConstantFieldrefInfo(constantPool);
            case CONSTANT_Methodref:
                return new ConstantMethodrefInfo(constantPool);
            case CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMemberrefInfo(constantPool);
            case CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo();
//            case CONSTANT_MethodType:
//                return new ConstantInterInfo();
//            case CONSTANT_MethodHandle:
//                return new ConstantInterInfo();
//            case CONSTANT_InvokeDynamic:
//                return new ConstantInterInfo();
            default:
                throw new RuntimeException("Class format error:constant pool tag");
        }
    }


    public void readAndCheckVersion() {
        minorVersion = classReader.readUint16();
        majorVersion = classReader.readUint16();
        switch (majorVersion) {
            case 45:
                break;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (minorVersion == 0) {
                    break;
                }
            default:
                throw new RuntimeException("Unsupported class version");
        }
    }

    public String thisClassName() {
        return constantPool.getClassName(thisClass);
    }

    public String superClassName() {
        if (superClass > 0) {
            return constantPool.getClassName(superClass);
        }
        return "";
    }

    public String[] interfaceNames() {
        String[] interfaceNames = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            interfaceNames[i] = constantPool.getClassName(interfaces[i]);
        }
        return interfaceNames;
    }


    public char getMinorVersion() {
        return minorVersion;
    }

    public char getMajorVersion() {
        return majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public char getAccessFlags() {
        return accessFlags;
    }

    public MemberInfo[] getFields() {
        return fields;
    }

    public MemberInfo[] getMethods() {
        return methods;
    }
}
