package com.skyeye.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 请假
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Leave {

    private Integer id;

    private Integer userId;

    private String userName;

    private Date createTime;

    private Date startTime;

    private Date endTime;

    private String description;

    /**
     * 状态：0：审核中；1：通过：2：未通过
     */
    private Integer status;
}
