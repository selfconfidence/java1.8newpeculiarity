package com.vue.controller;

import com.vue.pojo.UserData;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author misterWei
 * @create 2018年10月26号:15点27分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<UserData> findAll(){
        return userService.findAll();
    }
    @GetMapping("/byId")
    public UserData findById(@RequestParam(name = "id",required = true) Long id){
        return userService.findById(id);
    }
    @RequestMapping("/updateUser")
    public Boolean updateUser(@RequestBody Map<String,UserData> map){
        try {
            UserData user = map.get("user");
            userService.updateUser(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
