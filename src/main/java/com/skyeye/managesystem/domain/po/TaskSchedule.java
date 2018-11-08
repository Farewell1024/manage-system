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
public class TaskSchedule {

    private Integer taskId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private String description;

    public TaskSchedule(Integer taskId, Date createTime, String description) {
        this.taskId = taskId;
        this.createTime = createTime;
        this.description = description;
    }

    public TaskSchedule() {
    }

    @Override
    public String toString() {
        return "TaskSchedule{" +
                "taskId=" + taskId +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
