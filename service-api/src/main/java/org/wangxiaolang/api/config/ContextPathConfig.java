package org.wangxiaolang.api.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.WebFilter;

/**
 * @description: 由于spring-boot-starter-webfulx 的依赖 和 spring-boot-starter-web
 *     依赖有所冲突，所以去掉 spring-boot-starter-web 的gateway项目的启动容器是Netty ，所以我们在application.yml中
 *     的server.servlet.context-path属性是没用的，所以我们采用webFilter的方式来强行处理它
 * @author: zuoyuwang
 * @create: 2024年12月04日 16:59
 **/
@Configuration
public class ContextPathConfig {

    @Bean
    @ConditionalOnProperty("server.servlet.context-path")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public WebFilter contextPathWebFilter(ServerProperties serverProperties){
        String contextPath = serverProperties.getServlet().getContextPath();

        return (serverWebExchange, webFilterChain) ->{
            ServerHttpRequest request = serverWebExchange.getRequest();
            String requestPath = request.getURI().getPath();

            if(requestPath.contains(contextPath)){
                String newPath = requestPath.replaceFirst(contextPath, "");
                ServerHttpRequest newRequest = request.mutate()
                        .path(newPath).build();
                return webFilterChain.filter(serverWebExchange.mutate()
                        .request(newRequest)
                        .build()
                );
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        };
    }
}