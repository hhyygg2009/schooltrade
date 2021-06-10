package com.yu.st.bean.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/2 15:46
 */
@Data
@Document
@Accessors(chain = true)
public class UploadFile {
    @Id
    private String id;
    private String name;
    private LocalDateTime createTime;
    private Binary content;
    private String contentType;
    private long size;

}
