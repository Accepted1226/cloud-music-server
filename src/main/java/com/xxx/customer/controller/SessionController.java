package com.xxx.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    HttpServletRequest httpServletRequest;

    /**
     * 创建会话，并给session添加值
     *
     * @return
     */
    @RequestMapping("/set")
    @ResponseBody
    public void set() {
        System.out.println("----初次会话----");
//        获得session,如果没有,自动创建一个
        HttpSession mySession = httpServletRequest.getSession();
        String mySessionId = mySession.getId();

        mySession.setAttribute("phone", "123");

        System.out.println("mySessionId:" + mySessionId);

    }

    /**
     * 浏览器通过cookie和服务端进行第二次会话
     */
    @RequestMapping("/get")
    @ResponseBody
    public void get() {
        System.out.println("----二次会话----");
//        获得session,如果没有，返回null
        HttpSession mySession = httpServletRequest.getSession(false);
        String myCookie = mySession.getId();

        String vCode = (String) mySession.getAttribute("abc");

        System.out.println("myCookie:" + myCookie);
        System.out.println("get-s:" + vCode);
    }


}