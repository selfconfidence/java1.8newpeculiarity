package com.java8.streamapi;

import com.java8.entity.Persion;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author misterWei
 * @create 2018年10月24号:11点20分
 * @mailbox mynameisweiyan@gmail.com
 * <p>
 * 一,Stream 的三个操作步骤
 * <p>
 * 1. 创建Stream
 * <p>
 * 3. 中间操作
 * <p>
 * 3. 终止操作
 */
public class StreamTest {
    public List<Persion> list = Arrays.asList(
            new Persion("张三", 28, new BigDecimal(55.66d)),
            new Persion("李四", 18, new BigDecimal(66.66d)),
            new Persion("赵六", 38, new BigDecimal(77.77d)),
            new Persion("田七", 48, new BigDecimal(55.44d)),
            new Persion("李丹", 58, new BigDecimal(88.66d))
    );

    //创建Stream对象的方式

    @Test
    public void createStream() {
        //1.1可以通过Collection 系列集合提供的方法创建
        Collection<String> collection = new ArrayList<String>();
        //获取并行流
        Stream<String> stringStream = collection.parallelStream();
        //获取串行流
        Stream<String> stream = collection.stream();

        //1.2 通过Arrays中的方法获取
        IntStream stream1 = Arrays.stream(new int[10]);
        //1.3 通过Stream中的静态方法 of()获取
        Stream<Object> of = Stream.of();
        //1.4 创建无限流迭代的效果
        Stream<Double> generate = Stream.generate(Math::random).limit(6);
        generate.forEach(System.out::println);

    }

    /**
     * stream 的筛选与切片
     * <p>
     * limit :  指定数据数量
     * skip :   跳过元素
     * distinct: 去除重复数据
     * filter: 过滤掉某些属性
     */
    @Test
    public void streamTestList() {
        list.stream().filter(x -> x.getAge() > 20)
                .limit(2)
                .parallel()
                .distinct()//去除重复数据,注意前提必须重写eq和hs方法.
                .forEach(System.out::println);

        list.forEach(System.out::println);
    }

    /**
     * API 总结 Stream
     * reduce:  一般和map一起使用 归约
     * collect 收集操作
     */
    @Test
    public void streamTestList1() {
        //最大数
        Optional<Integer> collect = list.stream()
                .map(Persion::getAge)
                .collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(collect);
        //最小数
        Optional<Integer> collect1 = list.stream().map(Persion::getAge)
                .collect(Collectors.minBy(Integer::compareTo));

        System.out.println(collect1);

    }

    @Test
    public void streamTestList2() {
        //reduce
        Optional<java.lang.String> reduce = list.stream()
                .map(Persion::getUserName)
                .reduce((x, y) -> {
                    if (x.equals(y)) {
                        return x;
                    } else {
                        return "没有此数据";
                    }
                });
        System.out.println(reduce.get());
    }

    @Test
    public void streamTestList3() {
        boolean b = list.stream().allMatch((x) -> {
            return x.getAge().equals(x.getAge());
        });
        System.out.println(b);
    }

    @Test
    public void streamTestList4() {
        boolean b = list.stream().anyMatch((x) -> {
            int i = x.getAge().compareTo(x.getAge());
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        });
        System.out.println(b);
    }

    @Test
    public void streamTestList5() {
        //排序操作   不带参数为自然排序,带参数为指定排序
        Stream<java.lang.Integer> sorted = list.stream().map(Persion::getAge).sorted((x, y) -> {
            return -Integer.compare(x, y);
        });
        Iterator<java.lang.Integer> iterator = sorted.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
