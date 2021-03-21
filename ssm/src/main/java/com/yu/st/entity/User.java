package com.yu.st.entity;

import com.yu.st.util.MD5;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Item> items;
    private Integer id;
    private String username;
    private String password;
    /**
     * 是否管理员
     */
    private Integer flag;
    private String phone;
    /**
     * 注册时间
     */
    private Date regtime;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private Integer sex;

    public Boolean checkUser(){
        return username != null && password != null;
    }

    public void encryptionPassword(){
        password = MD5.generateCode(password);
    }

}