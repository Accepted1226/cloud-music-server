package com.xxx.customer.service;

import com.github.pagehelper.PageInfo;
import com.xxx.common.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.customer.pojo.Feed;
import com.xxx.customer.pojo.ListSong;

import java.util.List;

public interface FeedService extends IService<Feed> {
    //PageInfo<Feed> getAllFeeds(Integer pageNum, Integer pageSize);


    Page<Feed> getAllFeeds(int pageNum, int pageSize);

    int addFeed(Feed feed);

    int getSelfNum(Integer id);

    List<Feed> getSelfFeeds(Integer id);
}
