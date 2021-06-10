package com.yu.st.bean.po;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/26 0:11
 */
@Component
@Data
@RequiredArgsConstructor
public class Paged {

    private int pageNum = 1;
    private int pageSize = 10;
    /**
     * 限制页面最大显示数量
     */
    private int pageSizeLimit = 100;


    public Integer getStartIndex() {
        return pageSize * (pageNum - 1);
    }

    public Integer getEndIndex() {
        return this.getStartIndex() + pageSize;
    }

    public Integer getPageSize() {
        return Math.min(pageSize, pageSizeLimit);
    }


}
