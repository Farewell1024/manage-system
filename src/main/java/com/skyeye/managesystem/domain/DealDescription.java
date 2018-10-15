package com.skyeye.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DealDescription {

    private Integer dealId;

    private Date createTime;

    private String description;

    /**
     * 排序
     */
    private Integer orderNo;

}
