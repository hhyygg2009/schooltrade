package com.yu.st.controller.passport;

import com.alibaba.fastjson.JSON;
import com.yu.st.dao.impl.UserDao;
import com.yu.st.entity.Message;
import com.yu.st.entity.User;

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
@WebServlet("/passport/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid, userstr;
        Integer useridInt;


        userid = request.getParameter("userid");
        userstr = request.getParameter("user");

        HttpSession session = request.getSession();
        Message message = new Message();

        if (userid != null) {
            useridInt = Integer.parseInt(userid);
        } else {
            useridInt = (Integer) session.getAttribute("userid");
        }

//        if(useridInt!=null){
//                User user= UserDao.getUser(useridInt);
//                message.addData("user",user);
//                message.setnoerror();
//        }

        User user = JSON.parseObject(userstr, User.class);
        int status = UserDao.updateUser(user);
        if (status == 1) {
            message.setnoerror();
        }
        response.getWriter().println(message);
    }
}
