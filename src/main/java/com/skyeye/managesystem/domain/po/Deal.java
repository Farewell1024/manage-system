package com.skyeye.managesystem.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Deal {

    private Integer id;

    private Integer userId;

    private String userName;

    /**
     * 交易类型
     * 1 视觉形象类
     * 2 理念形象类
     * 3 行为形象类
     */
    private Integer type;

    private List<DealDescription> description;

}
