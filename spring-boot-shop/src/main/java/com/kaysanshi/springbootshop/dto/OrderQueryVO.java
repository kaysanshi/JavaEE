package com.kaysanshi.springbootshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaysanshi.springbootshop.domain.Orderitem;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/12/21
 */
public class OrderQueryVO {
    private Integer page;
    private Integer limit;
    private Integer start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date endDate;
    private Integer sort;
    private String key;
    //该订单中有多少订单项
    List<Orderitem> orderItems = new ArrayList<Orderitem>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List <Orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List <Orderitem> orderItems) {
        this.orderItems = orderItems;
    }
}
