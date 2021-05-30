package com.yu.st.controller.handler;

import com.yu.st.bean.User;
import com.yu.st.bean.po.UserForm;
import com.yu.st.bean.vo.Message;
import com.yu.st.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 22:40
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserHandler {
    UserService userService;


    @PostMapping(value = "/register")
    public Message registerAction(UserForm userForm, HttpSession session) {
        int result = userService.registerAction(userForm, session);
        return Message.build(result, "注册成功", null);
    }

    @PostMapping("/login")
    public Message loginAction(UserForm userForm, HttpSession session) {
        return userService.loginAction(userForm,session);
    }

    @PostMapping("/update")
    public Message updateAction(@RequestBody User user,HttpSession session){
        return userService.updateAction(user, session);
    }
}
