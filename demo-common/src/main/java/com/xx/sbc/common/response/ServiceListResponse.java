package com.xx.sbc.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceListResponse<T> extends ServiceResponse {

    private static final long serialVersionUID = -1L;

    private transient List<T> listData;

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }

    public static <T> ServiceListResponse<T> instance(List<T> listData) {
        ServiceListResponse<T> response = new ServiceListResponse<>();
        response.setListData(listData);
        response.success();
        return response;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
