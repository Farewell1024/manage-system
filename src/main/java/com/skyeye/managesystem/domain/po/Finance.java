package com.skyeye.managesystem.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 财务
 */

public class Finance {

    private Integer id;

    private Double money;

    private Integer year;

    private Integer month;

    private Integer day;

    private String description;

    /**
     * 类型。0 收入 ; 1 支出 ; 2 员工工资
     */
    private Integer type;

    public Finance(Integer id, Double money, Integer year, Integer month, Integer day, String description, Integer type) {
        this.id = id;
        this.money = money;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.type = type;
    }

    public Finance() {
    }

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", money=" + money +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
