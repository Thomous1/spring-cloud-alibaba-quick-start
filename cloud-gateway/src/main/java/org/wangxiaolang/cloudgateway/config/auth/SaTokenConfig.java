package org.wangxiaolang.cloudgateway.config.auth;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

import java.util.*;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 15:29
 **/

@Configuration
public class SaTokenConfig {

    /**
     * 注册Sa-Token全局过滤器
     */
    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreUrlsConfig ignoreUrlsConfig) {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")/* 拦截全部path */
                // 配置白名单路径
                .setExcludeList(ignoreUrlsConfig.getUrls())
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    System.out.println("-------- 前端访问path：" + SaHolder.getRequest().getRequestPath());
                    // 权限认证 -- 不同模块, 校验不同权限
                   SaRouter.match("/api/**", r -> StpUtil.checkLogin());
                   SaRouter.match("/provider/**", r -> StpUtil.checkLogin());
                   SaRouter.match("/user/**", r -> StpUtil.checkLogin());
                }).setError(this::handleException);

    }

    /**
     * 自定义异常处理
     */
    private Map handleException(Throwable e) {
        //设置错误返回格式为JSON
        ServerWebExchange exchange = SaReactorSyncHolder.getContext();
        HttpHeaders headers = exchange.getResponse().getHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Cache-Control","no-cache");
        Map result = new HashMap();
        result.put("code", 401);
        if(e instanceof NotLoginException){
            result.put("msg","not login!");
        }else if(e instanceof NotPermissionException){
            result.put("msg","not permission!");
        }else{
            result.put("msg",e.getMessage());
        }
        return result;
    }
}