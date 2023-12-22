package com.px.servlet.orderServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/selectByUserNameServlet")
public class SelectByUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取请求中的用户名
        String userName = req.getParameter("userName");
        //将用户名从ISO_8859_1编码格式转换为UTF_8编码格式
        userName = new String(userName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //根据用户名查询订单
        List<Car> carList = orderMapper.selectByUserName(userName);
        //获取响应的输出流
        PrintWriter writer = resp.getWriter();
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //将对象转换为json字符串
        String carListData = objectMapper.writeValueAsString(carList);
        //将json字符串写入响应
        writer.write(carListData);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doGet方法
        this.doGet(req, resp);
    }
}