package com.yu.st.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * conditions
 *
 * @author
 */
@Data
public class Conditions implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 新旧程度
     */
    private String name;
}