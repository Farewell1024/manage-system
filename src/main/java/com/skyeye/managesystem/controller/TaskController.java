package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.Task;
import com.skyeye.managesystem.mapper.TaskMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
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
public class TaskController {

    @Autowired
    TaskMapper taskMapper;

    @GetMapping("/all")
    Result allTask(){
        List<Task> tasks = taskMapper.findAll();
        tasks.forEach(x -> x.setPeople(taskMapper.findPeopleByTaskId(x.getId())));
        return ResultGenerator.genSuccessResult(tasks);
    }

    @PostMapping("/delete/{id}")
    Result deleteTask(@PathVariable Integer id){
        Task task = taskMapper.findTaskById(id);
        if (task==null){
            return ResultGenerator.genFailResult("任务不存在！");
        }

        taskMapper.deleteTaskById(id);
        taskMapper.deleteTaskPeopleByTaskId(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    Result updateTask(@RequestBody Task task){
        Task find = taskMapper.findTaskById(task.getId());
        if (find==null){
            return ResultGenerator.genFailResult("任务不存在！");
        }

        taskMapper.updateTask(task);
        taskMapper.deleteTaskPeopleByTaskId(task.getId());
        task.getPeople().forEach(x -> taskMapper.addTaskPeopleByTaskId(task.getId(), x.getId()));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/create")
    Result newTask(@RequestBody Task task){
        taskMapper.newTask(task);
        task.getPeople().forEach(x -> taskMapper.addTaskPeopleByTaskId(task.getId(), x.getId()));
        return ResultGenerator.genSuccessResult();
    }

}
