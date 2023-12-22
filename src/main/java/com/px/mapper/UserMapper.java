package com.px.mapper;

import com.px.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 根据用户名和密码查询用户
    User selectUser(@Param("name") String name, @Param("password") String password);
    // 添加用户
    void addUser(User user);
    User selectByName(@Param("name") String name);
}