package com.xxx.customer.service;

import com.xxx.customer.pojo.Singer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
public interface SingerService extends IService<Singer> {

    boolean addSinger (Singer singer);

    boolean updateSingerMsg(Singer singer);

    boolean deleteSinger(Integer id);

    List<Singer> allSinger();

    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(Integer sex);

}
