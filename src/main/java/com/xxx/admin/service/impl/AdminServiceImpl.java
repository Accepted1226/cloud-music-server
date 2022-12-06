package com.xxx.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.admin.mapper.AdminMapper;
import com.xxx.admin.pojo.Admin;
import com.xxx.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    // 进行登录验证业务处理
    @Autowired
    AdminMapper adminMapper;

    public Admin getLogin(String name, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name).eq("password",password);
        return adminMapper.selectOne(wrapper);
    }
}
