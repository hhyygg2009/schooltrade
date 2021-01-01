package com.yu.st.dao.impl;

import com.yu.st.entity.Item;
import com.yu.st.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 23:10
 * @package :com.yu.st.dao
 * @description:
 * @modified By：
 * @version:
 */
public class ItemDao {
    private static SqlSession sqlSession;
    private static com.yu.st.dao.iItemDao iItemDao;

    static {
        sqlSession = DBUtil.getSession();
        iItemDao = sqlSession.getMapper(com.yu.st.dao.iItemDao.class);
    }

    public static Item getItem(int id) {
        return iItemDao.selectByPrimaryKey(id);
    }

    public static List<Item> getAllItem(int start, int limit) {
        return iItemDao.selectAllItem(start, limit);
    }


    public static List<Item> selectByKeyword(String keyword, int start, int limit) {
        return iItemDao.selectByKeyword(keyword, start, limit);
    }

    public static int selectAllCount() {
        return iItemDao.selectAllCount();
    }

    public static int addItem(Item item) {
        return iItemDao.insertSelective(item);
    }

    public static int delItem(Item item) {
        return iItemDao.deleteByPrimaryKey(item.getId());
    }

    public static int updateItem(Item item) {
        return iItemDao.updateByPrimaryKeySelective(item);
    }

    public static List<Item> selectByUserId(int id, int startIndex, int pageSize) {
        return iItemDao.selectByUserId(id, startIndex, pageSize);
    }

//    public static List


}
