package com.px.servlet.foodServlet;

import com.px.mapper.CakeMapper;
import com.px.mapper.UserMapper;
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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/appendFoodServlet")
public class AddFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//        String encode = URLEncoder.encode()
        //实例化user对象
        Food food = new Food();
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        double  price = Double.parseDouble(req.getParameter("price"));
        String type = req.getParameter("type");

        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        url = new String(url.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        type = new String(type.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        food.setName(name);
        food.setUrl(url);
        food.setType(type);
        food.setPrice(price);
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //调用UserMapper的addUser方法
        cakeMapper.addFood(food);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
