package com.yu.st.dao.impl;

import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.StateDao;
import com.yu.st.dao.iItemDao;
import com.yu.st.entity.Category;
import com.yu.st.entity.Conditions;
import com.yu.st.entity.State;
import com.yu.st.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/22 15:08
 * @package :com.yu.st.dao
 * @description:
 * @modified By：
 * @version:
 */
public class itemInfo {
    private static SqlSession sqlSession;
    private static com.yu.st.dao.iItemDao iItemDao;
    private static CategoryDao category;
    private static ConditionsDao conditions;
    private static StateDao state;

    static {
        sqlSession = DBUtil.getSession();
        iItemDao = sqlSession.getMapper(iItemDao.class);
        category = sqlSession.getMapper(CategoryDao.class);
        conditions = sqlSession.getMapper(ConditionsDao.class);
        state = sqlSession.getMapper(StateDao.class);
    }

    public static List<Category> getAllCategory() {
        return category.selectAll();
    }

    public static List<State> getAllState() {
        return state.selectAll();
    }

    public static List<Conditions> getAllConditions() {
        return conditions.selectAll();
    }
}
