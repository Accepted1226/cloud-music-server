package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.customer.pojo.RankList;
import com.xxx.customer.mapper.RankListMapper;
import com.xxx.customer.service.RankListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@Service
public class RankListServiceImpl extends ServiceImpl<RankListMapper, RankList> implements RankListService {

    @Autowired
    private RankListMapper rankListMapper;

    // 提交评分
    @Override
    public boolean addRank(RankList rankList) {
        int i = rankListMapper.insert(rankList);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 获取指定歌单的评分
    @Override
    public int rankOfSongListId(Long songListId) {
        int rankNum = rankListMapper.selectRankNum(songListId);
        return (rankNum <= 0) ? 0 : rankListMapper.selectScoreSum(songListId) / rankNum;
    }

    // 获取指定用户的歌单评分
    @Override
    public RankList getUserRank(Long consumerId, Long songListId) {
        QueryWrapper<RankList> wrapper = new QueryWrapper<>();
        wrapper.select("score")
                .eq("consumer_id", consumerId)
                .eq("song_list_id", songListId);
        return rankListMapper.selectOne(wrapper);
    }
}
