package com.yu.st.controller.handler;

import com.yu.st.bean.Comment;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.CommentDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.service.impl.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
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
    CommentService commentService;

    @PostMapping("/create")
    public Message createComment(Comment comment, HttpSession session) {
        return commentService.createComment(comment, session);
    }

    @PostMapping("/get/{itemId}")
    public Message getCommentByItem(@PathVariable Integer itemId) {
        List<Comment> comments = commentDao.selectByTopicId(itemId);
        return Message
                .success()
                .addData("comments", comments);
    }

    @PostMapping("/del/{commentId}")
    public Message delComment(@PathVariable Integer commentId, HttpSession session) {
        return commentService.delComment(commentId, session);
    }


}
