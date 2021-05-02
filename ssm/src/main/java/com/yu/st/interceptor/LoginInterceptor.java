package com.yu.st.interceptor;

import com.yu.st.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 20:31
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (checkAuth(request.getRequestURI(), user)) {
            return true;
        } else {
            response.sendRedirect("/passport/login");
            return false;
        }
    }

    public boolean checkAuth(String uri, User user) {
        String[] stopList = {"passport/profile", "my", "newitem"};
        String[] allowList = {"static","passport/login"};
        if (user != null) {
            System.out.println(user);
            return true;
        }
        for(String allow:allowList){
            if(uri.indexOf(allow)>0){
                return true;
            }
        }
        for (String stop : stopList) {
            if (uri.indexOf(stop) > 0) {
                return false;
            }
        }

        return true;
    }
}
