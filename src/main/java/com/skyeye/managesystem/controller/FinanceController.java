package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @GetMapping("/finance_info")
    Result getFinanceInfo(@RequestParam List<Integer> typeLists){

        return ResultGenerator.genSuccessResult();
    }


}
