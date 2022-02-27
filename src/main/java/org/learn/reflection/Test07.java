package org.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("org.learn.reflection.User");
        User user = new User();
        c1 = user.getClass();
//        获得类的名字
        System.out.println("----------------------获得类的名字---------------------");
        System.out.println("c1.getName() = " + c1.getName());//获得包名+类名
        System.out.println("c1.getSimpleName() = " + c1.getSimpleName());//获得类名

//        获得类的属性
        System.out.println("----------------------获得类的属性---------------------");
        Field[] fields = c1.getFields();//只能找到public级别的属性

        fields = c1.getDeclaredFields();//能找到所有级别的属性
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

//        获得指定属性的值
        System.out.println("---------------------获得指定属性的值----------------------");
        Field name = c1.getDeclaredField("name");
        System.out.println("name = " + name);

//        获得类的方法
        System.out.println("---------------------获得类的方法----------------------");
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("getMethods = " + method);
        }
        methods=c1.getDeclaredMethods();//获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods = " + method);
        }

//        获得指定方法
        System.out.println("--------------------获得指定方法-----------------------");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println("getName = " + getName);
        System.out.println("setName = " + setName);

//       获得类的构造器
        System.out.println("----------------------获得类的构造器---------------------");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors= c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("#"+constructor);
        }

//       获得指定的构造器
        System.out.println("----------------------获得指定的构造器---------------------");
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("declaredConstructor = " + declaredConstructor);


    }
}
