package com.yu.st.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * reply
 *
 * @author
 */
@Data
@Component
public class Reply implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer replyType;

    private Integer commentId;

    private String content;

    private static final long serialVersionUID = 1L;
}