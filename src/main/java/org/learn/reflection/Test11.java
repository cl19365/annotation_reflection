package org.learn.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test11 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("org.learn.reflection.Student2");

//        通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

//        获得注解的value的值
        Tablek tablek = (Tablek)c1.getAnnotation(Tablek.class);
        String value = tablek.value();
        System.out.println("value = " + value);


//        获得类指定的注解
        Field f = c1.getDeclaredField("name");
        Fieldk fieldk = f.getAnnotation(Fieldk.class);
        System.out.println("fieldk.columnname() = " + fieldk.columnname());
        System.out.println("fieldk.type() = " + fieldk.type());
        System.out.println("fieldk.lenght() = " + fieldk.lenght());

    }

}

@Tablek("db_student")
class Student2 {

    @Fieldk(columnname = "db_id", type = "int", lenght = 10)
    private int id;
    @Fieldk(columnname = "db_age", type = "int", lenght = 10)
    private int age;
    @Fieldk(columnname = "db_name", type = "varchar", lenght = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablek {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldk {
    String columnname();

    String type();

    int lenght();
}