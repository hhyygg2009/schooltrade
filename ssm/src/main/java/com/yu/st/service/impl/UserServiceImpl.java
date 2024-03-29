package com.yu.st.service.impl;

import com.yu.st.bean.User;
import com.yu.st.bean.po.UserForm;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.UserDao;
import com.yu.st.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 16:09
 */

@Service
public class UserServiceImpl implements com.yu.st.service.UserService {

    public static final int CAPTCHA_ERR = 4, USER_NULL = 3, USER_NOT_FOUND = 2, PASS_ERR = 1, PASS = 0;
    public static final String[] MSG = {"登录成功", "密码错误", "用户名不存在", "输入为空", "验证码错误"};
    public static final String USER_SESSION_ATTR = "user";

    @Autowired
    UserDao userDao;

    @Override
    public int registerAction(UserForm userForm, HttpSession session) {

        if (captchaCheck(session, userForm.getCaptcha())) {
            if (userDao.selectByPrimaryKey(userForm.getId()) != null) {
                return -2;
            } else {
                userForm.setPassword(MD5.generateCode(userForm.getPassword()));
                if (userDao.insertSelective(userForm) > 0) {
                    return 0;
                }
                return -1;
            }
        } else {
            return UserServiceImpl.CAPTCHA_ERR;
        }
    }

    @Override
    public Message loginAction(UserForm userForm, HttpSession session) {
        int status;
        if (captchaCheck(session, userForm.getCaptcha())) {
            User user = userDao.selectByUsername(userForm.getUsername());
            if (user == null) {
                status = UserServiceImpl.PASS_ERR;
            } else {
                session.setAttribute("user", user);
                status = UserServiceImpl.PASS;
            }
        } else {
            status = UserServiceImpl.CAPTCHA_ERR;
        }
        return Message.build(status, UserServiceImpl.MSG[status], null);
    }

    @Override
    public Message updateAction(User user, HttpSession session) {
        if (com.yu.st.service.UserService.checkUser(user, session)) {
            userDao.updateByPrimaryKeySelective(user);
            return Message.success();
        }
        return Message.error();
    }


    @Override
    public boolean captchaCheck(HttpSession session, String captchaIn) {
        String captcha = (String) session.getAttribute("captcha");
        return captchaIn != null && captchaIn.equals(captcha);
    }
}
