package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.po.User;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import com.skyeye.managesystem.mapper.TaskMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@CrossOrigin
public class StaffManageController {

    @Autowired
    private StaffManageMapper staffManageMapper;

    @Autowired
    private TaskMapper taskMapper;

//    @RequiresPermissions("staff:all")
    @ApiOperation(value = "查询所有的职员",httpMethod = "GET")
    @GetMapping("/all")
    Result findAll(){
        List<User> users = staffManageMapper.findAll();
        return ResultGenerator.genSuccessResult(users);
    }

    @PostMapping("/new")
    @ApiOperation(value = "创建一个用户", httpMethod = "POST")
    Result createStaff( @RequestBody User user){
        User find = staffManageMapper.findUserByUsername(user.getUsername());
        if (find != null ){
            return ResultGenerator.genFailResult("用户已存在！");
        }
        user.setPassword("123456");
        staffManageMapper.createStaff(user);
        return ResultGenerator.genSuccessResult(true);
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除用户", httpMethod = "GET")
    Result deleteStaff(@PathVariable Integer id){
        User user = staffManageMapper.selectOneById(id);
        if (user==null ){
            return ResultGenerator.genFailResult("该用户不存在！");
        }
        staffManageMapper.deleteUser(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改用户信息", httpMethod = "POST")
    Result updateStaff(@RequestBody User user){
        User find = staffManageMapper.selectOneById(user.getId());
        if (find==null ){
            return ResultGenerator.genFailResult("该用户不存在！");
        }
        staffManageMapper.updateUser(user);
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/distribute_task")
    @ApiOperation(value = "为某人分配任务", httpMethod = "POST")
    Result distributeTask(@RequestParam Integer userId, @RequestParam Integer taskId){
        taskMapper.addTaskPeopleByTaskId(taskId,userId);
        return ResultGenerator.genSuccessResult(true);
    }
}
