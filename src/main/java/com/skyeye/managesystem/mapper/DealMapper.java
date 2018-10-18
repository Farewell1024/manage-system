package com.skyeye.managesystem.mapper;

import com.skyeye.managesystem.domain.po.Deal;
import com.skyeye.managesystem.domain.po.DealDescription;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DealMapper {

    @Select("select id, user_id, user_name,type from t_deal;")
    List<Deal> getAll();

    @Select("select deal_id,create_time,description,order_no from t_deal_description where deal_id=#{id} order by order_no")
    List<DealDescription> getDescriptionByDealId(Integer id);

    @Delete("delete from t_deal where id=#{id}")
    void deleteDealById(Integer id);

    @Delete("delete from t_deal_description where deal_id=#{id}")
    void deleteDescriptionByDealId(Integer id);

    @Insert("insert into t_deal (user_id, user_name,type) " +
            "values (#{userId},#{userName},#{type}) ")
    @Options(useGeneratedKeys = true)
    void addDeal(Deal deal);

    @Insert("insert into t_deal_description (deal_id,create_time,description,order_no) " +
            "values (#{dealId},#{createTime},#{description},#{orderNo}) ")
    void addDescription(DealDescription x);

    @Select("select id, user_id, user_name,type from t_deal where id=#{id}")
    Deal findById(Integer id);

    @Update("update t_deal set user_id=#{userId} , user_name=#{userName} , type=#{type} where id=#{id} ")
    void updateDeal(Deal deal);
}
