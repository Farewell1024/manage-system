package com.skyeye.managesystem.domain.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/11/9 10:11 AM
 * @since JDK 1.8
 */
public class ModifyRoleDTO {

    @ApiModelProperty("用户id")
    private Integer userId;

    @Min(value = 1,message = "角色类型在[1-3]之间！")
    @Max(value = 3,message = "角色类型在[1-3]之间！")
    @ApiModelProperty("角色类型；1-管理员；2-财务；3-员工")
    private Integer roleType;

    public ModifyRoleDTO(Integer userId, Integer roleType) {
        this.userId = userId;
        this.roleType = roleType;
    }

    public ModifyRoleDTO() {
    }

    @Override
    public String toString() {
        return "ModifyRoleDTO{" +
                "userId=" + userId +
                ", roleType=" + roleType +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}
