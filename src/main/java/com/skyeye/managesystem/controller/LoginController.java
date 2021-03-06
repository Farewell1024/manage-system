package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.dto.LoginDTO;
import com.skyeye.managesystem.domain.dto.ModifyRoleDTO;
import com.skyeye.managesystem.domain.po.User;
import com.skyeye.managesystem.enums.RoleTypeEnum;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/10/22 下午2:31
 * @since JDK 1.8
 */
@RestController("/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private StaffManageMapper staffManageMapper;

    @PostMapping("/login")
    Result login(@RequestBody LoginDTO loginDTO){
        User user = staffManageMapper.findUserByUsername(loginDTO.getUsername());
        if (user==null){
            return ResultGenerator.genFailResult("此用户不存在！");
        }
        if (!user.getPassword().equals(loginDTO.getPassword())){
            return ResultGenerator.genFailResult("密码不正确");
        }
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/logout")
    Result logout(){
        return ResultGenerator.genSuccessResult(true);
    }


    @PostMapping("/modify_role")
    Result modifyRole(@RequestBody ModifyRoleDTO dto){
        Integer userId = dto.getUserId();
        User find = staffManageMapper.selectOneById(userId);
        if (find==null){
            return ResultGenerator.genFailResult("无此用户");
        }

        Integer roleType = dto.getRoleType();
        String roleName = RoleTypeEnum.getRoleNameById(roleType);
        staffManageMapper.updateRoleByUserId(userId,roleName);
        return ResultGenerator.genSuccessResult(true);
    }


}
