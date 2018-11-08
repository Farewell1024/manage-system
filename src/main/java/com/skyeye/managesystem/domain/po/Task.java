package com.skyeye.managesystem.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Task {

    private Integer id ;

    private String title;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date begin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date end;

    private List<User> people;

    private List<TaskSchedule> taskSchedules;

    public Task() {
    }

    public Task(Integer id, String title, String description, Date begin, Date end, List<User> people, List<TaskSchedule> taskSchedules) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.people = people;
        this.taskSchedules = taskSchedules;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", people=" + people +
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

    public List<User> getPeople() {
        return people;
    }

    public void setPeople(List<User> people) {
        this.people = people;
    }

    public List<TaskSchedule> getTaskSchedules() {
        return taskSchedules;
    }

    public void setTaskSchedules(List<TaskSchedule> taskSchedules) {
        this.taskSchedules = taskSchedules;
    }
}
