package com.xxx.customer.service;

import com.xxx.customer.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
public interface CommentService extends IService<Comment> {

    List<Comment> commentOfSongId(Integer songId);

    List<Comment> commentOfSongListId(Integer songListId);

    boolean deleteComment(Integer id);

    boolean addComment(Comment comment);

    boolean updateCommentMsg(Comment comment);

}
