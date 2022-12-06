package com.xxx.customer.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("feed")
@ApiModel(value = "动态实体类", description = "动态描述类")
public class Feed extends Model<Feed> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("动态ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文本内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("多媒体拼接内容")
    @TableField("media")
    private String media;

    @ApiModelProperty("发帖人id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("创建时间")
    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    @ApiModelProperty("修改时间")
    @TableField("updatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;


    @TableField("nickname")
    private String nickname;

    @TableField("icon")
    private String icon;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
