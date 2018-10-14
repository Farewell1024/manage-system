package com.skyeye.managesystem.controller;

import com.google.common.collect.Lists;
import com.skyeye.managesystem.domain.Leave;
import com.skyeye.managesystem.mapper.LeaveMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请假
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveMapper leaveMapper;

    @ApiOperation(value = "根据状态获取请假信息")
    @GetMapping("/get_all")
    Result untreated(List<Integer> status){
        List<Leave> leaves = Lists.newArrayList();
        status.forEach(x -> leaves.addAll(leaveMapper.getLeaveByStatus(x)));
        return ResultGenerator.genSuccessResult(leaves);
    }

    @ApiOperation(value = "修改请假状态")
    @PostMapping("/update")
    Result updateLeave(Integer id,Integer status){
        Leave find = leaveMapper.getLeaveById(id);
        if (find == null){
            return ResultGenerator.genFailResult("请假信息不存在！");
        }
        leaveMapper.updateStatusById(id,status);
        return ResultGenerator.genSuccessResult(true);
    }

    @ApiOperation(value = "获得单个用户请假信息")
    @GetMapping("/get_single")
    Result getSingle(Integer userId){
        List<Leave> leaves = leaveMapper.getLeaveByUserId(userId);
        return ResultGenerator.genSuccessResult(leaves);
    }

    @ApiOperation(value = "新增请假信息")
    @PostMapping("/new_leave")
    Result newLeave(@RequestBody Leave leave){
        leaveMapper.addLeave(leave);
        return ResultGenerator.genSuccessResult();
    }
}
