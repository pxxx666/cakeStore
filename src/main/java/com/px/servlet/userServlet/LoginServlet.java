package com.px.servlet.userServlet;

import com.px.mapper.UserMapper;
import com.px.pojo.User;
import com.px.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求参数的字符编码
        req.setCharacterEncoding("UTF-8");
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //根据用户名和密码查询用户
        User user = userMapper.selectUser(req.getParameter("name"), req.getParameter("password"));
        System.out.println(user);
        //关闭SqlSession
        sqlSession.close();
        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");

        //判断用户是否查询到用户
        if(user != null){
            //对用户名进行编码
            String userName= URLEncoder.encode(user.getName(),"UTF-8");
            //创建Cookie对象
            Cookie cookie = new Cookie("userName", userName);
            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
            //判断用户是否为管理员
            if (user.getName().equals("admin")) {
                //跳转到管理员页面
                resp.sendRedirect("/adminCakeIndex.html");
            }else {
                //跳转到普通用户页面
                resp.sendRedirect("/cakeIndex.html");
            }

        }else {

            //跳转到登录页面
            resp.sendRedirect("/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doGet方法
        this.doGet(req, resp);
    }
}