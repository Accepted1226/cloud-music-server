package com.xxx.customer.service;

import com.xxx.customer.pojo.ListSong;
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
public interface ListSongService extends IService<ListSong> {

    boolean addListSong(ListSong listSong);

    boolean updateListSongMsg(ListSong listSong);

    boolean deleteListSong(Integer songId);

    List<ListSong> listSongOfSongId(Integer songListId);

}
