package com.skyeye.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    private Date begin;

    private Date end;

    private List<User> people;

}
