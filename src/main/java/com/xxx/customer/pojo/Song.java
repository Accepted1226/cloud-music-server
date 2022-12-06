package com.xxx.customer.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author 公瑾
 * @since 2022-09-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("song")
@ApiModel(value = "歌曲实体类", description = "歌曲描述类")
public class Song extends Model<Song> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("歌曲ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("点击数")
    @TableField("clicksCount")
    private Long clicksCount;

    @ApiModelProperty("评论数")
    @TableField("commentsCount")
    private Long commentsCount;

    @ApiModelProperty("歌手ID")
    @TableField("singer")
    private String singer;

    @ApiModelProperty("歌名")
    @TableField("name")
    private String name;

    @ApiModelProperty("歌曲介绍")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty("发行时间")
    @TableField(value = "createAt", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    @ApiModelProperty("修改时间")
    @TableField("updateAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    @ApiModelProperty("照片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("歌词")
    @TableField("lyric")
    private String lyric;

    @ApiModelProperty("资源位置")
    @TableField("uri")
    private String uri;



    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
