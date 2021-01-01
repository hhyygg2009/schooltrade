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
 * @date :Created in 2020/12/20 22:13
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/passport/registeraction")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username, password, phone, sex, code;

        code = request.getParameter("captcha");

        username = request.getParameter("username");
        password = request.getParameter("password");
        phone = request.getParameter("phone");
        sex = request.getParameter("sex");

        int status;
        Message message = new Message();
        HttpSession session = request.getSession();

        //验证码验证
        if (code != null && code.equals(session.getAttribute("code"))) {
            if (username != null) {
                User user = new User();
                user.setUsername(username);
                password = MD5.generateCode(password);
                user.setPassword(password);
                user.setPhone(phone);
                user.setSex(Integer.parseInt(sex));

                UserService userService = new UserService();
                try {
                    status = userService.register(user);
                    if (status == 1) {
                        message.setMsg("注册成功");
                    }
                    message.setCode(status);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }

            }
        } else {
            message.setMsg("验证码错误");

        }

        response.getWriter().println(message);
    }
}
