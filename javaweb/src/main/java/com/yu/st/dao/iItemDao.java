package com.yu.st.dao;

import com.yu.st.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface iItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);


    List<Item> selectAllItem(@Param("start") Integer start, @Param("limit") Integer limit);


    List<Item> selectByKeyword(@Param("keyword") String keyword, @Param("start") Integer start, @Param("limit") Integer limit);

    List<Item> selectByUserId(@Param("id") Integer id, @Param("start") Integer start, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    int selectAllCount();
}