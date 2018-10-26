package com.vue.test;

import com.vue.pojo.UserData;
import com.vue.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author misterWei
 * @create 2018年10月26号:14点59分
 * @mailbox mynameisweiyan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void finAllTest(){
        System.out.println(userService.findAll());
    }
    @Test
    public void finByidTest(){
        UserData byId = userService.findById(5l);
        byId.setAge(18l);
        userService.updateUser(byId);
        System.out.println(userService.findById(5l));
    }
    @Test
    public void updateTest(){

    }
}
