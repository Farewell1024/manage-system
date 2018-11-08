package com.skyeye.managesystem.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public class Deal {

    private Integer id;

    private Integer userId;

    private String userName;

    /**
     * 交易类型
     * 1 视觉形象类
     * 2 理念形象类
     * 3 行为形象类
     */
    private Integer type;

    private List<DealDescription> description;

    public Deal() {
    }

    public Deal(Integer id, Integer userId, String userName, Integer type, List<DealDescription> description) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", description=" + description +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<DealDescription> getDescription() {
        return description;
    }

    public void setDescription(List<DealDescription> description) {
        this.description = description;
    }
}
