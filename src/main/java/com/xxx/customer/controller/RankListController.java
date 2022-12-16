package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.customer.pojo.RankList;
import com.xxx.customer.service.impl.RankListServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("评分控制层")
public class RankListController {

    @Autowired
    private RankListServiceImpl rankListService;

    // 提交评分
    @ApiOperation(value = "提交评分")
    @RequestMapping(value = "/rankList/add", method = RequestMethod.POST)
    public Object addRank(RankList rankList) {
        boolean res = rankListService.addRank(rankList);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("评价成功").getMessage();
        } else {
            return new ErrorMessage("评价失败").getMessage();
        }
    }

    // 获取指定歌单的评分
    @ApiOperation(value = "获取指定歌单的评分")
    @RequestMapping(value = "/rankList", method = RequestMethod.GET)
    public Object rankOfSongListId(Long songListId) {
        return new SuccessMessage<Number>(null, rankListService.rankOfSongListId(songListId)).getMessage();
    }


    // 获取指定用户的歌单评分
    @ApiOperation(value = "获取指定用户的歌单评分")
    @RequestMapping(value = "/rankList/user", method = RequestMethod.GET)
    public Object getUserRank(Long consumerId, Long songListId) {
        RankList userRank = rankListService.getUserRank(consumerId, songListId);
        return new SuccessMessage<Number>(null, userRank.getScore()).getMessage();
    }


}

