package com.xxx.customer.controller;


import com.alibaba.fastjson.JSONObject;
import com.xxx.common.ErrorMessage;
import com.xxx.common.FatalMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.constant.Constants;
import com.xxx.customer.pojo.Song;
import com.xxx.customer.pojo.SongDTO;
import com.xxx.customer.service.impl.SongServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("歌曲控制层")
public class SongController {

    @Autowired
    private SongServiceImpl songService;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(35, DataUnit.MEGABYTES));
        // 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(35, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songPic/**")
                    .addResourceLocations(Constants.SONG_PIC_PATH);
            registry.addResourceHandler("/song/**")
                    .addResourceLocations(Constants.SONG_PATH);
        }
    }

    // 返回所有歌曲
    @ApiOperation(value = "返回所有歌曲")
    @RequestMapping(value = "v1/songs", method = RequestMethod.GET)
    public Object allSong() {
        //JSONObject data=new JSONObject();
        Integer total=songService.countSong();//歌曲总数
        songService.updateSongClick();
        return new SuccessMessage<List<Song>>(songService.allSong(),total,null).getMessage();
    }

    // 返回指定ID的歌曲
    @ApiOperation(value = "返回指定ID的歌曲")
    @RequestMapping(value = "/v1/songdetail", method = RequestMethod.GET)
    @ApiImplicitParam(name = "id",value = "歌曲id",paramType = "query",dataType = "Integer")
    public Object getSongById(@RequestParam(value = "id",defaultValue = "1")Integer id) {
        List<Song> songs=songService.songOfId(id);
        if (songs.size()==0){
            return new SuccessMessage<List<Song>>("无该歌曲",songs).getMessage();
        }
        Song song=songs.get(0);
        //System.out.println(song);
        return new SuccessMessage<Song>("查询成功",song).getMessage();
    }

    // 返回的指定用户ID收藏列表
    @ApiOperation(value = "返回的指定用户ID收藏列表")
    @RequestMapping(value = "/song/detail", method = RequestMethod.GET)
    public Object songOfId(Integer id) {
        return new SuccessMessage<List<Song>>(null, songService.songOfId(id)).getMessage();
    }

    // 返回指定歌手名的歌曲
    @ApiOperation(value = "返回指定歌手名的歌曲")
    @RequestMapping(value = "/song/singerName/detail", method = RequestMethod.GET)
    public Object songOfSingerName(String name) {

        return new SuccessMessage<List<Song>>(null, songService.songOfSingerName(name)).getMessage();
    }

    // 更新歌曲信息
    @ApiOperation(value = "更新歌曲信息")
    @RequestMapping(value = "/song/update", method = RequestMethod.POST)
    public Object updateSongMsg(Song song) {
        boolean res = songService.updateSongMsg(song);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

     // 新增歌曲
     @ApiOperation(value = "新增歌曲")
     @RequestMapping(value = "/song/add", method = RequestMethod.POST)
     public Object addSong(HttpServletRequest req, @RequestParam("file") MultipartFile mpFile) {
         String singer_id = req.getParameter("singerId").trim();
         String name = req.getParameter("name").trim();
         String introduction = req.getParameter("introduction").trim();
         String pic = "/img/songPic/user.jpg";
         String lyric = req.getParameter("lyric").trim();

         String fileName = mpFile.getOriginalFilename();
         String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
         File file1 = new File(filePath);
         if (!file1.exists()) {
             file1.mkdir();
         }

         File dest = new File(filePath + System.getProperty("file.separator") + fileName);
         String storeUrlPath = "/song/" + fileName;
         try {
             mpFile.transferTo(dest);
             Song song = new Song();
             song.setName(name);
             song.setIntroduction(introduction);
             song.setCreatedAt(new Date());
             song.setUpdatedAt(new Date());
             song.setPic(pic);
             song.setLyric(lyric);
             song.setUri(storeUrlPath);
             boolean res = songService.addSong(song);
             if (res) {
                 return new SuccessMessage<String>("上传成功", storeUrlPath).getMessage();
             } else {
                 return new ErrorMessage("上传失败").getMessage();
             }
         } catch (IOException e) {
             return new FatalMessage("上传失败" + e.getMessage()).getMessage();
         }
     }

    // 删除歌曲
    @ApiOperation(value = "删除歌曲")
    @RequestMapping(value = "/song/delete", method = RequestMethod.GET)
    public Object deleteSong(Integer id) {
        boolean res = songService.deleteSong(id);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 更新歌曲图片
    @ApiOperation(value = "更新歌曲图片")
    @RequestMapping(value = "/song/img/update", method = RequestMethod.POST)
    public Object updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        String fileName = System.currentTimeMillis() + urlFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storeUrlPath);
            boolean res = songService.updateSongMsg(song);
            if (res) {
                return new SuccessMessage<String>("上传成功", storeUrlPath).getMessage();
            } else {
                return new ErrorMessage("上传失败").getMessage();
            }
        } catch (IOException e) {
            return new FatalMessage("上传失败" + e.getMessage()).getMessage();
        }
    }

    // 更新歌曲地址
    @ApiOperation(value = "更新歌曲地址")
    @RequestMapping(value = "/song/url/update", method = RequestMethod.POST)
    public Object updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        String fileName = urlFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setUri(storeUrlPath);
            boolean res = songService.updateSongMsg(song);
            if (res) {
                return new SuccessMessage<String>("更新成功", storeUrlPath).getMessage();
            } else {
                return new ErrorMessage("更新失败").getMessage();
            }
        } catch (IOException e) {
            return new FatalMessage("更新失败" + e.getMessage()).getMessage();
        }
    }
}

