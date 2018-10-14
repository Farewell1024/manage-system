package com.skyeye.managesystem.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 工作进度
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskSchedule {

    private Integer taskId;

    private Date createTime;

    private String description;

}
