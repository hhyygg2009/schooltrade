package com.yu.st.controller;

import com.yu.st.bean.User;
import com.yu.st.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author :hhyygg2009
 * @date :Created in 2021/1/8 14:37
 */
@Controller
@AllArgsConstructor
@RequestMapping("/passport")
public class PassportController {

    @GetMapping(value = "/login")
    public String login() {
        return "passport/login";
    }


    @GetMapping(value = "/register")
    public String register() {
        return "passport/register";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/search";
    }

    @RequestMapping("/code")
    public String code() {
        return "/passport/code";
    }


    @RequestMapping({"/profile"})
    public String profile(Model model, HttpSession session) {
        User user = UserService.getLoginUser(session);
        model.addAttribute("user", user);
        return "/passport/profile";
    }


}
