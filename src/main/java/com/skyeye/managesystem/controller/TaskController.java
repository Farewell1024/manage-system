package com.skyeye.managesystem.controller;
import com.google.common.collect.Lists;
import java.util.Date;

import com.skyeye.managesystem.domain.dto.TaskDTO;
import com.skyeye.managesystem.domain.po.Task;
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
@CrossOrigin
public class TaskController {

    @Autowired
    TaskMapper taskMapper;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有任务", httpMethod = "GET")
    Result allTask(){
        List<Task> tasks = taskMapper.findAll();
        tasks.forEach(x -> x.setPeople(taskMapper.findPeopleByTaskId(x.getId())));
        tasks.forEach(x -> x.setTaskSchedules(taskMapper.findScheduleByTaskId(x.getId())));
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
    Result updateTask(@RequestBody TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setBegin(taskDTO.getBegin());
        task.setEnd(taskDTO.getEnd());
        task.setTaskSchedules(taskDTO.getTaskSchedules());

        Task find = taskMapper.findTaskById(task.getId());
        if (find==null){
            return ResultGenerator.genFailResult("任务不存在！");
        }
        taskMapper.updateTask(task);
        if (taskDTO.getUserId().size()>0){
            taskMapper.deleteTaskPeopleByTaskId(task.getId());
            taskDTO.getUserId().forEach(x -> {taskMapper.addTaskPeopleByTaskId(task.getId(),x);});
        }
        if (task.getTaskSchedules().size()>0){
            taskMapper.deleteTaskScheduleByTaskId(task.getId());
            task.getTaskSchedules().forEach(x -> taskMapper.addTaskSchedule(x));
        }
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建任务", httpMethod = "POST")
    Result newTask(@RequestBody TaskDTO taskDTO){
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setBegin(taskDTO.getBegin());
        task.setEnd(taskDTO.getEnd());
        task.setTaskSchedules(Lists.newArrayList());
        taskMapper.newTask(task);

        if (taskDTO.getUserId().size()>0){
            taskDTO.getUserId().forEach(x -> {taskMapper.addTaskPeopleByTaskId(task.getId(),x);});
        }
        if (taskDTO.getTaskSchedules().size()>0 && taskDTO.getTaskSchedules() != null){
            taskDTO.getTaskSchedules().forEach(x -> {
                x.setTaskId(task.getId());
                taskMapper.addTaskSchedule(x);
            });
        }

        return ResultGenerator.genSuccessResult(true);
    }

    @GetMapping("/get_by_userId")
    @ApiOperation(value = "根据用户id查找用户任务",httpMethod = "GET")
    public Result getByUserId(@RequestParam Integer userId){
        List<Integer> taskIds = taskMapper.getTaskIdByUserId(userId);
        if (taskIds.size()==0){
            return ResultGenerator.genFailResult("此员工暂无任务！");
        }
        List<Task> tasks = Lists.newArrayList();
        taskIds.forEach(taskId -> {
            Task task = taskMapper.findTaskById(taskId);
            task.setPeople(taskMapper.findPeopleByTaskId(task.getId()));
            task.setTaskSchedules(taskMapper.findScheduleByTaskId(task.getId()));
            tasks.add(task);
        });
        return ResultGenerator.genSuccessResult(tasks);

    }


}
