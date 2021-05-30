package com.yu.st.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * reply
 *
 * @author
 */
@Data
public class Reply implements Serializable {
    private Integer id;

    private Integer commentId;

    private Integer replyId;

    private Integer replyType;

    private String content;

    private Integer fromUid;

    private Integer toUid;

    private User user;

    private static final long serialVersionUID = 1L;
}