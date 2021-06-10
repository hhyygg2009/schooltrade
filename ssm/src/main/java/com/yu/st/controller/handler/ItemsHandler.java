package com.yu.st.controller.handler;

import com.alibaba.fastjson.JSON;
import com.yu.st.bean.Category;
import com.yu.st.bean.Condition;
import com.yu.st.bean.Item;
import com.yu.st.bean.User;
import com.yu.st.bean.po.Paged;
import com.yu.st.bean.vo.FormItem;
import com.yu.st.bean.vo.Message;
import com.yu.st.bean.vo.SelectedItem;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.dao.UserDao;
import com.yu.st.service.impl.ItemService;
import com.yu.st.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemsHandler {
    private final ItemDao itemDao;
    private final ConditionsDao conditionsDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;

    //    @Cacheable(cacheNames = "ItemGets", key = "#keyword+'-'+#paged.pageNum+'-'+#paged.pageSize+'-'+#paged.pageSizeLimit")
    @RequestMapping("/gets")
    public Message items(Paged paged,
                         @RequestParam(required = false) String keyword,
                         @RequestParam(name = "selectedItem", required = false) String selectedItemStr) {

        //分页
        //分页查询:物品总数
        Integer count;
        List<Item> items;
        SelectedItem selectedItem = JSON.parseObject(selectedItemStr, SelectedItem.class);

        if (selectedItem != null) {
            count = itemDao.selectByKeywordcount(keyword);
            items = itemDao.selectByKeywordSelected(keyword, paged.getStartIndex(), paged.getPageSize(), selectedItem.getValues());
        } else if (!StringUtils.isEmpty(keyword)) {
            count = itemDao.selectByKeywordcount(keyword);
            items = itemDao.selectByKeyword(keyword, paged.getStartIndex(), paged.getPageSize());
        } else {
            count = itemDao.selectAllCount();
            items = itemDao.getAllItem(paged.getStartIndex(), paged.getPageSize());
        }
        System.out.println(selectedItem);

        return Message.success()
                .addData("count", count)
                .addData("items", items);


    }

    @RequestMapping("/history/gets")
    public Message itemsHistory(HttpSession session, Paged paged, ItemService itemService) {
        HashSet<Integer> itemHistorySet = itemService.itemSessionInit(session);

        //分页
        //分页查询:物品总数
        int count = itemHistorySet.size();
        List<Item> items = new ArrayList<>();

        Integer[] itemHistoryList = itemHistorySet.toArray(new Integer[0]);

        for (int i = paged.getStartIndex(); i <= paged.getEndIndex() && i < count; i++) {
            items.add(itemDao.selectByPrimaryKey(itemHistoryList[i]));
        }

        return Message.success()
                .addData("count", count)
                .addData("items", items);

    }

    @Cacheable(cacheNames = "ItemGetByUser", key = "#userid+'-'+#paged.pageNum+'-'+#paged.pageSize+'-'+#paged.pageSizeLimit")
    @RequestMapping(value = {"/user/{userid}/gets", "/user/gets"})
    public Message getByUser(HttpSession session, @PathVariable(required = false) Integer userid, Paged paged) {
        User user = UserService.getLoginUser(session);
        if (userid != null || user != null) {
            if (userid == null) {
                userid = user.getId();
            }
            //分页
            //分页查询:物品总数
            Integer count = itemDao.selectByUserIdcount(userid);
            List<Item> items = itemDao.selectByUserId(userid, paged.getStartIndex(), paged.getPageSize());

            return Message.success()
                    .addData("count", count)
                    .addData("items", items);
        }

        return Message.error();
    }

    @RequestMapping("/filter")
    public Message getFilter() {
        ArrayList<FormItem> dataList = new ArrayList<>();

        List<Category> categories = categoryDao.selectAll();
        List<Condition> conditions = conditionsDao.selectAll();

        dataList.add(new FormItem("类别", "category_id", FormItem.CHECKBOX, categories));
        dataList.add(new FormItem("状态", "conditions_id", FormItem.CHECKBOX, conditions));

        return Message
                .success()
                .setData(dataList);
    }
}
