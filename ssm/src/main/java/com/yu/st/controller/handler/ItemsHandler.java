package com.yu.st.controller.handler;

import com.yu.st.bean.Item;
import com.yu.st.bean.User;
import com.yu.st.bean.po.Paged;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.dao.UserDao;
import com.yu.st.service.impl.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemsHandler {
    private final ItemDao itemDao;
    private final ConditionsDao conditionsDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;


    @RequestMapping("/gets")
    public Message items(@RequestParam(required = false) String keyword,
                         Paged paged,
                         Message message) {

        //分页
        //分页查询:物品总数
        Integer count = null;
        List<Item> items = null;

        if (keyword != null && !keyword.equals("null")) {
            count = itemDao.selectByKeywordcount(keyword);
            items = itemDao.selectByKeyword(keyword, paged.getStartIndex(), paged.getPageSize());
        } else {
            count = itemDao.selectAllCount();
            items = itemDao.getAllItem(paged.getStartIndex(), paged.getPageSize());
        }
        message.addData("count", count);
        message.addData("items", items);
        message.setnoerror();

        return message;
    }

    @RequestMapping("/history/gets")
    public Message itemshistory(HttpSession session, Paged paged, Message message, ItemService itemService) {
        Set<Integer> itemHistorySet = itemService.itemSessionInit(session);

        //分页
        //分页查询:物品总数
        int count = itemHistorySet.size();
        List<Item> items = new ArrayList<>();

        Integer[] itemHistoryList= (Integer[]) itemHistorySet.toArray(new Integer[0]);



        for(int i=paged.getStartIndex();i<= paged.getEndIndex()&&i<count;i++){
            items.add(itemDao.selectByPrimaryKey(itemHistoryList[i]));
        }


//        for (int itemid : itemHistorySet) {
//            items.add(itemDao.selectByPrimaryKey(itemid));
//        }
        message.addData("count", count);
        message.addData("items", items);
        message.setnoerror();


        return message;

    }

    @RequestMapping(value = {"/user/{userid}/gets", "/user/gets"})
    public Message getbyuser(HttpSession session, @PathVariable(required = false) Integer userid, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Message message) {
        User user = (User) session.getAttribute("user");
        if (userid != null || user != null) {
            if (userid == null) {
                userid = user.getId();
            }
            //分页
            int startIndex = pageSize * (pageNum - 1);
            //分页查询:物品总数
            Integer count = itemDao.selectByUserIdcount(userid);
            List<Item> items = itemDao.selectByUserId(userid, startIndex, pageSize);

            message.addData("count", count);
            message.addData("items", items);
            message.setnoerror();
        }

        return message;
    }
}
