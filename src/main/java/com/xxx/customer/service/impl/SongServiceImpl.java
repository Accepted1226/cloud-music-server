package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.customer.pojo.Song;
import com.xxx.customer.mapper.SongMapper;
import com.xxx.customer.service.SongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {

    @Autowired
    private SongMapper songMapper;

//    // 返回所有歌曲
//    @Override
//    public List<Song> allSong() {
//        System.out.println("====service==="+songMapper.allSong());
//        return songMapper.allSong();
//    }
    @Override
    public List<Song> allSong(){
        List<Song> songList=new ArrayList<>();
        songList=songMapper.allSong();
        System.out.println(songList);
        return songMapper.allSong();
    }



    @Override
    public Integer countSong() {
        return songMapper.countSong();
    }

    // 返回指定歌手ID的歌曲
    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        QueryWrapper<Song> wrapper = new QueryWrapper<>();
        wrapper.eq("singer_id", singerId);
        return songMapper.selectList(wrapper);
    }

    // 返回的指定用户ID收藏列表
    @Override
    public List<Song> songOfId(Integer id) {
        QueryWrapper<Song> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return songMapper.selectList(wrapper);
    }

    // 返回指定歌手名的歌曲
    @Override
    public List<Song> songOfSingerName(String name) {
        QueryWrapper<Song> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        return songMapper.selectList(wrapper);
    }

    @Override
    public void updateSongClick() {
        songMapper.update();
    }


    // 更新歌曲信息
    @Override
    public boolean updateSongMsg(Song song) {
        int i = songMapper.updateById(song);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 删除歌曲
    @Override
    public boolean deleteSong(Integer id) {
        int i = songMapper.deleteById(id);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 添加歌曲
    @Override
    public boolean addSong(Song song) {
        int i = songMapper.insert(song);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


}
