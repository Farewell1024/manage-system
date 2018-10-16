package com.skyeye.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Function: 任务类
 *
 * Date: 2018/10/11 下午6:00
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    private Integer id ;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date begin;

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date end;

    private List<User> people;

    private List<TaskSchedule> taskSchedules;

}
