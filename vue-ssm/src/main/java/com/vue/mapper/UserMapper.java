package com.vue.mapper;

import com.vue.pojo.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年10月26号:14点48分
 * @mailbox mynameisweiyan@gmail.com
 */
@Mapper
public interface UserMapper {

    //查询所有
    @Select("select * from user_data")
    List<UserData> findAll();
    //查询单一的
    @Select("select * from user_data where id=#{id}")
    UserData findById(Long id);
    //更改操作
    @Update("update  user_data set username=#{username},PASSWORD=#{password},age=#{age},email=#{email},sex=#{sex} where id=#{id}")
    void updateUser(UserData userData);

}
