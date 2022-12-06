package com.xxx.customer.pojo;

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
@NoArgsConstructor
@Accessors(chain = true)
@TableName("singer")
@ApiModel(value = "歌手实体类", description = "歌手描述类")
public class Singer extends Model<Singer> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("歌手ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("歌手姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("歌手性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("歌手照片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("歌手生日")
    @TableField("birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;

    @ApiModelProperty("歌手地址")
    @TableField("location")
    private String location;

    @ApiModelProperty("歌手介绍")
    @TableField("introduction")
    private String introduction;

    public Singer(Integer id, String name, Integer sex, String pic, Date birth, String location, String introduction) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.pic = pic;
        this.birth = new Date();
        this.location = location;
        this.introduction = introduction;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
