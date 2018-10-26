package com.vue.service;

import com.vue.pojo.UserData;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年10月26号:14点57分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface UserService {
    //查询所有
    List<UserData> findAll();
    //查询单一的
    UserData findById(Long id);
    //更改操作
    void updateUser(UserData userData);
}
