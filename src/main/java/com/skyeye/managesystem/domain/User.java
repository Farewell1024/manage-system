package com.skyeye.managesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Function: 职员类
 *
 * Date: 2018/10/11 下午3:19
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String fullName;

    private Integer age;

    private String cardId;

    private String address;

    private Date entryDate;

    private String title;

    private Integer gender;


}
