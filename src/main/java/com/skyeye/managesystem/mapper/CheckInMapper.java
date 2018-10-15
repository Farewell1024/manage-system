package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.CheckIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * Date: 2018/10/12 下午12:09
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface CheckInMapper {

    @Insert("INSERT INTO check_in (user_id, year, month, day, hour, minute, is_late) " +
            "VALUES (#{userId},#{year},#{month},#{day},#{hour},#{minute},#{isLate});")
    void checkIn(CheckIn checkIn);

    @Select("SELECT user_id, year, month, day, hour, minute, is_late FROM check_in WHERE year='' AND month='' AND user_id='';")
    List<CheckIn> searchByDateAndUserId(@Param("year") Integer year,@Param("month")  Integer month,@Param("userId")  Integer userId);

    @Select("")
    Integer searchSumCheckIn(Integer year, Integer month, Integer userId);

    @Select("")
    Integer searchSumLate(Integer year, Integer month, Integer userId);
}
