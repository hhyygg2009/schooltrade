package com.yu.st.controller;

import com.yu.st.bean.User;
import com.yu.st.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class Index {
    @RequestMapping("/")
    public String index() {
        return "redirect:/search";
    }

    @Autowired
    UserDao userDao;

    @ResponseBody
    @RequestMapping("/test")
    public String loginTest(HttpSession session) {
        User user = userDao.selectByPrimaryKey(1);
        session.setAttribute("user", user);
        return "succ";
    }


}
