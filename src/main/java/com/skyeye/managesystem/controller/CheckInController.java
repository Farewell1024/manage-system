package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.mapper.CheckInMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Function: 考勤
 *
 * Date: 2018/10/12 下午12:08
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/check_in")
public class CheckInController {

    @Autowired
    private CheckInMapper checkInMapper;

    @PostMapping("")
    Result checkIn(Integer userId){
        Date date = new Date();
        return ResultGenerator.genSuccessResult();
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDate());
        System.out.println(date.getHours());
        System.out.println(date.getMinutes());
    }

}
