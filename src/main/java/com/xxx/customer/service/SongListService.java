package com.xxx.customer.service;

import com.xxx.customer.pojo.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
public interface SongListService extends IService<SongList> {

    boolean addSongList (SongList songList);

    boolean updateSongListMsg(SongList songList);

    boolean deleteSongList(Integer id);

    List<SongList> allSongList();

    List<SongList> likeTitle(String title);

    List<SongList> likeStyle(String style);

}
