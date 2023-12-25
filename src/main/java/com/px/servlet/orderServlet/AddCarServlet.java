package com.px.servlet.orderServlet;

import com.px.mapper.CakeMapper;
import com.px.mapper.OrderMapper;
import com.px.pojo.Car;
import com.px.pojo.Food;
import com.px.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//        String encode = URLEncoder.encode()
        //实例化user对象
        Car car = new Car();
        //获取参数
        String productName = req.getParameter("productName");
        double productPrice = Double.parseDouble(req.getParameter("productPrice"));
        String userName = req.getParameter("userName");
        String productUrl = req.getParameter("productUrl");

        //将参数转换为字符串
        productName = new String(productName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        userName = new String(userName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        productUrl = new String(productUrl.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //设置参数
        car.setProductUrl(productUrl);
        car.setUserName(userName);
        car.setProductName(productName);
        car.setProductPrice(productPrice);
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //调用mapper中的方法
        orderMapper.insertCar(car);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}