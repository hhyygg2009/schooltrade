package com.yu.st.dao;

import com.yu.st.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User getUser(Integer id);

    User selectByUsername(String username);

    int addUser(User record);

    int updateByPrimaryKey(User record);
}