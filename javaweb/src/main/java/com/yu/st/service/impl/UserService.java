package com.yu.st.service.impl;

import com.yu.st.dao.impl.UserDao;
import com.yu.st.entity.User;
import com.yu.st.service.IUserService;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 16:09
 * @package :com.yu.st.service.impl
 * @description:
 * @modified By：
 * @version:
 */


public class UserService implements IUserService {

    public static final int USERNOTFOUND = 2;
    public static final int PASSERR = 1;
    public static final int PASS = 0;
    public static final String[] msg = {"登录成功", "密码错误", "用户名不存在", "输入为空", "验证码错误"};

    public User user;

    public int login(User loginuser) {
        user = UserDao.getUser(loginuser);
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

    public int register(User user) {
        return UserDao.addUser(user);
    }
}
