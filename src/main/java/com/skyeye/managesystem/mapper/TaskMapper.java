package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.po.Task;
import com.skyeye.managesystem.domain.po.TaskSchedule;
import com.skyeye.managesystem.domain.po.User;
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

    @Update("UPDATE task SET title=#{title} , description=#{description} , begin=#{begin} , end=#{end} WHERE id=#{id};")
    void updateTask(Task task);

    @Insert("INSERT task_user (user_id, task_id) VALUES (#{userId},#{taskId})")
    void addTaskPeopleByTaskId(@Param("taskId") Integer taskId,@Param("userId") Integer userId);

    @Insert("INSERT task ( title, description, begin, end) VALUES (#{title},#{description},#{begin},#{end});")
    @Options(useGeneratedKeys = true)
    void newTask(Task task);

    /**
     * 通过任务id来查找任务
     */
    @Select("SELECT id,title,description,begin,end from task WHERE id = #{id};")
    Task findTaskById(Integer id);

    @Select("select task_id, create_time,description from task_schedule where task_id=#{id} order by create_time")
    List<TaskSchedule> findScheduleByTaskId(Integer id);

    @Delete("delete from task_schedule where task_id=#{id} ")
    void deleteTaskScheduleByTaskId(Integer id);

    @Insert("insert task_schedule (task_id,create_time,description ) values (#{taskId},#{createTime},#{description})")
    void addTaskSchedule(TaskSchedule x);

    @Select("SELECT task_id FROM task_user WHERE user_id=#{userId};")
    List<Integer> getTaskIdByUserId(Integer userId);
}
