package org.learn.reflection;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException {
//       获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);

//        获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("parent = " + parent);

//        获取扩展类加载器的父类加载器-->根加载器(C/c++)  无法直接获取
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);

//        测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("org.learn.reflection.Test06").getClassLoader();
        System.out.println("classLoader = " + classLoader);

//        测试JDK内置的类是哪个加载器加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("classLoader = " + classLoader);

//        如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
