package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.admin.mapper.AdminMapper;
import com.xxx.admin.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MusicServerApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    void contextLoads() {
//        List<Admin> adminList = adminMapper.selectList(null);
//        adminList.forEach(System.out::println);

        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name","admin").eq("password","123");
        System.out.println(adminMapper.selectOne(wrapper));
    }
}
