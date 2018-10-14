package com.skyeye.managesystem.controller;

import com.google.common.collect.Lists;
import com.skyeye.managesystem.domain.Finance;
import com.skyeye.managesystem.mapper.FinanceMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 财务
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceMapper financeMapper;

    @GetMapping("/finance_info")
    Result getFinanceInfo(@RequestParam List<Integer> typeLists){
        List<Finance> finances = Lists.newArrayList();
        typeLists.forEach(x -> finances.addAll(financeMapper.findFinanceByType(x)));
        return ResultGenerator.genSuccessResult(finances);
    }

    @PostMapping("/new_finance")
    Result newFinance(@RequestBody Finance finance ){
        financeMapper.addFinance(finance);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete/{id}")
    Result deleteFinance(@PathVariable Integer id){
        Finance find = financeMapper.findFinanceById(id);
        if (find==null){
            return ResultGenerator.genFailResult("记录不存在！");
        }
        financeMapper.deleteFinanceById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    Result updateFinance(@RequestBody Finance finance){
        Finance find = financeMapper.findFinanceById(finance.getId());
        if (find==null){
            return ResultGenerator.genFailResult("记录不存在！");
        }
        financeMapper.updateFinance(finance);
        return ResultGenerator.genSuccessResult();
    }

}
