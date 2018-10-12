package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.Finance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function: finance mapper
 *
 * Date: 2018/10/12 上午10:59
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface FinanceMapper {

    @Select("SELECT * FROM finance WHERE type = #{type};")
    List<Finance> findFinanceByType(Integer type);

    @Insert("INSERT INTO finance ( money, year, month, day, description, type) " +
            "VALUES (#{money},#{year},#{month},#{day},#{description},#{type});")
    void addFinance(Finance finance);

    @Delete("DELETE FROM finance WHERE id=#{};")
    void deleteFinanceById(Integer id);

    @Update("UPDATE finance SET money=#{money} AND year=#{year} AND month=#{month} AND day=#{day} " +
            "AND  description=#{description} AND type=#{type} WHERE id=#{id};")
    void updateFinance(Finance finance);

    @Select("SELECT * FROM finance WHERE id = #{id};")
    Finance findFinanceById(Integer id);
}
