package com.java8.entity;

import com.java8.interfaces.PredicateLambda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author misterWei
 * @create 2018年10月23号:22点31分
 * @mailbox mynameisweiyan@gmail.com
 */
public class Persion implements Serializable ,PredicateLambda{
    private String userName;
    private Integer age;

    @Override

    public String toString() {
        return "Persion{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public Persion() {
    }

    private BigDecimal money;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Persion(String userName, Integer age, BigDecimal money) {
        this.userName = userName;
        this.age = age;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persion)) return false;
        Persion persion = (Persion) o;
        return Objects.equals(getUserName(), persion.getUserName()) &&
                Objects.equals(getAge(), persion.getAge()) &&
                Objects.equals(getMoney(), persion.getMoney());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserName(), getAge(), getMoney());
    }

    public BigDecimal getMoney() {

        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

}
