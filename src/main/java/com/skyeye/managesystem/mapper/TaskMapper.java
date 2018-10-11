package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function: 任务 mapper
 *
 * Date: 2018/10/11 下午6:07
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface TaskMapper {

    @Select("")
    List<Task> findAll();
}
