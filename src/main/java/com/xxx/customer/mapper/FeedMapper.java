package com.xxx.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.customer.pojo.Feed;
import com.xxx.customer.pojo.ListSong;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface FeedMapper extends BaseMapper<Feed> {

    @Select("SELECT id,content,media,createdAt,updatedAt,userId,(SELECT avatar from consumer WHERE userId=id)AS icon,(SELECT username from consumer WHERE userId=id)AS nickname from feed ORDER BY createdAt DESC")
    //@Select("SELECT * FROM feed")
    List<Feed> getAllFeeds();


    @Insert("INSERT INTO feed(content,media,userId,createdAt,updatedAt) VALUES(#{content},#{media},#{userId},#{createdAt},#{updatedAt})")
    int addFeed(Feed feed);

    @Select("SELECT COUNT(*) FROM feed WHERE userId=#{id}")
    int getSelfNum(Integer id);

    @Select("SELECT id,content,media,createdAt,updatedAt,userId,(SELECT avatar from consumer WHERE userId=id)AS icon,(SELECT username from consumer WHERE userId=id)AS nickname from feed WHERE userId=#{id} ORDER BY createdAt DESC")
    List<Feed> getSelfFeeds(Integer id);
}
