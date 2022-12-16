package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.customer.pojo.Collect;
import com.xxx.customer.mapper.CollectMapper;
import com.xxx.customer.service.CollectService;
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
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    // 返回的指定用户 ID 收藏的列表
    @Override
    public List<Collect> collectionOfUser(Integer userId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return collectMapper.selectList(wrapper);
    }

    // 取消收藏
    @Override
    public boolean deleteCollect(Integer userId, Integer songId) {
        UpdateWrapper<Collect> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id", userId).eq("song_id", songId);
        int i = collectMapper.delete(wrapper);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 添加收藏
    @Override
    public boolean addCollect(Collect collect) {
        int i = collectMapper.insert(collect);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 是否收藏
    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).eq("song_id", songId);
        return collectMapper.selectCount(wrapper) > 0;
    }
}
