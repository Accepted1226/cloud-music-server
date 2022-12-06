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
 * @author 公瑾
 * @since 2022-09-22
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("collect")
@ApiModel(value = "收藏实体类", description = "收藏描述类")
public class Collect extends Model<Collect> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收藏ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("类别")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("歌曲ID")
    @TableField("song_id")
    private Integer songId;

    @ApiModelProperty("歌单ID")
    @TableField("song_list_id")
    private Integer songListId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Collect(Integer id, Integer userId, Integer type, Integer songId, Integer songListId, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.songId = songId;
        this.songListId = songListId;
        this.createTime = new Date();
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
