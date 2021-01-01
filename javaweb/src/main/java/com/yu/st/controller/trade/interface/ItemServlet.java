package com.yu.st.controller.trade;

import com.alibaba.fastjson.JSON;
import com.yu.st.dao.impl.ItemDao;
import com.yu.st.entity.Item;
import com.yu.st.entity.Message;
import com.yu.st.service.impl.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/21 13:09
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */

@WebServlet("/trade/item")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id, oper, userid, key;
        Integer useridInt;

        id = request.getParameter("id");
        userid = request.getParameter("userid");
        oper = request.getParameter("oper");
        key = request.getParameter("key");
        String json = request.getParameter("data");

        HttpSession session = request.getSession();
        if (userid != null) {
            useridInt = Integer.parseInt(userid);
        } else {
            useridInt = (Integer) session.getAttribute("userid");
        }

        Message message = new Message();
        ItemService itemService = new ItemService();
        List<Item> items = null;
        Item item = null;


        try {
            if (oper != null) {
                switch (oper) {
                    case "get":
                        if (id != null) {
                            item = itemService.getItem(Integer.parseInt(id));
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/trade/detail.jsp");
                            request.setAttribute("item", item);
                            requestDispatcher.forward(request, response);
                        }
                        break;


                    case "insert":
                        int status;
                        item = JSON.parseObject(json, Item.class);
                        if (item.getId() != null) {
                            status = ItemDao.updateItem(item);
                        } else {
                            item.setUserId(useridInt);
                            status = itemService.addItem(item);
                        }
                        if (status > 0) {
                            message.setnoerror();
                        }
                        response.getWriter().println(message);
                        break;

//                case "update":
//                    item = JSON.parseObject(json, Item.class);
//                    ItemDao.updateItem(item);
//                    break;

                    case "del":
                        item = new Item();
                        item.setId(Integer.parseInt(id));
                        status = ItemDao.delItem(item);
                        if (status == 1) {
                            message.setnoerror();
                        }
                        response.sendRedirect(request.getContextPath() + "/trade/my");
                        break;

                    case "on":
                        item = ItemDao.getItem(Integer.parseInt(id));
                        item.setStateId(item.getStateId() == 0 ? 1 : 0);
                        ItemDao.updateItem(item);
                        message.setnoerror();
                        response.sendRedirect(request.getContextPath() + "/trade/my");
                        break;


                    default:
                }
            }
        } catch (NumberFormatException e) {
            message.setMsg("用户未登录");
            response.getWriter().println(message);
        }


    }
}
