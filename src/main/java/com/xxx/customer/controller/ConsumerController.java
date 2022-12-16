package com.xxx.customer.controller;


import com.alibaba.fastjson.JSONObject;
import com.xxx.common.*;
import com.xxx.constant.Constants;
import com.xxx.customer.pojo.Consumer;
import com.xxx.customer.service.impl.ConsumerServiceImpl;
import com.xxx.util.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@RestController
@Api("用户控制层")
public class ConsumerController {

    @Autowired
    private ConsumerServiceImpl consumerService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/avatarImages/**")
                    .addResourceLocations(Constants.AVATAR_IMAGES_PATH);
        }
    }

    // 返回所有用户
    @ApiOperation(value = "返回所有用户")
    @GetMapping("/user")
    public Object allUser() {
        return new SuccessMessage<List<Consumer>>(null, consumerService.allUser()).getMessage();
    }


    // 返回指定 ID 的用户
    @ApiOperation(value = "返回指定 ID 的用户")
    @GetMapping("/user/detail")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "Int")
    public Object userOfId(@NotNull@RequestParam(value = "id")Integer id) {
        return new SuccessMessage<Consumer>(null, consumerService.userOfId(id)).getMessage();
    }

    // 返回自己的信息
    @ApiOperation(value = "返回指定 ID 的用户")
    @GetMapping("/user/self")
    public Object userOfId(HttpServletRequest request) {
        HttpSession session= request.getSession();
        String userId=session.getAttribute("id").toString();
        int id=Integer.parseInt(userId);
        return new SuccessMessage<Consumer>(null, consumerService.userOfId(id)).getMessage();
    }


    // 更新用户信息
    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Object updateUserMsg(HttpServletRequest req) {
        String id = req.getParameter("id").trim();
        String username = req.getParameter("username").trim();
        String sex = req.getParameter("sex").trim();
        String phoneNum = req.getParameter("phoneNum").trim();
        String email = req.getParameter("email").trim();
        String birth = req.getParameter("birth").trim();
        String introduction = req.getParameter("introduction").trim();
        String location = req.getParameter("location").trim();
        // System.out.println(username);

        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.setId(Integer.parseInt(id));
        consumer.setUsername(username);
        consumer.setSex(Integer.valueOf(new Byte(sex)));
        consumer.setPhoneNum(phoneNum);
        consumer.setEmail(email);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setUpdatedAt(new Date());
        consumer.setBirth(myBirth);

        boolean res = consumerService.updateUserMsg(consumer);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

    // 删除用户
    @ApiOperation(value = "删除用户")
    @GetMapping("/user/delete")
    public Object deleteUser(Integer id) {
        boolean res = consumerService.deleteUser(id);
        if (res) {
            return new SuccessMessage<ObjectUtils.Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }

    }


    // 登录
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/v1/sessions", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码（6到20位）", required = true, dataType = "String")})
    public Object loginStatus(HttpServletRequest request, @NotNull@RequestParam("phone")String phone,
                              @NotNull@RequestParam("password")@Size(max=20,min=6)String password) {

        boolean res = consumerService.verifyPassword(phone,PasswordUtil.convert(password));
        if (res) {
            JSONObject data=new JSONObject();
            Integer id=consumerService.selectUserByPhone(phone);
            data.put("id",id);
            HttpSession mySession = httpServletRequest.getSession();
            String mySessionId = mySession.getId();
            mySession.setAttribute("id",id);
            System.out.println("mySessionId:" + mySessionId);
            data.put("token",mySessionId);
            System.out.println("data"+data);
            return new SuccessMessage<JSONObject>(data).getMessage();
            //SuccessMessage<ObjectUtils.Null>("注册成功").getMessage();
            //return new SuccessMessage<List<Consumer>>("登录成功", consumerService.loginStatus(username)).getMessage();
        } else {
            return new ErrorMessage("用户名或密码错误").getMessage();
        }
    }


    // 注册
    @ApiOperation(value = "注册")
    @RequestMapping(value = "/v1/users", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname", value = "用户名（3到20个字符）", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机号",required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码（6到20位）", required = true, paramType = "query", dataType = "String")})
    public Object addUser(@NotNull@RequestParam("nickname")@Size(max=20,min=2)String username,
                          @NotNull@RequestParam("phone")String phone,
                          @NotNull@RequestParam("password")@Size(max=20,min=6)String password) {
        if (!phone.matches("1[3-9]\\d{9}")) {
            return new WarningMessage("手机号格式不正确").getMessage();
    }
//        String sex = req.getParameter("sex").trim();
//        String phone_num = req.getParameter("phone_num").trim();
//        String email = req.getParameter("email").trim();
//        String birth = req.getParameter("birth").trim();
//        String introduction = req.getParameter("introduction").trim();
//        String location = req.getParameter("location").trim();
        String avatar = "/img/avatarImages/user.jpg";

        if(consumerService.existUser(phone)) {
            return new WarningMessage("手机号已注册").getMessage();
        }
        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        consumer.setPhoneNum(phone);
        consumer.setPassword(PasswordUtil.convert(password));
        consumer.setUsername(username);

        consumer.setAvatar(avatar);
        consumer.setCreatedAt(new Date());
        consumer.setUpdatedAt(new Date());

        try {
           int res = consumerService.addUser(consumer);
            if (res>0) {
                JSONObject data=new JSONObject();
                Integer id=consumerService.selectUserByPhone(phone);
                data.put("id",id);
                return new SuccessMessage<JSONObject>(data).getMessage();
                        //SuccessMessage<ObjectUtils.Null>("注册成功").getMessage();
            } else {
                return new ErrorMessage("注册失败").getMessage();
            }
        } catch (DuplicateKeyException e) {
            return new FatalMessage(e.getMessage()).getMessage();
        }
    }

    // 用户更新密码
    @ApiOperation(value = "用户更新密码")
    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.POST)
    public Object updatePassword(HttpServletRequest req) {
        String id = req.getParameter("id").trim();
        String username = req.getParameter("username").trim();
        String old_password = req.getParameter("old_password").trim();
        String password = req.getParameter("password").trim();

        boolean res = consumerService.verifyPassword(username, PasswordUtil.convert(old_password));
        if (!res) {
            return new ErrorMessage("密码输入错误").getMessage();
        }

        Consumer consumer = new Consumer();
        consumer.setId(Integer.parseInt(id));
        consumer.setPassword(password);

        boolean result = consumerService.updatePassword(consumer);
        if (result) {
            return new SuccessMessage<ObjectUtils.Null>("密码修改成功").getMessage();
        } else {
            return new ErrorMessage("密码修改失败").getMessage();
        }
    }

    // 用户更新头像 C3E0C40AB2B3BA4507B45C26453FB3DB
    @ApiOperation(value = "用户更新头像")
    @RequestMapping(value = "/user/avatar/update", method = RequestMethod.POST)
    public Object updateUserPic(@RequestParam("file") MultipartFile avatarFile,HttpServletRequest request) {
        HttpSession session=request.getSession();
        String idString=session.getAttribute("id").toString();
        int id= Integer.parseInt(idString);
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "avatarImages";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String imgPath = "/img/avatarImages/" + fileName;
        try {
            avatarFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvatar(imgPath);
            boolean res = consumerService.updateUserAvatar(consumer);
            if (res) {
                return new SuccessMessage<String>("上传成功", imgPath).getMessage();
            } else {
                return new ErrorMessage("上传失败").getMessage();
            }
        } catch (IOException e) {
            return new FatalMessage("上传失败" + e.getMessage()).getMessage();
        }
    }

}

