package org.wangxiaolang.cloudgateway.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wangxiaolang.cloudgateway.client.ServiceProviderClient;
import org.wangxiaolang.common.R;
import org.wangxiaolang.dto.User;

import java.util.Objects;


/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 15:49
 **/

@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @GetMapping("/login")
    public SaResult login(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password) {

        User request = new User(username, password);
        R<User> result = serviceProviderClient.login(request);
        User user = result.getData();
        if (Objects.isNull(user)) {
            return SaResult.error("登陆失败！");
        }
        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return SaResult.data(tokenInfo);
    }

    @PostMapping("/register")
    public R login(@RequestBody User user) {
        return serviceProviderClient.register(user);
    }

    @GetMapping("/logout")
    public SaResult login() {
        StpUtil.logout();
        return SaResult.data("登出成功！");
    }


    @GetMapping("/isLogin")
    public SaResult isLogin() {
        Object result = StpUtil.getLoginIdDefaultNull();
        return SaResult.data(Objects.nonNull(result)?"已经登陆！":"未登陆或者token失效！");
    }


}