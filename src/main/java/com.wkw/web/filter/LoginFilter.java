package com.wkw.web.filter;

import com.wkw.entity.StudentEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * create by wkw
 */
public class LoginFilter implements Filter {
    private String encoding;
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        httpRequest.setCharacterEncoding(encoding);
        httpResponse.setCharacterEncoding(encoding);
        httpResponse.setContentType("text/html "+encoding);

        HttpSession session = httpRequest.getSession();
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        String url = httpRequest.getRequestURI();
        System.out.println("(filter)url:" +url +"  encoding "+encoding);

        //不拦截登录页面和登录请求，不拦截注册页面
        if(studentEntity==null&&!url.equals("/lib/login")&&!url.contains("loginIn")
                &&!url.contains("register")){
            if(url.contains(".js")||url.contains(".css")||url.contains(".jpg")){
                //资源文件放行
                filterChain.doFilter(httpRequest,httpResponse);
                return;
            }
            //1 转发
            //servletRequest.getRequestDispatcher("/lib/login").forward(servletRequest,servletResponse);
            //2 重定向
            httpResponse.sendRedirect("/lib/login");
        }else{//登录页面放行
            if(studentEntity!=null&&url.equals("/lib/login"))//已登录跳转个人中心
                httpResponse.sendRedirect("/lib/stu/myHomepage");
            //System.out.println("session studentEntity:"+studentEntity);
            filterChain.doFilter(httpRequest,httpResponse);
        }

    }


    public void destroy() {

    }
}
