package com.llxk.xkapiinterface.controller;

import com.llxk.xkapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * ClassName: NameController
 * Package: com.llxk.xkapiinterface.controller
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc 名称API
 * @Date 2023/8/24 21:25
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(String name){

        return "GET:你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "POST:你的名字是" + name;
    }

    @PostMapping("/user")
    public String getNameByPost(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
        /*String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = URLDecoder.decode(request.getHeader("body"), "utf-8");

        //TODO 实际情况应该是数据库中查是否已分配给用户
        if(!"llxk".equals(accessKey)){
            throw new RuntimeException("无权限");
        }
        //TODO 随机数
        if(Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }

        //TODO 时间和当前时间不能超过5分钟
        *//*if(timestamp){

        }*//*
        //TODO 实际需要从数据库中查出secretKey
        String serverSign = SignUtils.getSign(body, "abcdefgh");
        if(!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }*/

        String result = "Post: 用户名是" + user.getUsername();
        //调用成功后

        return result;
    }


}
