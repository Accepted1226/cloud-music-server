package com.xxx.customer.service;

import com.xxx.customer.pojo.RankList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
public interface RankListService extends IService<RankList> {

    boolean addRank(RankList rankList);

    int rankOfSongListId(Long songListId);

    RankList getUserRank(Long consumerId, Long songListId);

}
