package com.px.servlet.userServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.px.mapper.CakeMapper;
import com.px.mapper.OrderMapper;
import com.px.mapper.UserMapper;
import com.px.pojo.Car;
import com.px.pojo.Food;
import com.px.pojo.User;
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

@WebServlet("/selectAllUserServlet")
public class SelectAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //获取所有面包
        List<User> allUsers = userMapper.getAllUsers();
        //获取响应输出流
        PrintWriter writer = resp.getWriter();
        //创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //将List<Food>转换为json字符串
        String usersData = objectMapper.writeValueAsString(allUsers);
        //将json字符串写入响应
        writer.write(usersData);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
