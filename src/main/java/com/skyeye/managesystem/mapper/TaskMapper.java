package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.Task;
import com.skyeye.managesystem.domain.User;
import org.apache.ibatis.annotations.*;
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

    @Select("")
    List<User> findPeopleByTaskId(Integer id);

    @Delete("")
    void deleteTaskById(Integer id);

    @Delete("")
    void deleteTaskPeopleByTaskId(Integer id);

    @Update("")
    void updateTask(Task task);

    @Insert("")
    void addTaskPeopleByTaskId(Integer id, Integer id1);

    @Insert("")
    @Options(useGeneratedKeys = true)
    void newTask(Task task);

    /**
     * 通过任务id来查找任务
     * @param id
     * @return
     */
    @Select("")
    Task findTaskById(Integer id);
}
