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

    @Select("SELECT id,title,description,begin,end from task")
    List<Task> findAll();

    @Select("SELECT b.* from task_user AS a LEFT JOIN t_user AS b on a.user_id=b.id WHERE a.task_id=#{id};")
    List<User> findPeopleByTaskId(Integer id);

    @Delete("DELETE from task WHERE id=#{id};")
    void deleteTaskById(Integer id);

    @Delete("DELETE FROM task_user WHERE task_id=#{id};")
    void deleteTaskPeopleByTaskId(Integer id);

    @Update("UPDATE task SET title=#{title} AND description=#{description} AND begin=#{begin} AND end=#{end} WHERE id=#{id};")
    void updateTask(Task task);

    @Insert("INSERT task_user (user_id, task_id) VALUES (#{userId},#{taskId})")
    void addTaskPeopleByTaskId(@Param("taskId") Integer taskId,@Param("userId") Integer userId);

    @Insert("INSERT task ( title, description, begin, end) VALUES (#{title},#{description},#{begin},#{end});")
    @Options(useGeneratedKeys = true)
    void newTask(Task task);

    /**
     * 通过任务id来查找任务
     * @param id
     * @return
     */
    @Select("SELECT id,title,description,begin,end from task WHERE id = #{id};")
    Task findTaskById(Integer id);
}
