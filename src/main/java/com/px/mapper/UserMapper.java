// 添加中文注释后
package com.px.mapper;

import com.px.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 根据用户名和密码查询用户
    User selectUser(@Param("name") String name, @Param("password") String password);
    // 添加用户
    void addUser(User user);
    // 根据用户名查询用户
    User selectByName(@Param("name") String name);
    // 升级VIP
    void upgradeVIP(@Param("name") String name);
    //查询所有用户
    List<User> getAllUsers();

}