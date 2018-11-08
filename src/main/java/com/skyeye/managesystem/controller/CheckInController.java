package com.skyeye.managesystem.controller;

import com.google.common.collect.Lists;
import com.skyeye.managesystem.domain.po.CheckIn;
import com.skyeye.managesystem.mapper.CheckInMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(description = "考勤管理")
@CrossOrigin
public class CheckInController {

    @Autowired
    private CheckInMapper checkInMapper;


    @ApiOperation(value = "签到", httpMethod = "POST")
    @PostMapping("")
    Result checkIn(@ApiParam(value = "用户id", required = true) @RequestParam Integer userId){
        Date date = new Date();
        CheckIn checkIn = new CheckIn();
        checkIn.setUserId(userId);
        checkIn.setYear(date.getYear()+1900);
        checkIn.setMonth(date.getMonth()+1);
        checkIn.setDay(date.getDate());
        checkIn.setHour(date.getHours());
        checkIn.setMinute(date.getMinutes());
        // 九点前（含）打卡不算迟到
        if ((checkIn.getHour()==9&checkIn.getMinute()==0) || checkIn.getHour()<9){
            checkIn.setLate(false);
        }else {
            checkIn.setLate(true);
        }
        checkInMapper.checkIn(checkIn);
        System.out.println(checkIn);
        return ResultGenerator.genSuccessResult(true);
    }

    @ApiOperation(value = "获取某年某月所有的打卡记录",httpMethod = "GET")
    @GetMapping("/count")
    Result count(@ApiParam(value = "年份", required = true)@RequestParam Integer year,
                 @ApiParam(value = "月份", required = true)@RequestParam Integer month,
                 @ApiParam(value = "用户id", required = true) @RequestParam Integer userId){
        List<CheckIn> checkIns = checkInMapper.searchByDateAndUserId(year, month, userId);
        return ResultGenerator.genSuccessResult(checkIns);
    }

    @ApiOperation(value = "统计某年某月打卡天数和迟到天数",httpMethod = "GET",notes = "数组第一位总打卡天数，第二位为迟到天数")
    @GetMapping("/sum")
    Result sum(@ApiParam(value = "年份", required = true) @RequestParam Integer year,
               @ApiParam(value = "月份", required = true) @RequestParam Integer month,
               @ApiParam(value = "用户id", required = true) @RequestParam Integer userId){
        Integer checkInDay = checkInMapper.searchSumCheckIn( year,  month,  userId);
        Integer lateDay =  checkInMapper.searchSumLate(year,  month,  userId);
        List<Integer> list = Lists.newArrayList();
        list.add(checkInDay==null?0:checkInDay);
        list.add(lateDay==null?0:lateDay);
        return ResultGenerator.genSuccessResult(list);
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
