package com.yu.st.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author
 */
@Data
public class Comment implements Serializable {
    private Integer id;

    private Integer topicId;

    private Integer topicType;

    private String content;

    private Integer fromUid;

    private User user;

    private static final long serialVersionUID = 1L;
}