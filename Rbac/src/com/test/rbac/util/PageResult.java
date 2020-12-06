package com.test.rbac.util;

import lombok.*;

import java.util.Collections;
import java.util.List;

/*
* 分页查询结果数据
* */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResult {

    // 空白页面
    public static final PageResult EMPTY_PAGE = new PageResult(1, 5, 0,
            Collections.EMPTY_LIST);

    // 三板斧
    private int currentPage;
    private int pageSize;

    private int totalCount;  //总条数
    private List<?> data;

    private int endPage;  //总页数
    private int prevPage;
    private int nextPage;

    public PageResult(int currentPage, int pageSize, int totalCount,
                      List<?> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;

        // ------------------------------
        if (totalCount == 0) {
            endPage = 1;
            prevPage = 1;
            nextPage = 1;
            return;
        }
        endPage = totalCount % pageSize != 0 ? totalCount / pageSize + 1
                : totalCount / pageSize;
        prevPage = currentPage - 1 > 1 ? currentPage - 1 : 1;
        nextPage = currentPage + 1 < endPage ? currentPage + 1 : endPage;
    }
}
