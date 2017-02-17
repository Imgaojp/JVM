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

//    public Entry newEntry(String path) {
//        if (path.contains(pathListSeparator)) {
//            return newCompositeEntry(path);
//        }
//        if (path.contains("*")) {
//            return newWildcardEntry(path);
//        }
//        if (path.contains(".jar") || path.contains(".zip") || path.contains(".JAR") || path.contains(".ZIP")) {
//            return newZipEntry(path);
//        }
//        return newDirEntry(path);
//    }

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
