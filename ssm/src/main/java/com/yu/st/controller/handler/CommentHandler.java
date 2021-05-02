package com.yu.st.controller.handler;

import com.yu.st.bean.Comment;
import com.yu.st.bean.User;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.CommentDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/23 20:34
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/comment")
public class CommentHandler {
    CommentDao commentDao;
    ItemDao itemDao;

    @PostMapping("/create")
    public Message createComment(Comment comment, HttpSession session, Message message) {
        User user = UserService.getLogin(session);

        comment.setUserId(user.getId());
        commentDao.insertSelective(comment);
        message.setnoerror();

        return message;

    }

    @PostMapping("/get")
    public Message getCommentByItem(Integer itemId, Message message) {
        List<Comment> comments = commentDao.selectByItem(itemId);

        message.addData("comments", comments);
        message.setnoerror();

        return message;
    }

    @PostMapping("/del")
    public Message delComment(Integer commentId, Message message, HttpSession session) {
        User user = (User) session.getAttribute("user");

        Comment comment = commentDao.selectByPrimaryKey(commentId);
        if (comment.getUserId().equals(user.getId())) {
            commentDao.deleteByPrimaryKey(commentId);
            message.setnoerror();
        }

        return message;
    }


}
