package com.java8.peculiarity;

import com.java8.entity.Persion;
import com.java8.interfaces.FunctionInterFace;
import com.java8.interfaces.PredicateLambda;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author misterWei
 * @create 2018年10月23号:13点53分
 * @mailbox mynameisweiyan@gmail.com
 * <p>
 * 基础语法Lambda的说明:
 * Java8 出现了一个新的操作符即箭头操作符  ->  也称为Lambda操作符
 * Lambda操作符分为两部分  即  左侧   右侧
 * (参数列表)->(Lambda体)
 * 左侧: 参数列表
 * 右侧  Lambda体,所实现的功能
 */
public class LambdaDemo {
    /**
     * 接口中的静态方法使用
     */
    @Test
    public void interfaceTest() {
        //调用接口中的静态方法
        String name = PredicateLambda.returnString("张三");
        System.out.println(name);
        //使用表达式对数据进行操作
        PredicateLambda predicateLambda = (x, y) -> {
            return x + y;
        };
        Integer integer = predicateLambda.returnInt(4, 6);
        System.out.println(integer);
    }

    /**
     * 语法格式一,无参数,无返回值
     */
    @Test
    public void testLambda() {
        //首先看看我们以前是怎么实现的
        int i = 0;
        Runnable runnable = new Runnable() {
            public void run() {   //引用局部变量也不需要加final了,但是底层还是final
                System.out.println("我是匿名内部类!" + i);
            }
        };
        runnable.run();
        System.out.println("**************************************");

        //Lambda怎么实现的
        Runnable runnable1 = () -> System.out.println("我是表达式实现的");
        runnable1.run();
    }

    /**
     * 语法格式二, 有参数,无返回值
     * 如果参数只有一个那么括号可以省略不写
     */
    @Test
    public void testLambda2() {
        //回调函数
        Consumer consumer = (x) -> System.out.println(x);
        consumer.accept("张三");

        //省略小括号
        Consumer consumer2 = x -> System.out.println(x);
        consumer2.accept("李四");

    }

    /**
     * 语法格式三,多个参数并且还有返回值
     * 需要使用{
     * return 逻辑代码;
     * };
     */
    @Test
    public void testLambda3() {
        Comparable comparable = (x) -> {
            //>
            return Integer.compare((Integer) x, 50);
        };

        int i = comparable.compareTo(30);
        System.out.println(i);
        //补充说明,如果只有一条语句 return 那么{},return 可以省略
        Comparable comparable1 = (x) -> Integer.compare((Integer) x, 50);
        int i2 = comparable.compareTo(30);
        System.out.println(i2);
    }

    /**
     * 语法格式四: 所使用的表达式接口必须式函数式接口
     * : 什么是函数接口: 一个接口中只有一个抽象方法 参照 interfaces包下的函数接口(FunctionInterFace)
     */
    @Test
    public void testLambda4() {
        //基于函数回调的操作
        FunctionInterFace functionInterFace = x -> x * x;
        Integer integer = functionInterFace.numberMath(5);
        System.out.println(integer);
    }

    /**
     * 使用Lambda继续集合排序操作
     */
    public List<Persion> list = Arrays.asList(
            new Persion("张三", 24, new BigDecimal(55.66d)),
            new Persion("李四", 29, new BigDecimal(66.66d)),
            new Persion("赵六", 18, new BigDecimal(77.77d)),
            new Persion("田七", 32, new BigDecimal(55.44d)),
            new Persion("李丹", 34, new BigDecimal(88.66d))
    );//排序操作

    @Test
    public void testLambda5() {
        Collections.sort(list, (x, y) -> {
            if (x.getUserName().equals(y.getUserName())) {
                return x.getUserName().compareTo(y.getUserName());
            } else {
                return -x.getAge().compareTo(y.getAge());
            }
        });
        for (Persion persion : list) {
            System.out.println(persion);
        }
    }

    @Test
    public void testLambda6() {
        FunctionInterFace functionInterFace = (x) -> x+x;
        Integer integer = functionInterFace.numberMath(15);
        System.out.println(integer);
    }

}
