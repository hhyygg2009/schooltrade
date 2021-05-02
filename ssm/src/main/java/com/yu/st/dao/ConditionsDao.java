package com.yu.st.dao;

import com.yu.st.bean.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Condition record);

    int insertSelective(Condition record);

    Condition selectByPrimaryKey(Integer id);

    List<Condition> selectAll();

    int updateByPrimaryKeySelective(Condition record);

    int updateByPrimaryKey(Condition record);
}