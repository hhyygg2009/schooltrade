package com.yu.st.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * item
 *
 * @author
 */
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private User user;
    private Category category;
    private Conditions conditions;
    private State state;
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private Long price;
    /**
     * 商品描述
     */
    private String info;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 是否上架
     */
    private Integer stateId;
    /**
     * 商品分类
     */
    private Integer categoryId;
    /**
     * 新旧程度
     */
    private Integer conditionsId;
    /**
     * 所属用户
     */
    private Integer userId;
    private String pic1;
    private String pic2;
    private String pic3;
}