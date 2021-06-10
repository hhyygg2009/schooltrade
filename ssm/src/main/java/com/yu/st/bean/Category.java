package com.yu.st.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * category
 *
 * @author
 */
@Data
@Component

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "value")
    @JsonProperty(value = "value")
    private Integer id;
    /**
     * 分类名
     */
    private String name;
}