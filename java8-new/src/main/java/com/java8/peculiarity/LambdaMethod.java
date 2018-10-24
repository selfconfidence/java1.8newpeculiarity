package com.java8.peculiarity;

import com.java8.entity.Persion;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author misterWei
 * @create 2018年10月23号:13点53分
 * @mailbox mynameisweiyan@gmail.com
 *
 *   Lambda表达式的另一种写法
 *   方法引用
 *       三种语法格式
 *    1.1:  对象::实例方法名;
 *    1.2:  类名::静态方法;
 *
 *    如果使用1.3,就需要满足条件,类中的实例方法参数和返回值类型,必须和实现的方法参数和返回值保持一致
 *    1.3:  类名::实例方法名
 *
 *   构造引用
 *
 *   数组引用

  */
public class LambdaMethod {
    @Test
    public void lombdaOne(){
        //最开始的写法
        Consumer consumer = x -> System.out.println(x);
        consumer.accept("张三");
        //对象::实例方法名;
        Consumer consumer1 = System.out::println;
        consumer1.accept("李四");

        PrintStream out = System.out;
        Consumer consumer2 = out::println;
        consumer2.accept("小红");

    }
    @Test
    public void lombdaTwo(){
        //1.2: 以前的写法
        Function<Integer,Integer> function = x -> x.compareTo(10);
        Integer apply = function.apply(5);
        System.out.println(apply);
        //类名::静态方法;
        Function<String,String> function1 = String::trim;
        String apply1 = function1.apply("\t\t\t\t\t  去除空格");
        System.out.println(apply1);
    }
    @Test
    public void lombda3(){
        //1.3:  之前的写法
        Supplier<Persion> supplier = () -> new Persion();
        System.out.println(supplier.get());
       // 1.3:  类名::实例方法名
        Supplier<Persion> supplier1 = Persion::new;
        System.out.println(supplier1.get());

    }

    @Test
    public void lombda4(){
        // 数组引用
        BiConsumer<String[],Integer[]> biConsumer = (x,y) -> System.out.println(x+"---"+y);
        biConsumer.accept(new String[5],new Integer[6]);

        Supplier<Persion> supplier = () -> new Persion();

    }

}
