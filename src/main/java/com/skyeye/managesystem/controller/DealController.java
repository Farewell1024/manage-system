package com.skyeye.managesystem.controller;

import com.skyeye.managesystem.domain.Deal;
import com.skyeye.managesystem.mapper.DealMapper;
import com.skyeye.managesystem.utils.Result;
import com.skyeye.managesystem.utils.ResultGenerator;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 交易管理
 */
@RequestMapping("/deal")
@RestController
public class DealController {

    @Autowired
    private DealMapper dealMapper;

    @GetMapping("/get_all")
    Result getAll(){
        List<Deal> deals = dealMapper.getAll();
        deals.forEach(x -> x.setDescription(dealMapper.getDescriptionByDealId(x.getId())));
        return ResultGenerator.genSuccessResult(deals);
    }

    @Delete("/delete/{id}")
    Result delete(@PathVariable Integer id){
        Deal find = dealMapper.findById(id);
        if (find==null){
            return ResultGenerator.genFailResult("此交易不存在！");
        }
        dealMapper.deleteDealById(id);
        dealMapper.deleteDescriptionByDealId(id);
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/create")
    Result create(@RequestBody Deal deal){
        dealMapper.addDeal(deal);
        deal.getDescription().forEach(x -> {
            x.setDealId(deal.getId());
            dealMapper.addDescription(x);
        });
        return ResultGenerator.genSuccessResult(true);
    }

    @PostMapping("/update")
    Result update(@RequestBody Deal deal){
        Deal find = dealMapper.findById(deal.getId());
        if (find==null){
            return ResultGenerator.genFailResult("此交易不存在！");
        }
        dealMapper.updateDeal(deal);
        dealMapper.deleteDescriptionByDealId(deal.getId());
        deal.getDescription().forEach(x -> dealMapper.addDescription(x));
        return ResultGenerator.genSuccessResult(true);
    }
}
