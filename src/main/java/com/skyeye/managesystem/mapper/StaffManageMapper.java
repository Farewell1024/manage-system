package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * Date: 2018/10/11 下午3:17
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface StaffManageMapper {

    @Select("SELECT * FROM t_user;")
    List<User> findAll();

    @Insert("INSERT INTO t_user (username,password,full_name,age,card_id,address,entry_date,title) " +
            "VALUES (#{username},#{password},#{fullName},#{age},#{cardId},#{address},#{entryDate},#{title});")
//    @Options(useGeneratedKeys = true)
    void createStaff(User user);

    @Delete("DELETE FROM t_user WHERE id=#{id} ")
    void deleteUser(Integer id);

    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    User selectOneById(Integer id);

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User findUserByUsername(String username);

    @Update("UPDATE t_user SET username = #{username} AND full_name=#{fullName} AND age=#{age} AND card_id = #{cardId}" +
            " AND address=#{address} AND  entry_date=#{entryDate} AND title= #{title};")
    void updateUser(User user);
}
