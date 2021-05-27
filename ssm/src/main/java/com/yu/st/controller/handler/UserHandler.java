package com.yu.st.controller.handler;

import com.yu.st.bean.po.UserForm;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.UserDao;
import com.yu.st.service.impl.UserService;
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


    @PostMapping(value = "/register")
    public Message registerAction(UserForm userForm, HttpSession session) {
        return new Message(userService.registerAction(userForm,session));
    }

    @PostMapping("/login")
    public Message loginAction(UserForm userForm, HttpSession session) {
        return userService.loginAction(userForm,session);
    }
}
