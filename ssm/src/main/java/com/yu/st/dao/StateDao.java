package com.yu.st.dao;

import com.yu.st.bean.State;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(State record);

    int insertSelective(State record);

    State selectByPrimaryKey(Integer id);

    List<State> selectAll();

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);
}