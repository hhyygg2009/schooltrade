package com.yu.st.controller.trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/23 10:57
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userid", 1);
        Enumeration<String> list = session.getAttributeNames();
        response.getWriter().println(list);
    }
}
