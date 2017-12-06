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

        //�����ص�¼ҳ��͵�¼���󣬲�����ע��ҳ��
        if(studentEntity==null&&!url.equals("/lib/login")&&!url.contains("loginIn")
                &&!url.contains("register")){
            if(url.contains(".js")||url.contains(".css")||url.contains(".jpg")){
                //��Դ�ļ�����
                filterChain.doFilter(httpRequest,httpResponse);
                return;
            }
            //1 ת��
            //servletRequest.getRequestDispatcher("/lib/login").forward(servletRequest,servletResponse);
            //2 �ض���
            httpResponse.sendRedirect("/lib/login");
        }else{//��¼ҳ�����
            if(studentEntity!=null&&url.equals("/lib/login"))//�ѵ�¼��ת��������
                httpResponse.sendRedirect("/lib/stu/myHomepage");
            //System.out.println("session studentEntity:"+studentEntity);
            filterChain.doFilter(httpRequest,httpResponse);
        }

    }


    public void destroy() {

    }
}
