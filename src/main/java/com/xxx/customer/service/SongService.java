package com.xxx.customer.service;

import com.xxx.customer.pojo.Song;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@Transactional
public interface SongService extends IService<Song> {

    boolean addSong (Song song);

    boolean updateSongMsg(Song song);

    boolean deleteSong(Integer id);

    //List<Song> allSong();
    List<Song> allSong();

    Integer countSong();

    List<Song> songOfSingerId(Integer singerId);

    List<Song> songOfId(Integer id);

    List<Song> songOfSingerName(String name);

    void updateSongClick();

}
