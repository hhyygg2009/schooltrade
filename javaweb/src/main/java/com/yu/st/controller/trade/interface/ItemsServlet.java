package com.yu.st.controller.trade;

import com.yu.st.dao.impl.ItemDao;
import com.yu.st.entity.Item;
import com.yu.st.entity.Message;
import com.yu.st.service.impl.ItemService;

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
 * @date :Created in 2020/12/27 20:53
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/trade/items")
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id, useridStr, oper, keyword, pageNumStr;
        int pageSize, pageNum = 0, startIndex;
        Integer useridInt;

        id = request.getParameter("id");
        useridStr = request.getParameter("userid");
        oper = request.getParameter("oper");
        keyword = request.getParameter("keyword");
        pageNumStr = request.getParameter("curr");

        //分页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        } else {
            pageNum = 1;
        }

        pageSize = 10;
        startIndex = pageSize * (pageNum - 1);


        HttpSession session = request.getSession();
        useridInt = (Integer) session.getAttribute("userid");
        if (useridStr != null) {
            useridInt = Integer.parseInt(useridStr);
        }

        Message message = new Message();
        ItemService itemService = new ItemService();

        //分页查询:物品总数
        Integer count = null;
        List<Item> items = null;

        count = ItemDao.selectAllCount();
        if (keyword != null && !keyword.equals("null")) {
            items = ItemDao.selectByKeyword(keyword, startIndex, pageSize);
        } else if (useridStr != null) {
            items = ItemDao.selectByUserId(useridInt, startIndex, pageSize);
        } else {
            items = ItemDao.getAllItem(startIndex, pageSize);

        }
        if (items != null && !items.isEmpty()) {
            if (count != null) {
                message.addData("count", count);
            }
            message.addData("items", items);
            message.setnoerror();

        } else {
            message.setMsg("找不到物品");
        }


        response.getWriter().println(message);

    }


}
