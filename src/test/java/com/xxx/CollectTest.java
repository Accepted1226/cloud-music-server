package com.xxx;

import com.xxx.customer.service.impl.CollectServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class CollectTest {

    @Autowired
    private CollectServiceImpl collectService;

    @Test
    void contextLoads() {
        // QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        // wrapper.eq("user_id",1);
        //  collectMapper.selectList(wrapper).forEach(System.out::println);
        collectService.collectionOfUser(1).forEach(System.out::println);

    }
}
