package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.Task;
import com.skyeye.managesystem.mapper.TaskMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Function: 任务controller
 *
 * Date: 2018/10/11 下午6:03
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskMapper taskMapper;

    @GetMapping("/all")
    Result allTask(){
        List<Task> tasks = taskMapper.findAll();

        return ResultGenerator.genSuccessResult();
    }

    Result deleteTask(){
        return ResultGenerator.genSuccessResult();
    }

    Result updateTask(){
        return ResultGenerator.genSuccessResult();
    }

    Result newTask(){
        return ResultGenerator.genSuccessResult();
    }

}
