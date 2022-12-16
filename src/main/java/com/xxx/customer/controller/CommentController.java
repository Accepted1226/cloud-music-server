package com.xxx.customer.controller;


import com.xxx.common.ErrorMessage;
import com.xxx.common.SuccessMessage;
import com.xxx.customer.pojo.Comment;
import com.xxx.customer.service.impl.CommentServiceImpl;
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
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("评论控制层")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    // 获得指定歌曲 ID 的评论列表
    @ApiOperation(value = "获得指定歌曲 ID 的评论列表")
    @RequestMapping(value = "/comment/song/detail", method = RequestMethod.GET)
    public Object commentOfSongId(Integer songId) {

        return new SuccessMessage<List<Comment>>(null, commentService.commentOfSongId(songId)).getMessage();
    }

    // 获得指定歌单 ID 的评论列表
    @ApiOperation(value = "获得指定歌单 ID 的评论列表")
    @RequestMapping(value = "/comment/songList/detail", method = RequestMethod.GET)
    public Object commentOfSongListId(Integer songListId) {
        return new SuccessMessage<List<Comment>>(null, commentService.commentOfSongListId(songListId)).getMessage();
    }

    // 删除评论
    @ApiOperation(value = "删除评论")
    @RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
    public Object deleteComment(Integer id) {

        boolean res = commentService.deleteComment(id);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 提交评论
    @ApiOperation(value = "提交评论")
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public Object addComment(Comment comment) {
        boolean res = commentService.addComment(comment);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("评论成功").getMessage();
        } else {
            return new ErrorMessage("评论失败").getMessage();
        }
    }

    // 点赞
    @ApiOperation(value = "点赞")
    @RequestMapping(value = "/comment/like", method = RequestMethod.POST)
    public Object commentOfLike(Comment comment) {
        boolean res = commentService.updateCommentMsg(comment);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("点赞成功").getMessage();
        } else {
            return new ErrorMessage("点赞失败").getMessage();
        }
    }

}

