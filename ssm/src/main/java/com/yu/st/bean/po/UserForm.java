package com.yu.st.bean.po;

import com.yu.st.bean.User;
import lombok.Data;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/27 22:06
 */
@Data
public class UserForm extends User{
    private String captcha;
}
