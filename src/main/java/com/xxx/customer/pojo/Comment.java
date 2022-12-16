package com.xxx.customer.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
 * @author Alba
 * @since 2022-11-30
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("comment")
@ApiModel(value = "评论实体类", description = "评论描述类")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("歌曲ID")
    @TableField("song_id")
    private Integer songId;

    @ApiModelProperty("歌单ID")
    @TableField("song_list_id")
    private Integer songListId;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("类别")
    @TableField("type")
    private Integer type;

    @TableField("up")
    private Integer up;

    public Comment(Integer id, Integer userId, Integer songId, Integer songListId, String content, Date createTime, Integer type, Integer up) {
        this.id = id;
        this.userId = userId;
        this.songId = songId;
        this.songListId = songListId;
        this.content = content;
        this.createTime = new Date();
        this.type = type;
        this.up = up;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
