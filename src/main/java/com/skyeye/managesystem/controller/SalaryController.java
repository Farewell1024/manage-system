package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.Salary;
import com.skyeye.managesystem.domain.User;
import com.skyeye.managesystem.mapper.SalaryMapper;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工资controller
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private StaffManageMapper staffManageMapper;

    @GetMapping("/get_all")
    Result getAll(){
        List<Salary> salaries = salaryMapper.getAll();
        return ResultGenerator.genSuccessResult(salaries);
    }

    @GetMapping("/get/{userId}")
    Result getOneByUserId(Integer userId){
        User find = staffManageMapper.selectOneById(userId);
        if (find==null){
            return ResultGenerator.genFailResult("此用户不存在");
        }
        List<Salary> salaries = salaryMapper.getByUserId(userId);
        return ResultGenerator.genSuccessResult(salaries);
    }

    @GetMapping("/get_all_by_date")
    Result genAllByDate(Integer year, Integer month){
        List<Salary> salaries = salaryMapper.getByYearAndMonth(year, month);
        return ResultGenerator.genSuccessResult(salaries);
    }

    @PostMapping("/create")
    Result createSalary(@RequestBody Salary salary){
        salaryMapper.createSalary(salary);
        return ResultGenerator.genSuccessResult(true);
    }

    @GetMapping("/delete/{salaryId}")
    Result deleteSalary(@PathVariable Integer salaryId){
        Salary find = salaryMapper.getById(salaryId);
        if (find==null){
            return ResultGenerator.genFailResult("此条信息不存在！");
        }
        salaryMapper.deleteById(salaryId);
        return ResultGenerator.genSuccessResult(true);
    }



}
