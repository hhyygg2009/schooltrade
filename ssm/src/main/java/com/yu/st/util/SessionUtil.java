package com.yu.st.util;

import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/28 10:51
 */
public class SessionUtil {

    @SuppressWarnings("unchecked")
    public static  <T> T getAttribute(HttpSession session, String attribute){
        return (T)session.getAttribute(attribute);
    }

}
