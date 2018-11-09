package com.skyeye.managesystem.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyeye.managesystem.domain.po.TaskSchedule;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/11/9 11:14 AM
 * @since JDK 1.8
 */
public class TaskDTO {

    private Integer id ;

    private String title;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty("开始时间；yyyy-MM-dd HH:mm")

    private Date begin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty("结束时间；yyyy-MM-dd HH:mm")
    private Date end;

    private List<Integer> userId;

    private List<TaskSchedule> taskSchedules;

    public TaskDTO(Integer id, String title, String description, Date begin, Date end, List<Integer> userId, List<TaskSchedule> taskSchedules) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.userId = userId;
        this.taskSchedules = taskSchedules;
    }

    public TaskDTO() {
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", userId=" + userId +
                ", taskSchedules=" + taskSchedules +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public List<Integer> getUserId() {
        return userId;
    }

    public void setUserId(List<Integer> userId) {
        this.userId = userId;
    }

    public List<TaskSchedule> getTaskSchedules() {
        return taskSchedules;
    }

    public void setTaskSchedules(List<TaskSchedule> taskSchedules) {
        this.taskSchedules = taskSchedules;
    }
}
