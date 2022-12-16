package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.FatalMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.constant.Constants;
import com.xxx.customer.pojo.Singer;
import com.xxx.customer.service.impl.SingerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("歌手控制层")
public class SingerController {

    @Autowired
    private SingerServiceImpl singerService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(Constants.SINGER_PIC_PATH);
        }
    }

    // 返回所有歌手
    @ApiOperation(value = "返回所有歌手")
    @RequestMapping(value = "/singer", method = RequestMethod.GET)
    public Object allSinger() {
        return new SuccessMessage<List<Singer>>(null, singerService.allSinger()).getMessage();
    }

    // 添加歌手
    @ApiOperation(value = "添加歌手")
    @RequestMapping(value = "/singer/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest req) {
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();
        String pic = "/img/avatarImages/user.jpg";

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(Integer.valueOf(new Byte(sex)));
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        singer.setPic(pic);

        boolean res = singerService.addSinger(singer);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("添加成功").getMessage();
        } else {
            return new ErrorMessage("添加失败").getMessage();
        }
    }

    // 更新歌手信息
    @ApiOperation(value = "更新歌手信息")
    @RequestMapping(value = "/singer/update", method = RequestMethod.POST)
    public Object updateSingerMsg(HttpServletRequest req) {
        String id = req.getParameter("id").trim();
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(Integer.valueOf(new Byte(sex)));
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean res = singerService.updateSingerMsg(singer);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

    // 删除歌手
    @ApiOperation(value = "删除歌手")
    @RequestMapping(value = "/singer/delete", method = RequestMethod.GET)
    public Object deleteSinger(Integer id) {
        boolean res = singerService.deleteSinger(id);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 更新歌手头像
    @ApiOperation(value = "更新歌手头像")
    @RequestMapping(value = "/singer/avatar/update", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") Integer id) {
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "singerPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String imgPath = "/img/singerPic/" + fileName;
        try {
            avatarFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(imgPath);

            boolean res = singerService.updateSingerMsg(singer);
            if (res) {
                return new SuccessMessage<String>("上传成功", imgPath).getMessage();
            } else {
                return new ErrorMessage("上传失败").getMessage();
            }
        } catch (IOException e) {
            return new FatalMessage("上传失败" + e.getMessage()).getMessage();
        }
    }

    // 根据歌手名查找歌手
    @ApiOperation(value = "根据歌手名查找歌手")
    @RequestMapping(value = "/singer/name/detail", method = RequestMethod.GET)
    public Object singerOfName(String name) {
        return new SuccessMessage<List<Singer>>(null, singerService.singerOfName(name)).getMessage();
    }

    // 根据歌手性别查找歌手
    @ApiOperation(value = "根据歌手性别查找歌手")
    @RequestMapping(value = "/singer/sex/detail", method = RequestMethod.GET)
    public Object singerOfSex(Integer sex) {
        return new SuccessMessage<List<Singer>>(null, singerService.singerOfSex(sex)).getMessage();
    }

}

