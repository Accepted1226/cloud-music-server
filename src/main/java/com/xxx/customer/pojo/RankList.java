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
@TableName("rank_list")
@ApiModel(value = "排行榜实体类", description = "排行榜描述类")
public class RankList extends Model<RankList> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("排行榜ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("歌单ID")
    @TableField("songListId")
    private Long songListId;

    @ApiModelProperty("用户ID")
    @TableField("consumerId")
    private Long consumerId;

    @ApiModelProperty("评分")
    @TableField("score")
    private Integer score;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
