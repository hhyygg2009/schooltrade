package com.yu.st.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * state
 *
 * @author
 */
@Data
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 是否上架
     */
    private String name;
}