package com.yu.st.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/2 21:16
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class FormItem {
    public static String RADIO = "radio", CHECKBOX = "checbox";

    private String title;
    private String name;
    private String type;
    private List data;

    public FormItem(String title, String name, String type) {
        this.title = title;
        this.name = name;
        this.type = type;


    }

    public static FormItem build(String title, String name, String type) {
        return new FormItem(title, name, type);
    }
}
