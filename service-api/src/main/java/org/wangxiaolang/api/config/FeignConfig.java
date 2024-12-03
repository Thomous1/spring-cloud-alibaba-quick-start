package org.wangxiaolang.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 17:00
 **/
@Configuration
@EnableFeignClients(basePackages = "org.wangxiaolang.api.service")
public class FeignConfig {
}