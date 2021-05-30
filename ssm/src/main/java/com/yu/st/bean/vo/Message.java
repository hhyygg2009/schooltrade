package com.yu.st.bean.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/20 22:22
 */
@Data
@Accessors(chain = true)
public class Message implements Serializable {

    /*
    默认状态
    */
    int code = -1;
    String msg = "error";
    private Object data = null;

    public static Message build(int code, String msg, Map<String, Object> data) {
        return new Message()
                .setCode(code)
                .setMsg(msg)
                .setData(data);
    }


    public static Message success() {
        return new Message()
                .setCode(0)
                .setMsg("success")
                .setData(null);
    }

    public static Message error() {
        return new Message();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Message addData(String name, Object object) {
        if (data == null) {
            data = new HashMap<>(16);
        }
        if (this.data instanceof Map) {
            ((Map) this.data).put(name, object);
        }
        return this;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
