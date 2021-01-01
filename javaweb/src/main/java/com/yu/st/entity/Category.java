package com.yu.st.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * category
 *
 * @author
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 分类名
     */
    private String name;
}