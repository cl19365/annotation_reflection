package org.learn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class Test09 {

    //    普通方式调用
    public static void test01() {
        User user = new User();
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行10亿次"+(endTime-startTime)+"ms");
    }

    //    反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行10亿次"+(endTime-startTime)+"ms");
    }


    //    反射方式调用，关闭检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        getName.setAccessible(true);
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("关闭检测执行10亿次"+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
