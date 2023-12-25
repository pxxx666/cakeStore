package com.px.servlet.foodServlet;

import com.px.mapper.CakeMapper;
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

@WebServlet("/updateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Food food = new Food();
        //获取id
        int id = Integer.parseInt(req.getParameter("id"));
        //获取name
        String name = req.getParameter("name");
        //获取url
        String url = req.getParameter("url");
        //获取price
        double  price = Double.parseDouble(req.getParameter("price"));
        //获取type
        String type = req.getParameter("type");

        //将name，url，type转换为utf-8编码
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        url = new String(url.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        type = new String(type.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //将参数设置到food对象中
        food.setId(id);
        food.setName(name);
        food.setUrl(url);
        food.setType(type);
        food.setPrice(price);

        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //更新food
        cakeMapper.updateFood(food);
        //关闭SqlSession
        sqlSession.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}