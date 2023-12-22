package com.px.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/car.html")
public class CarFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Cookie[] cookies = httpServletRequest.getCookies();
        String userName = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }
        if (userName != null) {
            // 如果找到了名为"userName"的Cookie，则允许放行
            chain.doFilter(request, response);
        } else {
            // 如果没有找到名为"userName"的Cookie，则返回错误响应
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }


    @Override
    public void destroy() {

    }
}
