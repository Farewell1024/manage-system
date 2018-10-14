package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工资controller
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryMapper salaryMapper;



}
