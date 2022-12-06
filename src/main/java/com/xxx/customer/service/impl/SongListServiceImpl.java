package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.customer.pojo.SongList;
import com.xxx.customer.mapper.SongListMapper;
import com.xxx.customer.service.SongListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.omg.CORBA.PRIVATE_MEMBER;
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
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {

    @Autowired
    private SongListMapper songListMapper;

    // 获取全部歌单
    @Override
    public List<SongList> allSongList() {
        return songListMapper.selectList(null);
    }

    // 添加歌单
    @Override
    public boolean addSongList(SongList songList) {
        int i = songListMapper.insert(songList);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 更新歌单信息
    @Override
    public boolean updateSongListMsg(SongList songList) {
        int i = songListMapper.updateById(songList);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 删除歌单
    @Override
    public boolean deleteSongList(Integer id) {
        int i = songListMapper.deleteById(id);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    // 返回标题包含文字的歌单
    @Override
    public List<SongList> likeTitle(String title) {
        QueryWrapper<SongList> wrapper = new QueryWrapper<>();
        wrapper.like("title", title);
        return songListMapper.selectList(wrapper);
    }

    // 获取歌单类型
    @Override
    public List<SongList> likeStyle(String style) {
        QueryWrapper<SongList> wrapper = new QueryWrapper<>();
        wrapper.like("style", style);
        return songListMapper.selectList(wrapper);
    }
}
