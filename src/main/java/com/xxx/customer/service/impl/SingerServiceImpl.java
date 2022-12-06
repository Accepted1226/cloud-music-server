package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.customer.pojo.Singer;
import com.xxx.customer.mapper.SingerMapper;
import com.xxx.customer.service.SingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    // 返回所有歌手
    @Override
    public List<Singer> allSinger() {
        return singerMapper.selectList(null);
    }

    // 添加歌手
    @Override
    public boolean addSinger(Singer singer) {
        int i = singerMapper.insert(singer);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 更新歌手信息
    @Override
    public boolean updateSingerMsg(Singer singer) {
        UpdateWrapper<Singer> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", singer.getId());
        int i = singerMapper.update(singer, wrapper);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 删除歌手
    @Override
    public boolean deleteSinger(Integer id) {
        int i = singerMapper.deleteById(id);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 通过姓名查找歌手
    @Override
    public List<Singer> singerOfName(String name) {
        QueryWrapper<Singer> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        return singerMapper.selectList(wrapper);
    }

    // 通过性别查询歌手
    @Override
    public List<Singer> singerOfSex(Integer sex) {
        QueryWrapper<Singer> wrapper = new QueryWrapper<>();
        wrapper.eq("sex", sex);
        return singerMapper.selectList(wrapper);
    }
}
