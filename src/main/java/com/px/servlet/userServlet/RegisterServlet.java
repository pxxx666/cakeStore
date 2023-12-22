package com.px.servlet.userServlet;

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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    User user = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        //实例化user对象
        user = new User();
        //获取表单中的数据
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setConsignee(req.getParameter("consignee"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper的addUser方法
        userMapper.addUser(user);
        //关闭SqlSession
        sqlSession.close();
        resp.sendRedirect("/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doGet方法
        this.doGet(req, resp);
    }
}