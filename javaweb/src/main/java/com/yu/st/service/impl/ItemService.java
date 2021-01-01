package com.yu.st.service.impl;

import com.yu.st.dao.impl.ItemDao;
import com.yu.st.entity.Item;
import com.yu.st.service.iItemService;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/21 13:01
 * @package :com.yu.st.service.impl
 * @description:
 * @modified By：
 * @version:
 */
public class ItemService implements iItemService {


    public Item getItem(int id) {
        return ItemDao.getItem(id);
    }

    public int addItem(Item item) {
        return ItemDao.addItem(item);
    }


}
