package com.java8.peculiarity;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author misterWei
 * @create 2018年10月23号:13点53分
 * @mailbox mynameisweiyan@gmail.com
 *
 * java1.8,四大核心函数接口
 *
 * Consumer<T>   T:  消费型接口
 * Supplier<T>   T:  供给型消费接口
 * Function<T,R> T,R: 函数型接口
 * Predicate<T>  T:  断定型接口
  */
public class LambdaFunctionInterface {
    public LambdaFunctionInterface() {
        System.out.println("无参构造执行了");
    }

    //Consumer<T>   T:  消费型接口
    @Test
    public void consumerTest(){
        consumerDemo("\t\t\t  去除空格  ", (x) -> System.out.println(x));
    }
    public String consumerDemo(String str, Consumer<String> conStr){
        conStr.accept(str.trim());
        return str;
    }
    //Function<T>   T:  函数型消费接口
    @Test
    public void functionTest(){
        String s = functionDemo("\t\t\t  去除空格  ", (x) -> x.trim());
        System.out.println(s);

    }
    public String functionDemo(String str, Function<String,String> fun){

        return fun.apply(str);

    }
    //Supplier<T>   T:  供给型消费接口  有返回值无参数
    @Test
    public void supplierTest(){
        Integer integer = supplierDemo(() -> 10);
        System.out.println(integer);
    }

    public Integer supplierDemo(Supplier<Integer> sup){
        return sup.get();
    }

 //Predicate 断定形接口

    @Test
    public void predicateTest(){
        Boolean aBoolean = predicateDemo(10, x -> x < 20);
        System.out.println(aBoolean);
    }
    public Boolean predicateDemo(Integer num, Predicate<Integer> pre){
        return pre.test(num);

    }
}
