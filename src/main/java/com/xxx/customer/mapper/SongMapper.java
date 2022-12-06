package com.xxx.customer.mapper;

import com.xxx.customer.pojo.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@Mapper
public interface SongMapper extends BaseMapper<Song> {

    @Select("SELECT COUNT(*) FROM song")
    Integer countSong();

    @Select("SELECT id,clicksCount,commentsCount,singer,name,introduction,pic,createdAt,updatedAt,uri FROM song")
    List<Song> allSong();

    @Update("UPDATE song SET clicksCount=clicksCount+1")
    void update();
}
