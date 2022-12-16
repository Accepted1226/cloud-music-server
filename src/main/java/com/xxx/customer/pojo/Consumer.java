package com.xxx.customer.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
 * @author Alba
 * @since 2022-11-30
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("consumer")
@ApiModel(value = "用户实体类", description = "用户描述类")
public class Consumer extends Model<Consumer> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("用户密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("手机号")
    @TableField("phoneNum")
    private String phoneNum;

    @ApiModelProperty("性别")
    @TableField("sex")
    private Integer sex;


    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("生日")
    @TableField("birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;

    @ApiModelProperty("个性签名")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty("地址")
    @TableField("location")
    private String location;

    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("创建时间")
    @TableField(value = "createdAt", fill = FieldFill.INSERT,updateStrategy = FieldStrategy.NEVER)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    @ApiModelProperty("修改时间")
    @TableField("updatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;


    public Consumer(Integer id, String username, String password, Integer sex, String phoneNum, String email, Date birth, String introduction, String location, String avatar, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.email = email;
        this.birth = birth;
        this.introduction = introduction;
        this.location = location;
        this.avatar = avatar;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getSex() {
        return sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
