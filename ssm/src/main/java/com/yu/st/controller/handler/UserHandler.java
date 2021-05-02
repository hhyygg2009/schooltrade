package com.yu.st.controller.handler;

import com.yu.st.bean.User;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.UserDao;
import com.yu.st.service.impl.UserService;
import com.yu.st.util.MD5;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 22:40
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserHandler {
    UserDao userDao;
    UserService userService;


    @ResponseBody
    @PostMapping(value = "/register")
    public Message registerAction(User user, String captcha, Message message, HttpSession session) {
        //验证码验证
        if (captcha != null && captcha.equals(session.getAttribute("captcha"))) {
                int status = userService.register(user);
                if (status == 1) {
                    message.setnoerror();
                } else {
                    message.setMsg(UserService.msg[status]);
                }
        } else {
            message.setMsg("验证码错误");

        }
        return message;
    }

    @ResponseBody
    @PostMapping("/login")
    public Message loginAction(User user, @RequestParam("captcha") String captchaIn, HttpSession session, Message message) {
        int status;
        String captcha = (String) session.getAttribute("captcha");

        //验证码验证
        if (captchaIn != null && captchaIn.equals(captcha)) {
            //用户名密码验证
            status = userService.login(user);
            //用户信息正确,userid保存到session
            if (status == UserService.PASS) {
//                Integer userid = userService.user.getId();
                session.setAttribute("user", userService.getUser());
            }
        } else {
            status = UserService.CAPTCHAERR;
        }
        message.setCode(status);
        message.setMsg(UserService.msg[status]);

        return message;
    }
}
