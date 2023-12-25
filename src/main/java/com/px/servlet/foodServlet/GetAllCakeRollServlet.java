package com.px.servlet.foodServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/getAllCakeRollServlet")
public class GetAllCakeRollServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取CakeMapper
        CakeMapper cakeMapper = sqlSession.getMapper(CakeMapper.class);
        //获取所有的蛋糕卷
        List<Food> allCakeRolls = cakeMapper.getAllCakeRolls();
        //获取响应输出流
        PrintWriter writer = resp.getWriter();
        //创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //将蛋糕卷列表转换为json字符串
        String cakeRollsData = objectMapper.writeValueAsString(allCakeRolls);
        //将json字符串写入响应
        writer.write(cakeRollsData);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}