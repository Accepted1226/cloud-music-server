package com.xxx.customer.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xxx.common.ErrorMessage;
import com.xxx.common.FatalMessage;
import com.xxx.common.Result;
import com.xxx.common.SuccessMessage;
import com.xxx.customer.pojo.Feed;
import com.xxx.customer.pojo.Song;
import com.xxx.customer.service.impl.FeedServiceImpl;
import com.xxx.customer.service.impl.SongServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@Api("动态控制层")
public class FeedController {

    @Autowired
    private FeedServiceImpl feedService;

//    // 返回所有歌曲
//    @ApiOperation(value = "返回所有动态")
//    @GetMapping("v1/feeds")
//    public Result getAllFeeds( @RequestParam(name="size",required = false,defaultValue ="10") Integer size,
//                             @RequestParam(name="page",required = false,defaultValue = "1")Integer page){
//        System.out.println("page:"+page+";size:"+size);
//        return Result.success(feedService.getAllFeeds(page,size));
//    }
    @GetMapping("/v1/feeds")
    @ApiOperation("查看所有动态")
    //page:页码；size：页面大小
    public Result getAllFeeds(@NotNull @RequestParam(value="page",required = false,defaultValue = "1")Integer pageNum,
                             @NotNull @RequestParam(value="size",required = false,defaultValue ="10")Integer pageSize){
        return Result.success(feedService.getAllFeeds(pageNum,pageSize));
    }



    @ApiOperation(value="获取用户自己发布的动态")
    @RequestMapping(value = "v1/feeds/self",method = RequestMethod.GET)
    public Object getSelfFeeds(@NotNull@RequestParam("id")Integer id){
        int total=feedService.getSelfNum(id);
        return new SuccessMessage<List<Feed>>(feedService.getSelfFeeds(id),total,null).getMessage();
    }


    @ApiOperation(value="新增动态")
    @RequestMapping(value="v1/feeds",method=RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "文本内容",required = true,dataType = "String"),
            @ApiImplicitParam(name = "media", value = "多媒体内容",required = true,dataType = "String")})
    public Object addFeed(@NotNull@RequestParam("id")Integer id,@NotNull@RequestParam("content")String content,@RequestParam("media")String media){
//        HttpSession session = request.getSession();
//        System.out.println(session);
//        System.out.println(session.getId());
        //session.getAttribute("id");
//        System.out.println(session.getAttribute("id"));
//        if(session.getAttribute("id").toString()==null){
//            return new ErrorMessage("请求没带cookie");
//        }
//        String idString=session.getAttribute("id").toString();
//        Integer user_id=Integer.parseInt(idString);
//        System.out.println(user_id);
        Integer user_id=id;
        if(user_id<0){
            return new ErrorMessage("该用户不存在错误").getMessage();
        }
        Feed feed=new Feed();
        feed.setContent(content);
        feed.setMedia(media);
        feed.setUserId(user_id);
        feed.setCreatedAt(new Date());
        feed.setUpdatedAt(new Date());
        int res=feedService.addFeed(feed);
        //T lis,Integer count,String msg
        return new SuccessMessage<String>(user_id).getMessage();
//
    }
//
//    // 新增歌曲
//    @ApiOperation(value = "新增歌曲")
//    @RequestMapping(value = "/song/add", method = RequestMethod.POST)
//    public Object addSong(HttpServletRequest req, @RequestParam("file") MultipartFile mpFile) {
//        String singer_id = req.getParameter("singerId").trim();
//        String name = req.getParameter("name").trim();
//        String introduction = req.getParameter("introduction").trim();
//        String pic = "/img/songPic/user.jpg";
//        String lyric = req.getParameter("lyric").trim();
//
//        String fileName = mpFile.getOriginalFilename();
//        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
//        File file1 = new File(filePath);
//        if (!file1.exists()) {
//            file1.mkdir();
//        }
//
//        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
//        String storeUrlPath = "/song/" + fileName;
//        try {
//            mpFile.transferTo(dest);
//            Song song = new Song();
//            song.setName(name);
//            song.setIntroduction(introduction);
//            song.setCreateTime(new Date());
//            song.setUpdateTime(new Date());
//            song.setPic(pic);
//            song.setLyric(lyric);
//            song.setUri(storeUrlPath);
//            boolean res = songService.addSong(song);
//            if (res) {
//                return new SuccessMessage<String>("上传成功", storeUrlPath).getMessage();
//            } else {
//                return new ErrorMessage("上传失败").getMessage();
//            }
//        } catch (IOException e) {
//            return new FatalMessage("上传失败" + e.getMessage()).getMessage();
//        }
//    }
//
//


}
