package com.xxx.customer.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("song_list")
@ApiModel(value = "歌单实体类", description = "歌单描述类")
public class SongList extends Model<SongList> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("歌单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("照片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("歌单介绍")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty("歌单风格")
    @TableField("style")
    private String style;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
