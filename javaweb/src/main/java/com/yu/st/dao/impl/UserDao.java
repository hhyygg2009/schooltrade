package com.yu.st.dao.impl;

import com.yu.st.dao.IUserDao;
import com.yu.st.entity.User;
import com.yu.st.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDao {
    private static SqlSession sqlSession;
    private static IUserDao iUserDao;

    static {
        sqlSession = DBUtil.getSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }


    public static User getUser(int userId) {
        return iUserDao.selectByPrimaryKey(userId);
    }

    public static User getUserInfo(int userId) {
        return iUserDao.selectUserinfo(userId);
    }

    public static int updateUser(User user) {
        return iUserDao.updateByPrimaryKeySelective(user);
    }

    public static User getUser(User user) {
        return iUserDao.selectByUsername(user.getUsername());
    }

    public static int addUser(User user) {
        return iUserDao.insertSelective(user);
    }


}
