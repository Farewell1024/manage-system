package com.skyeye.managesystem.controller;

import com.google.common.collect.Lists;
import com.skyeye.managesystem.domain.dto.StatusDTO;
import com.skyeye.managesystem.domain.po.Leave;
import com.skyeye.managesystem.mapper.LeaveMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请假
 */
@RestController
@RequestMapping("/leave")
@Api(description = "请假管理")
@CrossOrigin
public class LeaveController {

    @Autowired
    private LeaveMapper leaveMapper;

    @ApiOperation(value = "根据状态获取请假信息")
    @PostMapping("/get_all")
    Result untreated(@RequestBody StatusDTO dto){
        List<Integer> status = dto.getStatus();
        List<Leave> leaves = Lists.newArrayList();
        status.forEach(x -> leaves.addAll(leaveMapper.getLeaveByStatus(x)));
        return ResultGenerator.genSuccessResult(leaves);
    }

    @ApiOperation(value = "修改请假状态")
    @PostMapping("/update")
    Result updateLeave(@ApiParam(value = "请假信息id",required = true)@RequestParam Integer id,
                       @ApiParam(value = "状态",required = true)@RequestParam Integer status){
        Leave find = leaveMapper.getLeaveById(id);
        if (find == null){
            return ResultGenerator.genFailResult("请假信息不存在！");
        }
        leaveMapper.updateStatusById(id,status);
        return ResultGenerator.genSuccessResult(true);
    }

    @ApiOperation(value = "获得单个用户请假信息")
    @GetMapping("/get_single")
    Result getSingle(@ApiParam(value = "用户id",required = true) @RequestParam Integer userId){
        List<Leave> leaves = leaveMapper.getLeaveByUserId(userId);
        return ResultGenerator.genSuccessResult(leaves);
    }

    @ApiOperation(value = "新增请假信息")
    @PostMapping("/new_leave")
    Result newLeave(@RequestBody Leave leave){
        leaveMapper.addLeave(leave);
        return ResultGenerator.genSuccessResult(true);
    }
}
