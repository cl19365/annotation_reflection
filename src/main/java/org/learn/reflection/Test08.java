package org.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射动态的创建对象
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        获得Class对象
        Class c1 = Class.forName("org.learn.reflection.User");

//        构造一个对象
//        User user = (User) c1.getDeclaredConstructor().newInstance();
//        System.out.println("user = " + user);

//        通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User user1 = (User) constructor.newInstance("eizo", 001, 32);
//        System.out.println("user1 = " + user1);

//        通过反射调用普通方法
        User user3 = (User) c1.getDeclaredConstructor().newInstance();
//        通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

//        invoke:激活的意思
//        invoke(对象，方法的值)
        setName.invoke(user3,"anno");
        System.out.println("user3.getName() = " + user3.getName());

//        通过反射操作属性
        User user4 = (User) c1.getDeclaredConstructor().newInstance();
        Field name = c1.getDeclaredField("name");
//        需要关闭程序的安全检测才能操作私有属性
        name.setAccessible(true);//关闭指定属性或方法的安全检测
        name.set(user4,"atril");
        System.out.println("user4.getName() = " + user4.getName());


    }
}
