package com.yu.st.dao;

import com.yu.st.bean.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByTopicId(Integer itemId);
}