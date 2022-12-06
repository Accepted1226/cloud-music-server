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
 * @author 公瑾
 * @since 2022-09-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("list_song")
@ApiModel(value = "列表歌单实体类", description = "列表歌单描述类")
public class ListSong extends Model<ListSong> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("列表歌单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("歌曲ID")
    @TableField("song_id")
    private Integer songId;

    @ApiModelProperty("歌单ID")
    @TableField("song_list_id")
    private Integer songListId;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
