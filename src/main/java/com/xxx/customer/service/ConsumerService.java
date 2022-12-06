package com.xxx.customer.service;

import com.xxx.customer.pojo.Consumer;
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
public interface ConsumerService extends IService<Consumer> {

    int  addUser(Consumer consumer);

    boolean  updateUserMsg(Consumer consumer);

    boolean  updateUserAvatar(Consumer consumer);

    boolean  updatePassword(Consumer consumer);

    boolean existUser(String username);

    boolean verifyPassword(String username,String password);

    boolean deleteUser(Integer id);

    List<Consumer> allUser();

    Consumer userOfId(Integer id);

    List<Consumer> loginStatus(String username);

    Integer selectUserByPhone(String phone);
}
