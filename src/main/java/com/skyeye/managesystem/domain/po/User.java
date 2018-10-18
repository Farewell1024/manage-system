package com.skyeye.managesystem.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String fullName;

    private Integer age;

    private String cardId;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date entryDate;

    private String title;

    private Integer gender;

    /**
     * 评级：1.初级 2.中级 3.高级
     */
    private Integer level;

}
