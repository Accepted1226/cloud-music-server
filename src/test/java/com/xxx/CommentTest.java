package com.xxx;

import com.xxx.customer.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentServiceImpl commentService;

    @Test
    void contextLoads() {
//      commentService.commentOfSongId(1).forEach(System.out::println);
      commentService.commentOfSongListId(1).forEach(System.out::println);

    }
}
