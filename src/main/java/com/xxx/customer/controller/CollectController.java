package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.customer.pojo.Collect;
import com.xxx.customer.service.impl.CollectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@RestController
@Api("收藏控制层")
public class CollectController {

    @Autowired
    private CollectServiceImpl collectService;

    // 返回的指定用户 ID 收藏的列表
    @ApiOperation(value = "返回的指定用户 ID 收藏的列表")
    @RequestMapping(value = "/collection/detail", method = RequestMethod.GET)
    public Object collectionOfUser(Integer userId) {
        return new SuccessMessage<List<Collect>>("取消收藏", collectService.collectionOfUser(userId)).getMessage();
    }

    // 取消收藏
    @ApiOperation(value = "取消收藏")
    @DeleteMapping("/collection/delete")
    public Object deleteCollect(Integer userId, Integer songId) {
        boolean res = collectService.deleteCollect(userId, songId);
        if (res) {
            return new SuccessMessage<Boolean>("取消收藏", false).getMessage();
        } else {
            return new ErrorMessage("取消收藏失败").getMessage();
        }
    }

    // 添加收藏
    @ApiOperation(value = "添加收藏")
    @RequestMapping(value = "/collection/add", method = RequestMethod.POST)
    public Object addCollection(Collect collect) {
        boolean res = collectService.addCollect(collect);
        if (res) {
            return new SuccessMessage<Boolean>("收藏成功", true).getMessage();
        } else {
            return new ErrorMessage("收藏失败").getMessage();
        }
    }

    // 是否收藏
    @ApiOperation(value = "判断是否收藏")
    @RequestMapping(value = "/collection/status", method = RequestMethod.POST)
    public Object isCollection(Integer userId, Integer songId) {

        boolean res = collectService.existSongId(userId,songId);
        if (res) {
            return new SuccessMessage<Boolean>("已收藏", true).getMessage();
        } else {
            return new SuccessMessage<Boolean>("未收藏", false).getMessage();
        }
    }

}

