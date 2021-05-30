package com.yu.st.dao;

import com.yu.st.bean.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    List<Reply> selectByCommentId(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}