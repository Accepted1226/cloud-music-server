package com.xxx;


import com.xxx.customer.mapper.ConsumerMapper;
import com.xxx.customer.service.impl.ConsumerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerTest {


    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private ConsumerServiceImpl consumerService;

    @Test
    void contextLoads() {
        consumerService.allUser().forEach(System.out::println);
//        consumerMapper.selectList(null).forEach(System.out::println);
//        QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",1);
//        consumerMapper.selectList(wrapper).forEach(System.out::println);
//        Consumer consumer = new Consumer(30,"ccc","4545",0,"6666","1122125@qq.com",new Date(),"你好啊",null,null,null,null);
//      consumerMapper.insert(consumer);
//        UpdateWrapper<Consumer> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("id",consumer.getId());
//        int i = consumerMapper.update(consumer, updateWrapper);
//         consumerMapper.deleteById(30);
    }
}
