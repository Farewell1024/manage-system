package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.CheckIn;
import com.skyeye.managesystem.mapper.CheckInMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
        CheckIn checkIn = new CheckIn();
        checkIn.setUserId(userId);
        checkIn.setYear(date.getYear()+1900);
        checkIn.setMonth(date.getMonth()+1);
        checkIn.setDay(date.getDay());
        checkIn.setHour(date.getHours());
        checkIn.setMinute(date.getMinutes());
        // 九点前（含）打卡不算迟到
        if ((checkIn.getHour()==9&checkIn.getMinute()==0) || checkIn.getHour()<9){
            checkIn.setIsLate(false);
        }
        checkInMapper.checkIn(checkIn);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/count")
    Result count(Integer year, Integer month, Integer userId){
        List<CheckIn> checkIns = checkInMapper.searchByDateAndUserId(year, month, userId);
        return ResultGenerator.genSuccessResult(checkIns);
    }


//    public static void main(String[] args) {
//        Integer hour =9;
//        Integer minute = 01;
//        if ((hour==9&minute==0)|| hour<9){
//            System.out.println(true);
//        }
//
//    }

}
