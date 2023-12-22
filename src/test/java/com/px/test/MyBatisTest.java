package com.px.test;

import com.px.mapper.CakeMapper;
import com.px.mapper.OrderMapper;
import com.px.mapper.UserMapper;
import com.px.pojo.Car;
import com.px.pojo.Food;
import com.px.pojo.Order;
import com.px.pojo.User;
import com.px.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(true);


    @Test
    public void testSelectUser(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUser("px", "123456");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("px");
        user.setEmail("123");
        user.setPassword("123123");
        user.setAddress("123123123123123");
        user.setConsignee("John");
        user.setPhone("555");
        try {
            userMapper.addUser(user);
        } catch (Exception e) {
            System.out.println("出错");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectAllCakes(){
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        List<Food> allCakes = cakeMapper.getAllLittleFood();
        for (Food food : allCakes){
            System.out.println(food);
        }
    }

    @Test
    public void testAddFood(){
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        Food food = new Food();
        food.setName("cake");
        food.setPrice(100.0);
        food.setType("蛋糕");
        food.setUrl("https://img.lefucake.com/uploads/img/goods/pc/list/efb78b33c22dee16d96f1c2f6ffc96ff.jpg");
        cakeMapper.addFood(food);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByIdFood(){
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        System.out.println(cakeMapper.selectById(1));
        sqlSession.close();

    }

    @Test
    public void testUpdateFood(){
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        Food food = new Food();
        food.setId(75);
        food.setName("mjjcake");
        food.setPrice(100.0);
        food.setType("蛋糕");
        food.setUrl("https://img.lefucake.com/uploads/img/goods/pc/list/7d95f88ef72e11ec60a5be4174778c4f.jpg");
        cakeMapper.updateFood(food);
        sqlSession.close();
    }

    @Test
    public void testAddCar(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Car car = new Car();
        car.setProductName("666");
        car.setProductPrice(50);
        car.setUserName("John");
        orderMapper.insertCar(car);
        sqlSession.close();
    }

    @Test
    public void selectByUserName(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Car> carList = orderMapper.selectByUserName("马嘉祺");
        System.out.println(carList);
        sqlSession.close();
    }

    @Test
    public void deleteById(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.deleteByCarId(35);
        sqlSession.close();
    }

    @Test
    public void getAllOrder(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrder = orderMapper.getAllOrder();
        System.out.println(allOrder);
    }
}
