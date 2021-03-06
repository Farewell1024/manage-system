package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.po.Finance;
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

    @Select("SELECT * FROM t_finance WHERE type = #{type};")
    List<Finance> findFinanceByType(Integer type);

    @Insert("INSERT INTO t_finance ( money, year, month, day, description, type) " +
            "VALUES (#{money},#{year},#{month},#{day},#{description},#{type});")
    void addFinance(Finance finance);

    @Delete("DELETE FROM t_finance WHERE id=#{id};")
    void deleteFinanceById(Integer id);

    @Update("UPDATE t_finance SET money=#{money} , year=#{year} , month=#{month} , day=#{day}, " +
            "description=#{description},type=#{type} WHERE id=#{id};")
    void updateFinance(Finance finance);

    @Select("SELECT * FROM t_finance WHERE id = #{id};")
    Finance findFinanceById(Integer id);
}
