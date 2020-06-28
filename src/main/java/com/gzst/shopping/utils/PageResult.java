package com.gzst.shopping.utils;

import java.util.List;

/**
 * 分页结果类
 *
 * @param <E>
 */
public class PageResult<E> {
    private Long total;
    private List<E> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<E> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}
