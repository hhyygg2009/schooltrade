package com.yu.st.controller.handler;

import com.yu.st.bean.Reply;
import com.yu.st.bean.vo.Message;
import com.yu.st.dao.ReplyDao;
import com.yu.st.service.impl.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/30 17:14
 */
@RequestMapping("/api/reply")
@RestController
@AllArgsConstructor
public class ReplyHandler {

    ReplyDao replyDao;
    ReplyService replyService;


    @PostMapping("/get/{commentId}")
    public Message getReply(@PathVariable Integer commentId) {
        List<Reply> replyList = replyDao.selectByCommentId(commentId);
        return Message
                .success()
                .addData("replyList", replyList);

    }

    @PostMapping("/create")
    public Message createReply(Reply reply, HttpSession session) {
        return replyService.createReply(reply, session);

    }

}
