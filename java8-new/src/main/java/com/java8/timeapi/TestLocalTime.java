package com.java8.timeapi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author misterWei
 * @create 2018年10月24号:23点07分
 * @mailbox mynameisweiyan@gmail.com
 *
 * LocalData    日期 年月日
 * LocalTime    时间  时分秒
 * LocalDataTime 这种已经包含了以上两种
 * Duration  计算两个时间的间隔
 * Period    计算两个日期之间的间隔
 */
public class TestLocalTime {
    @Test
    public void testTime(){
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //加年加时间都是允许的 由于线程是安全的,所以每次都会返回一个实例对象
        LocalDateTime localDateTime1 = localDateTime.plusYears(2);
        System.out.println(localDateTime1);
        //减去指定年月日时分秒
        LocalDateTime localDateTime2 = localDateTime1.minusYears(5);
        System.out.println(localDateTime2);
        //指定年月日操作
        LocalDateTime of = LocalDateTime.of(2018, 12, 31, 13, 30, 59);
        System.out.println(of);
    }
    @Test
    public void testDuration(){
        //这是供计算机所识别的时间戳
        Instant now = Instant.now();
        now.atOffset(ZoneOffset.ofHours(7));
        System.out.println(now);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
       //计算两个时间的间隔
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
    }

    @Test
    public void testPeriod(){
        //LocalDateTime of = LocalDateTime.of(2017,10,25,13,56,33);
        //LocalDateTime now = LocalDateTime.now();
        Instant now = Instant.now();
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        OffsetDateTime offsetDateTime1 = offsetDateTime.plusYears(3);
        System.out.println(offsetDateTime1);
        Period between = Period.between(offsetDateTime.toLocalDate(), offsetDateTime1.toLocalDate());
        System.out.println(between.toString());

    }

    /**
     * Zone 时区列表  可以用来指定时区
     */
    @Test
    public void testTime1(){
        //时间矫正器
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.of(1)));
        System.out.println(localDateTime);
        //自定义时间矫正器
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println(localDateTime1);
        //获取所有的时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }
    /**
     * 新特性的时间转换器 DateTimeFormatter
     * 解析字符串为日期对象, 解析日期对象为指定格式化标准
     * 转换的准则
     * 方法都在LocalDateTime中, DateTimeFormatter 只不过提供了一种样式而已.
     */
    @Test
    public void testTime2(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();
        //日期采用格式化标准
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);
       //自定义转换为字符串日期
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

        LocalDateTime localDateTime1 = LocalDateTime.now();
        String format1 = localDateTime1.format(dateTimeFormatter1);
        System.out.println(format1);
        //parse为日期对象
        TemporalAccessor parse = dateTimeFormatter1.parse(format1);
        System.out.println(parse.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
        LocalDateTime parse1 = localDateTime1.parse(format1,dateTimeFormatter1);
        System.out.println(parse1);
    }
}
