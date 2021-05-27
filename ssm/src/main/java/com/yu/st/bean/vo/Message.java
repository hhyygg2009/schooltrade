package com.yu.st.bean.vo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
@NoArgsConstructor
public class Message {

    //默认状态
    int code = -1;
    String msg = "error";
    private Map<String, Object> data = null;

    public Message(int code) {
        this.code = code;
    }

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


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
