package com.px.mapper;

import com.px.pojo.Food;
import com.px.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CakeMapper {
    //获取所有蛋糕
    List<Food> getAllCakes();
    //获取所有蛋糕卷
    List<Food> getAllCakeRolls();
    //获取所有面包
    List<Food> getAllBread();
    //获取所有小食物
    List<Food> getAllLittleFood();

    //添加食物
    void addFood(Food food);
    //根据id查询食物
    Food selectById(@Param("id") int id);
    //根据id删除食物
    void deleteById(@Param("id") int id);
    //更新食物
    void updateFood(Food food);

}