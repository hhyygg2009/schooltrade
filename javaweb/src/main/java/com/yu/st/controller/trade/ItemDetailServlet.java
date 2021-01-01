package com.yu.st.controller.trade;

import com.yu.st.entity.Item;
import com.yu.st.entity.Message;
import com.yu.st.service.impl.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/22 11:22
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/trade/detail")
public class ItemDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id;

        id = request.getParameter("id");

        Message message = new Message();
        ItemService itemService = new ItemService();

//        HttpSession session=request.getSession();
        Cookie[] cookies = request.getCookies();
        if (id != null) {
//            Cookie itemCookie=getCookie(cookies,"items");
//            Cookie itemCookie=new Cookie("items", );

            Item item = itemService.getItem(Integer.parseInt(id));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/trade/detail.jsp");
            request.setAttribute("item", item);
            requestDispatcher.forward(request, response);
        }

    }

//    Cookie getCookie(Cookie[] cookies,String name){
//        if(cookies!=null){
//            for (Cookie c:cookies){
//                if(c.getName().equals(name)){
//                    return c;
//                }
//            }
//            return null;
//        }
//    }
}
