package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.User;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import com.skyeye.managesystem.mapper.TaskMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function: staff controller
 *
 * Date: 2018/10/11 下午3:17
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/staff_manage")
@Api(value = "员工管理", description = "员工管理")
public class StaffManageController {

    @Autowired
    private StaffManageMapper staffManageMapper;

    @Autowired
    private TaskMapper taskMapper;

    @ApiOperation(value = "查询所有的职员",httpMethod = "GET")
    @GetMapping("/all")
    Result findAll(){
        List<User> users = staffManageMapper.findAll();
        return ResultGenerator.genSuccessResult(users);
    }

    @PostMapping("/new")
    Result createStaff(@RequestBody User user){
        User find = staffManageMapper.findUserByUsername(user.getUsername());
        if (find != null ){
            return ResultGenerator.genFailResult("用户已存在！");
        }
        user.setPassword("123456");
        staffManageMapper.createStaff(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete/{id}")
    Result deleteStaff(@PathVariable Integer id){
        User user = staffManageMapper.selectOneById(id);
        if (user==null ){
            return ResultGenerator.genFailResult("该用户不存在！");
        }
        staffManageMapper.deleteUser(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    Result updateStaff(@RequestBody User user){
        User find = staffManageMapper.selectOneById(user.getId());
        if (find==null ){
            return ResultGenerator.genFailResult("该用户不存在！");
        }
        staffManageMapper.updateUser(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/distribute_task")
    Result distributeTask(@RequestParam Integer userId, @RequestParam Integer taskId){
        taskMapper.addTaskPeopleByTaskId(taskId,userId);
        return ResultGenerator.genSuccessResult();
    }
}
