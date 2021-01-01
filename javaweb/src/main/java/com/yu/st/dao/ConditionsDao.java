package com.yu.st.dao;

import com.yu.st.entity.Conditions;

import java.util.List;

public interface ConditionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Conditions record);

    int insertSelective(Conditions record);

    Conditions selectByPrimaryKey(Integer id);

    List<Conditions> selectAll();

    int updateByPrimaryKeySelective(Conditions record);

    int updateByPrimaryKey(Conditions record);
}