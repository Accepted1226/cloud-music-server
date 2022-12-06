package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.customer.pojo.Comment;
import com.xxx.customer.mapper.CommentMapper;
import com.xxx.customer.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    // 获得指定歌曲ID的评论列表
    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("song_id", songId);
        return commentMapper.selectList(wrapper);
    }

    // 获得指定歌单ID的评论列表
    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("song_list_id", songListId);
        return commentMapper.selectList(wrapper);
    }

    // 删除评论
    @Override
    public boolean deleteComment(Integer id) {
        int i = commentMapper.deleteById(id);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 提交评论
    @Override
    public boolean addComment(Comment comment) {
        int i = commentMapper.insert(comment);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 更新评论
    @Override
    public boolean updateCommentMsg(Comment comment) {
        int i = commentMapper.updateById(comment);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
}
