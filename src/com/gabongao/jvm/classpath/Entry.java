package com.gabongao.jvm.classpath;

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
public abstract class Entry {
    static String pathListSeparator = System.getProperty("path.separator");//system path separator

    public static Entry newEntry(String path) {
//        if (path.contains(pathListSeparator)) {
//            return newCompositeEntry(path);
//        }
//        if (path.contains("*")) {
//            return new WildcardEntry(path);
//        }
        if (path.contains(".jar") || path.contains(".zip") || path.contains(".JAR") || path.contains(".ZIP")) {
            return new Entry_Zip(path);
        }
        return new Entry_Dir(path);
    }

    /**
     * read class from file
     *
     * @param className
     * @return
     */
    public abstract byte[] readClass(String className);

    /**
     * to string
     *
     * @return
     */
    public abstract String toString();

}
