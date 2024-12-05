package org.wangxiaolang.serviceprovider.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wangxiaolang.common.R;
import org.wangxiaolang.dto.User;
import org.wangxiaolang.serviceprovider.entity.UsersDO;
import org.wangxiaolang.serviceprovider.service.UsersService;
import util.Assert;

import java.util.List;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 17:38
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;
    @PostMapping("/login")
    public R<User> login(@RequestBody User user) {
        Assert.notNull(user, "请求requestBody不能为空！");
        Assert.notNull(user.getUsername(), "用户名不能为空！");
        Assert.notNull(user.getPassword(), "密码不能为空！");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", user.getUsername());
        List<UsersDO> list = usersService.list(queryWrapper);
        Assert.notEmpty(list, "用户不存在！");
        UsersDO UsersDO = list.get(0);
        Assert.isTrue(BCrypt.checkpw(user.getPassword(), UsersDO.getPassword()), "密码错误！");
        User result = new User();
        BeanUtil.copyProperties(UsersDO, result);
        return R.success(result);
    }

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        Assert.notNull(user, "请求requestBody不能为空！");
        Assert.notNull(user.getUsername(), "用户名不能为空！");
        Assert.notNull(user.getPassword(), "密码不能为空！");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", user.getUsername());
        List<UsersDO> list = usersService.list(queryWrapper);
        Assert.isTrue(CollectionUtils.isEmpty(list), "用户已存在！");
        UsersDO UsersDO = new UsersDO();
        UsersDO.setUsername(user.getUsername());
        UsersDO.setPassword(BCrypt.hashpw(user.getPassword()));
        usersService.save(UsersDO);
        return R.success("注册成功！");
    }
}