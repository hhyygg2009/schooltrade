package com.yu.st.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/23 20:02
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebFilter({"/trade/my", "/trade/release", "/passport/myprofile"})
public class LoginCheckFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession();
        if (session.getAttribute("userid") == null) {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/passport/login.jsp");
        } else {
            chain.doFilter(req, resp);

        }


    }


}
