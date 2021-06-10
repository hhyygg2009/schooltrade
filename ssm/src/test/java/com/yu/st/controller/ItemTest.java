package com.yu.st.controller;

import com.alibaba.fastjson.JSON;
import com.yu.st.bean.Category;
import com.yu.st.bean.Condition;
import com.yu.st.bean.Item;
import com.yu.st.bean.vo.FormItem;
import com.yu.st.bean.vo.Message;
import com.yu.st.bean.vo.SelectedItem;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemTest {

    @Autowired
    ItemDao ItemDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ConditionsDao conditionsDao;


    @Test
    void items() {
        List<Item> items = ItemDao.getAllItem(0, 10);
        System.out.println(items);
    }

    @Test
    void itemInfo() {
        ArrayList arrayList = new ArrayList();
        FormItem formItem = new FormItem("类别", "category", FormItem.CHECKBOX);

        List<Category> categories = categoryDao.selectAll();
        formItem.setData(categories);


        List<Condition> conditions = conditionsDao.selectAll();

        arrayList.add(formItem);

        System.out.println(
                JSON.toJSONString(
                        Message
                                .success()
                                .setData(arrayList)
                )


        );
    }

    @Test
    public void jsonTest() {
        String json = "{\"pageNum\":1,\"keyword\":\"\",\"selectedItem\":{\"values\":{\"category\":\"undefined\",\"conditions\":\"\"},\"names\":{\"category\":\"图书\",\"conditions\":\"\"}}}";

        System.out.println(JSON.parseObject(json, SelectedItem.class));
        System.out.println(json);

    }

//    @Autowired
//    StringEncryptor stringEncryptor;//密码解码器自动注入
//
//    @Test
//    public void encyption(){
//        System.out.println(stringEncryptor.encrypt("123456"));
//    }
}