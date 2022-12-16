package com.xxx.customer.mapper;

import com.xxx.customer.pojo.RankList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@Mapper
public interface RankListMapper extends BaseMapper<RankList> {

    // 查询总分
    int selectScoreSum(Long songListId);

    // 查询总评人数
    int selectRankNum(Long songListId);

}
