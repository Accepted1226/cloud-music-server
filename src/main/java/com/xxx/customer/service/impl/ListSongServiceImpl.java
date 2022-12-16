package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.customer.pojo.ListSong;
import com.xxx.customer.mapper.ListSongMapper;
import com.xxx.customer.service.ListSongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements ListSongService {

    @Autowired
    private ListSongMapper listSongMapper;

    // 给歌单添加歌曲
    @Override
    public boolean addListSong(ListSong listSong) {
        int i = listSongMapper.insert(listSong);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 返回歌单里指定歌单ID的歌曲
    @Override
    public List<ListSong> listSongOfSongId(Integer songListId) {
        QueryWrapper<ListSong> wrapper = new QueryWrapper<>();
        wrapper.eq("song_list_id", songListId);
        return listSongMapper.selectList(wrapper);
    }

    // 删除歌单里的歌曲
    @Override
    public boolean deleteListSong(Integer songId) {
        int i = listSongMapper.deleteById(songId);
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
    public boolean updateListSongMsg(ListSong listSong) {
        int i = listSongMapper.updateById(listSong);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


}
