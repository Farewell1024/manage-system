package com.skyeye.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Finance {

    private Integer id;

    private Double money;

    private Integer year;

    private Integer month;

    private Integer day;

    private String description;

    /**
     * 类型。0 收入 ; 1 支出
     */
    private Integer type;

}
