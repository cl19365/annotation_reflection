package org.learn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test02 {
@MyAnnotation2(name = "anno",schools = "四川大学")
@MyAnnotation3("eizo")
    public void test(){}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
//    注解的参数：参数类型+参数名 ();
    String name() default "";
    int age() default 0;
    int id() default -1;

    String[] schools();

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();

}
