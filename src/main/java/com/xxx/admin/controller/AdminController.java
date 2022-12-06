package com.xxx.admin.controller;

import com.xxx.admin.pojo.Admin;
import com.xxx.admin.service.impl.AdminServiceImpl;
import com.xxx.common.ErrorMessage;
import com.xxx.common.SuccessMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Api("管理员控制层")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    // 验证用户登录
    @ApiOperation(value = "验证用户登录")
    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Object getLogin(String name, String password, HttpSession session){
//          将用户在前端页面中输入的密码进行MD5加密
//           pwd= MD5Util.MD5(pwd);
        Admin admin = adminService.getLogin(name, password);
        if(admin!=null){
            // 登录成功则返回用户信息
            session.setAttribute("name", name);
            return  new SuccessMessage<ObjectUtils.Null>("登录成功").getMessage();
        }else {
            // 登录失败
            return new ErrorMessage("用户名或密码错误").getMessage();
        }
    }
}
