package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.Task;
import com.skyeye.managesystem.mapper.TaskMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function: 任务controller
 *
 * Date: 2018/10/11 下午6:03
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/task")
@Api(description = "任务管理")
public class TaskController {

    @Autowired
    TaskMapper taskMapper;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有任务", httpMethod = "GET")
    Result allTask(){
        List<Task> tasks = taskMapper.findAll();
        tasks.forEach(x -> x.setPeople(taskMapper.findPeopleByTaskId(x.getId())));
        tasks.forEach(x -> taskMapper.findScheduleByTaskId(x.getId()));
        return ResultGenerator.genSuccessResult(tasks);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除任务", httpMethod = "POST")
    Result deleteTask(@PathVariable Integer id){
        Task task = taskMapper.findTaskById(id);
        if (task==null){
            return ResultGenerator.genFailResult("任务不存在！");
        }
        taskMapper.deleteTaskById(id);
        taskMapper.deleteTaskPeopleByTaskId(id);
        taskMapper.deleteTaskScheduleByTaskId(id);
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新任务", httpMethod = "POST")
    Result updateTask(@RequestBody Task task){
        Task find = taskMapper.findTaskById(task.getId());
        if (find==null){
            return ResultGenerator.genFailResult("任务不存在！");
        }
        taskMapper.updateTask(task);
        taskMapper.deleteTaskPeopleByTaskId(task.getId());
        task.getPeople().forEach(x -> taskMapper.addTaskPeopleByTaskId(task.getId(), x.getId()));
        taskMapper.deleteTaskScheduleByTaskId(task.getId());
        task.getTaskSchedules().forEach(x -> taskMapper.addTaskSchedule(x));
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建任务", httpMethod = "POST")
    Result newTask(@RequestBody Task task){
        taskMapper.newTask(task);
        task.getPeople().forEach(x -> taskMapper.addTaskPeopleByTaskId(task.getId(), x.getId()));
        task.getTaskSchedules().forEach(x -> taskMapper.addTaskSchedule(x));
        return ResultGenerator.genSuccessResult(true);
    }


}
