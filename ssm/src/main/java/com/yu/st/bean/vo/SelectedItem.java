package com.yu.st.bean.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/2 22:53
 */
@Data
public class SelectedItem implements Serializable {
    private Map<String, String> values;
    private Map<String, String> names;
}
