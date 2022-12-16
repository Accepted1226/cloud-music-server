package com.xxx.customer.service;

import com.xxx.customer.pojo.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
public interface SongListService extends IService<SongList> {

    boolean addSongList (SongList songList);

    boolean updateSongListMsg(SongList songList);

    boolean deleteSongList(Integer id);

    List<SongList> allSongList();

    List<SongList> likeTitle(String title);

    List<SongList> likeStyle(String style);

}
