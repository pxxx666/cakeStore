package com.px.mapper;

import com.px.pojo.Food;
import com.px.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CakeMapper {
    List<Food> getAllCakes();
    List<Food> getAllCakeRolls();
    List<Food> getAllBread();
    List<Food> getAllLittleFood();

    void addFood(Food food);
    Food selectById(@Param("id") int id);
    void deleteById(@Param("id") int id);
    void updateFood(Food food);

}
