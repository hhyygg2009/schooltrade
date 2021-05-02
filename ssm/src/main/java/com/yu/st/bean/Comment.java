package com.yu.st.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * comment
 *
 * @author
 */
@Data
@Component
public class Comment implements Serializable {
    private Integer id;

    private Integer itemId;

    private Integer userId;

    private String content;

    private static final long serialVersionUID = 1L;
}