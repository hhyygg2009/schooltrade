package com.yu.st.service.impl;

import com.yu.st.bean.User;
import com.yu.st.dao.UserDao;
import com.yu.st.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 16:09
 * @package :com.yu.st.service.impl
 * @description:
 * @modified By：
 * @version:
 */

@Service
public class UserService {

    public static final int CAPTCHAERR = 4;
    public static final int USERNULL = 3;
    public static final int USERNOTFOUND = 2;
    public static final int PASSERR = 1;
    public static final int PASS = 0;
    public static final String[] msg = {"登录成功", "密码错误", "用户名不存在", "输入为空", "验证码错误"};

    UserDao userDao;

    @Autowired
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    private User user;

    public int login(User loginuser) {
        if (loginuser.checkUser()) {
            loginuser.encryptionPassword();
            user = userDao.selectByUsername(loginuser.getUsername());
            if (user != null) {
                if (loginuser.getPassword().equals(user.getPassword())) {
                    return PASS;
                } else {
                    return PASSERR;
                }
            } else {
                return USERNOTFOUND;
            }
        }
        return USERNULL;
    }

    public int register(User user) {
        user.setPassword(MD5.generateCode(user.getPassword()));

        return userDao.insertSelective(user);
    }

    public static User getLogin(HttpSession session) {
        return (User) session.getAttribute("user");

    }

    public User getUser() {
        return user;
    }
}
