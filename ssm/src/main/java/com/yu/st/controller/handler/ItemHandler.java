package com.yu.st.controller.handler;

import com.yu.st.bean.Item;
import com.yu.st.bean.User;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item")
public class ItemHandler {
    ItemDao ItemDao;
    ConditionsDao conditionsDao;
    CategoryDao categoryDao;


    @RequestMapping("/{id}/get")
    public Message itemGet(@PathVariable Integer id, Message message) {
        Item item = ItemDao.selectByPrimaryKey(id);
        message.addData("item", item);
        return message;
    }

    @RequestMapping("/{id}/on")
    public Message itemState(@PathVariable Integer id, Message message) {
        Item item = ItemDao.selectByPrimaryKey(id);
        item.setStateId(item.getStateId() == 0 ? 1 : 0);
        if (ItemDao.updateItem(item) > 0) {
            message.setnoerror();
        }
        return message;
    }

    @RequestMapping("/{id}/delete")
    public Message itemDelete(@PathVariable Integer id, Message message) {
        if (ItemDao.deleteByPrimaryKey(id) > 0) {
            message.setnoerror();
        }

        return message;
    }

    @RequestMapping("/update")
    public Message itemGet(@RequestBody Item item, Message message) {
        if (ItemDao.updateItem(item) > 0) {
            message.setnoerror();
        }
        return message;
    }

    @PostMapping("/create")
    public Message itemInsert(@RequestBody Item item, Message message, HttpSession session) {
        //按照登录用户添加物品
        Integer userid = ((User) session.getAttribute("user")).getId();
        item.setUserId(userid);

        if (ItemDao.insertSelective(item) > 0) {
            message.setnoerror();
        }
        return message;
    }
}

