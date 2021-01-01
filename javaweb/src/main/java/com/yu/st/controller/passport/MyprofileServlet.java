package com.yu.st.controller.passport;

import com.yu.st.dao.impl.UserDao;
import com.yu.st.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/22 20:56
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/passport/myprofile")
public class MyprofileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid;
        Integer useridInt;

        userid = request.getParameter("userid");

        HttpSession session = request.getSession();


        if (userid != null) {
            useridInt = Integer.parseInt(userid);
        } else {
            useridInt = (Integer) session.getAttribute("userid");
        }

        if (useridInt != null) {
            try {
                User user = UserDao.getUser(useridInt);
                request.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("/passport/myprofile.jsp");
                rd.forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


    }
}
