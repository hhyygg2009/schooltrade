package com.yu.st.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * state
 *
 * @author
 */
@Data
@Component
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 是否上架
     */
    private String name;
}