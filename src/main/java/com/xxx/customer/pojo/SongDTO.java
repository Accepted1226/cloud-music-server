package com.xxx.customer.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDTO {

    private Long id;
    private String clicks_count;
    private String comments_count;
    private String singer;
    private String name;
    private String introduction;
    private Date createTime;
    private Date updateTime;
    private String pic;
    private String uri;

}

