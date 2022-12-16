package com.xxx.customer.service;

import com.xxx.customer.pojo.Collect;
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
public interface CollectService extends IService<Collect> {

    boolean addCollect(Collect collect);

    boolean existSongId(Integer userId,Integer songId);

    boolean  deleteCollect(Integer userId,Integer songId);

    List<Collect> collectionOfUser(Integer userId);

}
