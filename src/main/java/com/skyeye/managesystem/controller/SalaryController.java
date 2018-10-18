package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.po.Salary;
import com.skyeye.managesystem.domain.po.User;
import com.skyeye.managesystem.mapper.SalaryMapper;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工资controller
 */
@RestController
@RequestMapping("/salary")
@Api(description = "工资管理")
@CrossOrigin
public class SalaryController {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private StaffManageMapper staffManageMapper;

    @GetMapping("/get_all")
    @ApiOperation(value = "获取所有工资信息",httpMethod = "GET")
    Result getAll(){
        List<Salary> salaries = salaryMapper.getAll();
        return ResultGenerator.genSuccessResult(salaries);
    }

    @GetMapping("/get/{userId}")
    @ApiOperation(value = "获取某个用户的工资信息",httpMethod = "GET")
    Result getOneByUserId(@ApiParam(value = "用户id", required = true)@PathVariable Integer userId){
        User find = staffManageMapper.selectOneById(userId);
        if (find==null){
            return ResultGenerator.genFailResult("此用户不存在");
        }
        List<Salary> salaries = salaryMapper.getByUserId(userId);
        return ResultGenerator.genSuccessResult(salaries);
    }

    @GetMapping("/get_all_by_date")
    @ApiOperation(value = "获取某个时间所有用户的工资信息",httpMethod = "GET")
    Result genAllByDate(@ApiParam(value = "年份", required = true)@RequestParam Integer year,
                        @ApiParam(value = "月份", required = true)@RequestParam Integer month){
        List<Salary> salaries = salaryMapper.getByYearAndMonth(year, month);
        return ResultGenerator.genSuccessResult(salaries);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建一个工资信息",httpMethod = "POST")
    Result createSalary(@RequestBody Salary salary){
        salaryMapper.createSalary(salary);
        return ResultGenerator.genSuccessResult(true);
    }

    @GetMapping("/delete/salary/{salaryId}")
    @ApiOperation(value = "删除一个工资信息",httpMethod = "GET")
    Result deleteSalary(@ApiParam(value = "工资信息id", required = true) @PathVariable Integer salaryId){
        Salary find = salaryMapper.getById(salaryId);
        if (find==null){
            return ResultGenerator.genFailResult("此条信息不存在！");
        }
        salaryMapper.deleteById(salaryId);
        return ResultGenerator.genSuccessResult(true);
    }

    @GetMapping("/delete/{userId}")
    @ApiOperation(value = "删除某个用户的所有工资信息",httpMethod = "GET")
    Result deleteSalaryByUserId(@ApiParam(value = "用户id", required = true)@PathVariable Integer userId){
        salaryMapper.deleteByUserId(userId);
        return ResultGenerator.genSuccessResult(true);
    }

}
