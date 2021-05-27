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

    @Autowired
    UserDao userDao;

    public int registerAction(UserForm userForm, HttpSession session) {
        if (!captchaCheck(session, userForm.getCaptcha())) {
            return UserService.CAPTCHAERR;
        }else if (userDao.selectByPrimaryKey(userForm.getId()) == null) {
            return -1;
        }else{
            userForm.setPassword(MD5.generateCode(userForm.getPassword()));
            if(userDao.insertSelective(userForm)>0){
                return 0;
            }
            return -1;
        }
    }

    public Message loginAction(UserForm userForm, HttpSession session) {
        int status;
        if (!captchaCheck(session, userForm.getCaptcha())) {
            status = UserService.CAPTCHAERR;
        }else{
            User user = userDao.selectByUsername(userForm.getUsername());
            if (user == null) {
                status = UserService.PASSERR;
            } else {
                session.setAttribute("user", user);
                status = UserService.PASS;
            }
        }
        return new Message(status, UserService.msg[status]);
    }


    public static User getLoginUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }



    public boolean captchaCheck(HttpSession session, String captchaIn) {
        String captcha = (String) session.getAttribute("captcha");
        return captchaIn != null && captchaIn.equals(captcha);
    }
}
