package com.xx.sbc.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicePageResponse<T> extends ServiceResponse {

    private static final long serialVersionUID = -1L;

    private long totalRecords;
    private long pageNo;
    private long pageSize;
    private transient List<T> records;

    public long getTotalRecords() {
        return totalRecords < 0L ? 0L : totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public long getPageNo() {
        return pageNo < 1L ? 1L : pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize < 1L ? 20L : pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public static <T> ServicePageResponse<T> instance(long pageNo, long pageSize, long totalRecords, List<T> listData) {
        ServicePageResponse<T> response = new ServicePageResponse<>();
        response.setTotalRecords(totalRecords);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setRecords(listData);
        response.success();
        return response;
    }

    public long getTotalPages() {
        if (this.getTotalRecords() <= this.getPageSize()) {
            return 1L;
        }
        long totalNum = getTotalRecords() / getPageSize();
        //如果_后一页不满，则页数补一页
        if (this.getTotalRecords() % this.getPageSize() != 0) {
            return totalNum + 1;
        } else {
            return totalNum;
        }
    }

    public long getTopPageNo() {
        return 1L;
    }

    public long getBottomPageNo() {
        return this.getTotalPages();
    }

    public long getPreviousPageNo() {
        return this.getPageNo() <= 1L ? 1L : this.getPageNo() - 1L;
    }

    public long getNextPageNo() {
        if (this.getPageNo() >= this.getTotalPages()) {
            return this.getTotalPages();
        }
        return this.getPageNo() + 1;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
