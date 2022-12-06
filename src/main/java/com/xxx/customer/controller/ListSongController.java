package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.customer.pojo.ListSong;
import com.xxx.customer.service.impl.ListSongServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@RestController
@Api("列表歌单控制层")
public class ListSongController {

    @Autowired
    private ListSongServiceImpl listSongService;

    // 给歌单添加歌曲
    @ApiOperation(value = "给歌单添加歌曲")
    @RequestMapping(value = "/listSong/add", method = RequestMethod.POST)
    public Object addListSong(ListSong listSong) {

        boolean res = listSongService.addListSong(listSong);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("添加成功").getMessage();
        } else {
            return new ErrorMessage("添加失败").getMessage();
        }
    }

    // 返回歌单里指定歌单ID的歌曲
    @ApiOperation(value = "返回歌单里指定歌单ID的歌曲")
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(Integer songListId) {
        return new SuccessMessage<List<ListSong>>("添加成功", listSongService.listSongOfSongId(songListId)).getMessage();
    }

    // 删除歌单里的歌曲
    @ApiOperation(value = "删除歌单里的歌曲")
    @RequestMapping(value = "/listSong/delete", method = RequestMethod.GET)
    public Object deleteListSong(Integer songId) {
        boolean res = listSongService.deleteListSong(songId);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 更新歌单里面的歌曲信息
    @ApiOperation(value = "更新歌单里面的歌曲信息")
    @RequestMapping(value = "/listSong/update", method = RequestMethod.POST)
    public Object updateListSongMsg(ListSong listSong) {
        boolean res = listSongService.updateListSongMsg(listSong);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

}

