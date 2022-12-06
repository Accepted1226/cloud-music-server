package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.common.Page;
import com.xxx.customer.mapper.FeedMapper;
import com.xxx.customer.pojo.Feed;
import com.xxx.customer.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl extends ServiceImpl<FeedMapper, Feed> implements FeedService {

    @Autowired
    private FeedMapper feedMapper;


//    @Override
//    public PageInfo<Feed> getAllFeeds(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<Feed> feeds=feedMapper.getAllFeeds();
//        PageInfo<Feed> pageInfo = new PageInfo<>(feeds);
//        return pageInfo;
//    }

    @Override
    public Page<Feed> getAllFeeds(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feed> FeedList = feedMapper.getAllFeeds();
        return new Page<>(new PageInfo<>(FeedList));
    }



    @Override
    public int addFeed(Feed feed) {
        int i = feedMapper.insert(feed);
        return i;
    }

    @Override
    public int getSelfNum(Integer id) {
        return feedMapper.getSelfNum(id);
    }

    @Override
    public List<Feed> getSelfFeeds(Integer id) {
        return feedMapper.getSelfFeeds(id);
    }


}
