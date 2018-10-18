package com.skyeye.managesystem.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 财务
 */
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
     * 类型。0 收入 ; 1 支出 ; 2 员工工资
     */
    private Integer type;

}
