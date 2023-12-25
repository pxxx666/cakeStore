package com.px.servlet.orderServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.px.mapper.CakeMapper;
import com.px.mapper.OrderMapper;
import com.px.pojo.Food;
import com.px.pojo.Order;
import com.px.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getAllOrderServlet")
public class GetAllOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //获取所有订单
        List<Order> allOrder = orderMapper.getAllOrder();
        //获取响应输出流
        PrintWriter writer = resp.getWriter();
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //将订单列表转换为JSON字符串
        String orderData = objectMapper.writeValueAsString(allOrder);
        //将JSON字符串写入响应
        writer.write(orderData);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doGet方法
        this.doGet(req, resp);
    }
}