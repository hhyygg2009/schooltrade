package com.yu.st.service.impl;

import com.yu.st.bean.Comment;
import com.yu.st.bean.User;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.CommentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/30 17:06
 */
@Service
@AllArgsConstructor
public class CommentService {

    CommentDao commentDao;

    public Message createComment(Comment comment, HttpSession session) {
        User user = UserService.getLoginUser(session);

        if (user != null) {
            comment.setFromUid(user.getId());
            commentDao.insertSelective(comment);
            return Message.success();
        } else {
            return Message
                    .error()
                    .setMsg(UserService.MSG[UserService.USER_NOT_FOUND]);
        }
    }

    public Message delComment(Integer commentId, HttpSession session) {
        User user = UserService.getLoginUser(session);
        if (user != null) {
            Comment comment = commentDao.selectByPrimaryKey(commentId);
            if (comment.getFromUid().equals(user.getId())) {
                commentDao.deleteByPrimaryKey(commentId);
                return Message.success();
            }
        }
        return Message
                .error()
                .setMsg(UserService.MSG[UserService.USER_NOT_FOUND]);

    }
}
