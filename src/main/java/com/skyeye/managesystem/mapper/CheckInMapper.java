package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.CheckIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("")
    List<CheckIn> searchByDateAndUserId(Integer year, Integer month, Integer userId);

    @Select("")
    Integer searchSumCheckIn(Integer year, Integer month, Integer userId);

    Integer searchSumLate(Integer year, Integer month, Integer userId);
}
