package com.skyeye.managesystem.controller;

import com.google.common.collect.Lists;
import com.skyeye.managesystem.domain.po.Finance;
import com.skyeye.managesystem.mapper.FinanceMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 财务
 */
@RestController
@RequestMapping("/finance")
@Api(description = "财务管理")
@CrossOrigin
public class FinanceController {

    @Autowired
    private FinanceMapper financeMapper;

    @GetMapping("/finance_info")
    @ApiOperation(value = "获取财务信息" ,httpMethod = "GET")
    Result getFinanceInfo(@ApiParam(value = "类型列表。0 收入 ; 1 支出 ; 2 员工工资。按需传入", required = true) @RequestParam List<Integer> typeLists){
        List<Finance> finances = Lists.newArrayList();
        typeLists.forEach(x -> finances.addAll(financeMapper.findFinanceByType(x)));
        return ResultGenerator.genSuccessResult(finances);
    }

    @PostMapping("/new_finance")
    @ApiOperation(value = "新建财务信息" ,httpMethod = "POST")
    Result newFinance(@RequestBody Finance finance ){
        financeMapper.addFinance(finance);
        return ResultGenerator.genSuccessResult(true);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除财务信息" ,httpMethod = "DELETE")
    Result deleteFinance(@ApiParam(value = "财务信息id", required = true) @PathVariable Integer id){
        Finance find = financeMapper.findFinanceById(id);
        if (find==null){
            return ResultGenerator.genFailResult("记录不存在！");
        }
        financeMapper.deleteFinanceById(id);
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改财务信息" ,httpMethod = "POST")
    Result updateFinance(@RequestBody Finance finance){
        Finance find = financeMapper.findFinanceById(finance.getId());
        if (find==null){
            return ResultGenerator.genFailResult("记录不存在！");
        }
        financeMapper.updateFinance(finance);
        return ResultGenerator.genSuccessResult(true);
    }

}
