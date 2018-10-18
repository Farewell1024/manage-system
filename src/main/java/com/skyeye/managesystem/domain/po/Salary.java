package com.skyeye.managesystem.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工资
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salary {

    private Integer id;

    private Integer userId;

    private String userName;

    private Double salary;

    private Integer year;

    private Integer month;

    private String description;


}
