package com.yu.st.controller.passport;

import com.yu.st.entity.Message;
import com.yu.st.entity.User;
import com.yu.st.service.impl.UserService;
import com.yu.st.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 15:59
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */


@WebServlet("/passport/loginaction")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username, password, code, msg;
        int status = -1;

        code = request.getParameter("captcha");
        username = request.getParameter("username");
        password = request.getParameter("password");


        Message message = new Message();
        HttpSession session = request.getSession();

        //验证码验证
        if (code != null && code.equals(session.getAttribute("code"))) {
            //用户名密码验证
            if (username != null && password != null) {
                User loginuser = new User();
                password = MD5.generateCode(password);
                loginuser.setUsername(username);
                loginuser.setPassword(password);

                UserService userService = new UserService();
                status = userService.login(loginuser);

                if (status == 0) {
                    //保存到session
                    Integer userid = userService.user.getId();

                    session.setAttribute("userid", userid);
                }

            } else {
                status = 3;
            }
        } else {
            status = 4;
        }
        message.setCode(status);
        message.setMsg(UserService.msg[status]);

        response.getWriter().println(message);


    }


}
