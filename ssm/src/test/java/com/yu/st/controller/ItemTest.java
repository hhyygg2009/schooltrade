package com.yu.st.controller;

import com.yu.st.bean.Item;
import com.yu.st.dao.ItemDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemTest {
        @Resource
    ItemDao ItemDao;


    @Test
    void items() {
        List<Item> items = ItemDao.getAllItem(0, 10);
    }
}