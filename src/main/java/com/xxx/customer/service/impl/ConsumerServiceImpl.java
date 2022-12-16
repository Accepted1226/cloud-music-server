package com.xxx.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.customer.pojo.Consumer;
import com.xxx.customer.mapper.ConsumerMapper;
import com.xxx.customer.service.ConsumerService;
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
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;


    // 返回所有用户
    @Override
    public List<Consumer> allUser() {
        return consumerMapper.selectList(null);
    }

    // 返回指定 ID 的用户
    @Override
    public Consumer userOfId(Integer id) {

        return consumerMapper.userOfId(id);
    }

    // 添加用户
    @Override
    public int addUser(Consumer consumer) {
        int res = consumerMapper.insert(consumer);
        return res;
    }

    // 更新用户信息
    @Override
    public boolean updateUserMsg(Consumer consumer) {
        UpdateWrapper<Consumer> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", consumer.getId());
        int i = consumerMapper.update(consumer, updateWrapper);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 删除用户
    @Override
    public boolean deleteUser(Integer id) {
        int i = consumerMapper.deleteById(id);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 用户更新头像
    @Override
    public boolean updateUserAvatar(Consumer consumer) {
        UpdateWrapper<Consumer> wrapper = new UpdateWrapper<>();
        wrapper.isNotNull("avatar");
        wrapper.eq("id",consumer.getId());
        int i = consumerMapper.update(consumer, wrapper);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 用户更新密码
    @Override
    public boolean updatePassword(Consumer consumer) {
        UpdateWrapper<Consumer> wrapper = new UpdateWrapper<>();
        wrapper.isNotNull("password");
        int i = consumerMapper.update(consumer, wrapper);
        boolean flag = true;
        if (i > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 判断用户是否存在
    @Override
    public boolean existUser(String phone) {
        QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phone);
        return consumerMapper.selectCount(wrapper) > 0;
    }

    // 验证用户密码
    @Override
    public boolean verifyPassword(String phone, String password) {
        QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phone);
        wrapper.eq("password", password);
        return consumerMapper.selectCount(wrapper) > 0;
    }

    // 登录
    @Override
    public List<Consumer> loginStatus(String phone) {
        QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phone);
        return consumerMapper.selectList(wrapper);
    }

    @Override
    public Integer selectUserByPhone(String phone) {
        Integer id= consumerMapper.selectUserByPhone(phone);
        return id;
    }
}
