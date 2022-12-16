package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.FatalMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.constant.Constants;
import com.xxx.customer.pojo.SongList;
import com.xxx.customer.service.impl.SongListServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("歌单控制层")
public class SongListController {

    @Autowired
    private SongListServiceImpl songListService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(Constants.SONGLIST_PIC_PATH);
        }
    }

    // 获取全部歌单
    @ApiOperation(value = "获取全部歌单")
    @RequestMapping(value = "/songList", method = RequestMethod.GET)
    public Object allSongList() {
        return new SuccessMessage<List<SongList>>(null, songListService.allSongList()).getMessage();
    }

    // 添加歌单
    @ApiOperation(value = "添加歌单")
    @RequestMapping(value = "/songList/add", method = RequestMethod.POST)
    public Object addSongList(SongList songList) {
        boolean res = songListService.addSongList(songList);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("添加成功").getMessage();
        } else {
            return new ErrorMessage("添加失败").getMessage();
        }
    }

    // 更新歌单信息
    @ApiOperation(value = "更新歌单信息")
    @RequestMapping(value = "/songList/update", method = RequestMethod.POST)
    public Object updateSongListMsg(SongList songList) {
        boolean res = songListService.updateSongListMsg(songList);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

    // 更新歌单图片
    @ApiOperation(value = "更新歌单图片")
    @RequestMapping(value = "/songList/img/update", method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songListPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String imgPath = "/img/songListPic/" + fileName;
        try {
            avatarFile.transferTo(dest);
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPic(imgPath);

            boolean res = songListService.updateSongListMsg(songList);
            if (res) {
                return new SuccessMessage<String>("上传成功", imgPath).getMessage();
            } else {
                return new ErrorMessage("上传失败").getMessage();
            }
        } catch (IOException e) {
            return new FatalMessage("上传失败" + e.getMessage()).getMessage();
        }
    }

    // 删除歌单
    @ApiOperation(value = "删除歌单")
    @RequestMapping(value = "/songList/delete", method = RequestMethod.GET)
    public Object deleteSongList(Integer id) {
        boolean res = songListService.deleteSongList(id);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 返回指定类型的歌单
    @ApiOperation(value = "返回指定类型的歌单")
    @RequestMapping(value = "/songList/style/detail", method = RequestMethod.GET)
    public Object songListOfStyle(String style) {

        return new SuccessMessage<List<SongList>>(null, songListService.likeStyle(style)).getMessage();
    }

    // 返回标题包含文字的歌单
    @ApiOperation(value = "返回标题包含文字的歌单")
    @RequestMapping(value = "/songList/likeTitle/detail", method = RequestMethod.GET)
    public Object songListOfLikeTitle(String title) {
        return new SuccessMessage<List<SongList>>(null, songListService.likeTitle(title)).getMessage();
    }

}

