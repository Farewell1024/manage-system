package com.skyeye.managesystem.domain.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private String description;

}
