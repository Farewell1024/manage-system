package com.skyeye.managesystem.domain.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/11/9 10:48 AM
 * @since JDK 1.8
 */
public class StatusDTO {

    @ApiModelProperty("请假状态。0：审核中；1：通过：2：未通过。按需传入")
    private List<Integer> status;

    public StatusDTO(List<Integer> status) {
        this.status = status;
    }

    public StatusDTO() {
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "status=" + status +
                '}';
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }
}
