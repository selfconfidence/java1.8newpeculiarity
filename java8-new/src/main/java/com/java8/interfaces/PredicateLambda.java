package com.java8.interfaces;


/**
 * @author misterWei
 * @create 2018年10月23号:17点01分
 * @mailbox mynameisweiyan@gmail.com
 *
 * 1.8 使劲造,接口中定义方法
 *
 * 满足两点 static修饰 或者default修饰
 */
public interface PredicateLambda {
    //示例:

    static String returnString(String name){
        return name;
    }
   default Integer returnInt(Integer sex,Integer gender){
     return sex+gender;
   };



}
