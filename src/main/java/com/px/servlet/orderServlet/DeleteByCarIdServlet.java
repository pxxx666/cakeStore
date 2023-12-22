package com.px.servlet.orderServlet;

import com.px.mapper.OrderMapper;
import com.px.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteByCarIdServlet")
public class DeleteByCarIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取id参数
        int id = Integer.parseInt(req.getParameter("id"));
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        //根据id删除订单
        orderMapper.deleteByCarId(id);
        //关闭SqlSession
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}