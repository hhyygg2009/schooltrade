package com.yu.st.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 22:22
 * @package :com.yu.st.controller
 * @description:
 * @modified By：
 * @version:
 */
@Data
public class Message {

    //默认状态
    int code = -1;
    String msg = "error";
    private Map<String, Object> data = null;


    public void addData(String name, Object object) {
        if (data == null) {
            data = new HashMap<>();
        }
        this.data.put(name, object);
    }

    public void setnoerror() {
        code = 0;
        msg = "noerror";
    }


    public String toString() {
        return JSON.toJSONString(this);
    }

}
