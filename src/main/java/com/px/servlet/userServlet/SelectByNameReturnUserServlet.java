package com.px.servlet.userServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.px.mapper.UserMapper;
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

@WebServlet("/selectByNameReturnUserServlet")
public class SelectByNameReturnUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String name = req.getParameter("name");
        // 将请求参数从ISO_8859_1编码转换为UTF_8编码
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 根据用户名查询用户
        User user = userMapper.selectByName(name);
        // 获取响应输出流
        PrintWriter writer = resp.getWriter();
        //创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //将蛋糕卷列表转换为json字符串
        String userData = objectMapper.writeValueAsString(user);
        writer.write(userData);
        // 关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doGet方法
        this.doGet(req, resp);
    }
}