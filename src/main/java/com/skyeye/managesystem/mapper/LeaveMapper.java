package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.Leave;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LeaveMapper {

    @Select("select id, user_id, user_name, create_time, start_time, end_time, description, status from leave where status=#{status}")
    List<Leave> getLeaveByStatus(Integer status);

    @Update("update leave set status=#{status} where id=#{id}")
    void updateStatusById(@Param("id") Integer id,@Param("status") Integer status);

    @Select("select id, user_id, user_name, create_time, start_time, end_time, description, status from leave where user_id=#{userId}")
    List<Leave> getLeaveByUserId(Integer userId);

    @Select("select id, user_id, user_name, create_time, start_time, end_time, description, status from leave where id=#{id}")
    Leave getLeaveById(Integer id);

    @Insert("insert into leave (user_id, user_name, create_time, start_time, end_time, description, status ) " +
            "values (#{userId},#{userName},#{createTime},#{startTime},#{endTime},#{description},#{status} )")
    void addLeave(Leave leave);
}
