package com.yu.st.dao;

import com.yu.st.bean.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);
    Item selectUserOwnItem(@Param("id") Integer id,@Param("userid")Integer userid);


    List<Item> getAllItem(@Param("start") Integer start, @Param("limit") Integer limit);


    List<Item> selectByKeyword(@Param("keyword") String keyword, @Param("start") Integer start, @Param("limit") Integer limit);
    Integer selectByKeywordcount(@Param("keyword") String keyword);

    List<Item> selectByUserId(@Param("id") Integer id, @Param("start") Integer start, @Param("limit") Integer limit);
    Integer selectByUserIdcount(@Param("id") Integer id);

    int updateItem(Item record);

    int updateByPrimaryKey(Item record);

    int selectAllCount();
}