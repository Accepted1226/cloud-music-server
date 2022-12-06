package com.xxx;

import com.xxx.customer.service.impl.SongServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SongTest {

    @Autowired
    private SongServiceImpl songService;

    @Test
    void contextLoads() {
        songService.songOfSingerName("陈").forEach(System.out::println);

    }
}
