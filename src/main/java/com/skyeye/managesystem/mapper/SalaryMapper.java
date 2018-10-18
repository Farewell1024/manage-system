package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.po.Salary;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalaryMapper {

    @Select("select id,user_id, user_name ,salary ,year,month,description from t_salary ;")
    List<Salary> getAll();

    @Select("select id,user_id, user_name ,salary ,year,month,description from t_salary where user_id=#{userId};")
    List<Salary> getByUserId(Integer userId);

    @Select("select id,user_id, user_name ,salary ,year,month,description from t_salary where year=#{year} and month=#{month}")
    List<Salary> getByYearAndMonth(@Param("year") Integer year,@Param("month") Integer month);

    @Insert("INSERT INTO t_salary (user_id, user_name, salary, year, month, description) VALUES " +
            "(#{userId},#{userName},#{salary},#{year},#{month},#{description});")
    void createSalary(Salary salary);

    @Delete("delete from t_salary where id=#{salaryId}")
    void deleteById(Integer salaryId);

    @Select("select id,user_id, user_name ,salary ,year,month,description from t_salary where id = #{salaryId};")
    Salary getById(Integer salaryId);

    @Delete("delete from t_salary where user_id=#{userId}")
    void deleteByUserId(Integer userId);
}
