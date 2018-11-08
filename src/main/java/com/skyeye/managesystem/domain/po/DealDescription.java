package com.skyeye.managesystem.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


public class DealDescription {

    private Integer dealId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private String description;

    /**
     * 排序
     */
    private Integer orderNo;

    public DealDescription(Integer dealId, Date createTime, String description, Integer orderNo) {
        this.dealId = dealId;
        this.createTime = createTime;
        this.description = description;
        this.orderNo = orderNo;
    }

    public DealDescription() {
    }

    @Override
    public String toString() {
        return "DealDescription{" +
                "dealId=" + dealId +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
