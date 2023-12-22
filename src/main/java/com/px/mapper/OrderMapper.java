package com.px.mapper;

import com.px.pojo.Car;
import com.px.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    void insertCar(Car car);
    List<Car> selectByUserName(@Param("userName") String userName);
    void deleteByCarId(@Param("id") int id);
    List<Order> getAllOrder();
    void deleteByUserName(@Param("userName") String userName);
}
