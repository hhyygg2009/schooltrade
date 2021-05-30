package com.yu.st.controller.handler;

import com.yu.st.bean.Item;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.ItemDao;
import com.yu.st.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/item")
public class ItemHandler {
    ItemDao itemDao;

    @Cacheable(cacheNames = "getItem", key = "#id")
    @RequestMapping("/{id}/get")
    public Message itemGet(@PathVariable Integer id) {
        Item item = itemDao.selectByPrimaryKey(id);
        return Message.success().addData("item", item);

    }

    @RequestMapping("/{id}/on")
    public Message itemState(@PathVariable Integer id) {
        Item item = itemDao.selectByPrimaryKey(id);
        item.setStateId(item.getStateId() == 0 ? 1 : 0);
        if (itemDao.updateItem(item) > 0) {
            return Message.success();
        }
        return Message.error();
    }

    @RequestMapping("/{id}/delete")
    public Message itemDelete(@PathVariable Integer id) {
        if (itemDao.deleteByPrimaryKey(id) > 0) {
            return Message.success();
        }

        return Message.error();
    }

    @RequestMapping("/update")
    public Message itemGet(@RequestBody Item item) {
        if (itemDao.updateItem(item) > 0) {
            return Message.success();
        }
        return Message.error();
    }

    @PostMapping("/create")
    public Message itemInsert(@RequestBody Item item, HttpSession session) {
        //按照登录用户添加物品
        Integer userid = (UserService.getLoginUser(session)).getId();
        item.setUserId(userid);

        if (itemDao.insertSelective(item) > 0) {
            return Message.success();
        }
        return Message.error();
    }
}

