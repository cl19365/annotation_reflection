package org.learn.annotation;

import java.lang.annotation.*;

//元注解
public class Test01 {
    public void test() {

    }
}

//@Target:用来指定注解在哪些地方能够生效
@Target(value = {ElementType.METHOD, ElementType.TYPE})
//@Retention:用来指定是只在代码(SOURCE)中有效，还是在转为class文件(CLASS)时也能有效，或是从代码直到运行(RUNTIME)都能有效
//RUNTIME>CLASS>SOURCE
@Retention(value = RetentionPolicy.RUNTIME)
//@Documented:表示是否将注解生成在JAVAdoc中
@Documented
//@Inherited:表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}
