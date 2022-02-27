package org.learn.reflection;
//测试Class类的创建方法有哪些
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人是"+person.name);

//        方法一：通过对象获得
        Class c1=person.getClass();
        System.out.println("c1.hashCode() = " + c1.hashCode());

//        方法二：forname获得
        Class c2 = Class.forName("org.learn.reflection.Student");
        System.out.println("c2.hashCode() = " + c2.hashCode());

//        方法三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println("c3.hashCode() = " + c3.hashCode());

//        方法四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println("c4 = " + c4);

//        获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println("c5 = " + c5);
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}
