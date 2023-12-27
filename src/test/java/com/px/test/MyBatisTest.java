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
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //获取SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession(true);


    //测试查询用户
    @Test
    public void testSelectUser(){
        //获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //根据用户名和密码查询用户
        User user = userMapper.selectUser("px", "123456");
        //打印查询结果
        System.out.println(user);
        //关闭SqlSession
        sqlSession.close();
    }

    //测试添加用户
    @Test
    public void testAddUser(){
        //获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建用户
        User user = new User();
        //设置用户属性
        user.setName("px");
        user.setEmail("123");
        user.setPassword("123123");
        user.setAddress("123123123123123");
        user.setConsignee("John");
        user.setPhone("555");
        //尝试添加用户
        try {
            userMapper.addUser(user);
        } catch (Exception e) {
            System.out.println("出错");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }
    //测试查询所有蛋糕
    @Test
    public void testSelectAllCakes(){
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //查询所有蛋糕
        List<Food> allCakes = cakeMapper.getAllLittleFood();
        //遍历查询结果
        for (Food food : allCakes){
            //打印查询结果
            System.out.println(food);
        }
    }

    //测试添加蛋糕
    @Test
    public void testAddFood(){
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //创建蛋糕
        Food food = new Food();
        //设置蛋糕属性
        food.setName("cake");
        food.setPrice(100.0);
        food.setType("蛋糕");
        food.setUrl("https://img.lefucake.com/uploads/img/goods/pc/list/efb78b33c22dee16d96f1c2f6ffc96ff.jpg");
        //尝试添加蛋糕
        try {
            cakeMapper.addFood(food);
        } catch (Exception e) {
            System.out.println("出错");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    //测试根据id查询蛋糕
    @Test
    public void testSelectByIdFood(){
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //根据id查询蛋糕
        System.out.println(cakeMapper.selectById(1));
        //关闭SqlSession
        sqlSession.close();

    }

    //测试更新蛋糕
    @Test
    public void testUpdateFood(){
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //创建蛋糕
        Food food = new Food();
        //设置蛋糕属性
        food.setId(75);
        food.setName("mjjcake");
        food.setPrice(100.0);
        food.setType("蛋糕");
        food.setUrl("https://img.lefucake.com/uploads/img/goods/pc/list/7d95f88ef72e11ec60a5be4174778c4f.jpg");
        //尝试更新蛋糕
        try {
            cakeMapper.updateFood(food);
        } catch (Exception e) {
            System.out.println("出错");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    //测试添加购物车
    @Test
    public void testAddCar(){
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //创建购物车
        Car car = new Car();
        //设置购物车属性
        car.setProductName("666");
        car.setProductPrice(50);
        car.setUserName("John");
        //尝试添加购物车
        try {
            orderMapper.insertCar(car);
        } catch (Exception e) {
            System.out.println("出错");
        }
        //提交事务
        sqlSession.close();
    }

    //测试根据用户名查询购物车
    @Test
    public void selectByUserName(){
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //根据用户名查询购物车
        List<Car> carList = orderMapper.selectByUserName("马嘉祺");
        //打印查询结果
        System.out.println(carList);
        //关闭SqlSession
        sqlSession.close();
    }

    //测试根据id删除购物车
    @Test
    public void deleteById(){
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //根据id删除购物车
        orderMapper.deleteByCarId(35);
        //提交事务
        sqlSession.close();
    }

    //测试获取所有订单
    @Test
    public void getAllOrder(){
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //获取所有订单
        List<Order> allOrder = orderMapper.getAllOrder();
        //打印查询结果
        System.out.println(allOrder);
    }

    @Test
    public void getVip(){
        //获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.upgradeVIP("马嘉祺");
        sqlSession.close();

    }


}