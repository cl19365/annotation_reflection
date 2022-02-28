package org.learn.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test10 {

    public void test01(Map<String, User> map, List<User> list, int i, String s) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test10.class.getDeclaredMethod("test01", Map.class, List.class, int.class, String.class);

//        getGenericParameterTypes()：获得指定方法的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("genericParameterType = " + genericParameterType);

//            如果genericParameterType是参数化类型则执行
            if (genericParameterType instanceof ParameterizedType) {

//                getActualTypeArguments()：获得真实参数信息
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
//                    System.out.println("actualTypeArgument = " + actualTypeArgument);
                }
            }
        }


        method = Test10.class.getDeclaredMethod("test02");
//            getGenericReturnType()：获得指定方法的返回值类型
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
//                getActualTypeArguments()：获得真实参数信息
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("test02 = " + actualTypeArgument);
            }
        }
    }
}
