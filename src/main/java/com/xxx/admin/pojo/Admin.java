package com.xxx.admin.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "管理员实体类", description = "管理员信息描述类")
public class Admin {
    @ApiModelProperty(value = "管理员id")
    private Integer id;
    @ApiModelProperty(value = "管理员姓名")
    private String name;
    @ApiModelProperty(value = "管理员密码")
    private String password;
}
