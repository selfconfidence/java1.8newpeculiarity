package com.vue.service.impl;

import com.vue.mapper.UserMapper;
import com.vue.pojo.UserData;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年10月26号:14点57分
 * @mailbox mynameisweiyan@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserData> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserData findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void updateUser(UserData userData) {
       userMapper.updateUser(userData);
    }
}
