package com.px.mapper;

import com.px.pojo.Car;
import com.px.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    // 插入车辆信息
    void insertCar(Car car);
    // 根据用户名查询车辆信息
    List<Car> selectByUserName(@Param("userName") String userName);
    // 根据车辆id删除车辆信息
    void deleteByCarId(@Param("id") int id);
    // 获取所有订单信息
    List<Order> getAllOrder();
    // 根据用户名删除订单信息
    void deleteByUserName(@Param("userName") String userName);
}