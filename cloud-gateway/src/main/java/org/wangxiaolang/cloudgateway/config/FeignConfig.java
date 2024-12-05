package org.wangxiaolang.cloudgateway.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 17:00
 **/
@Configuration
@EnableFeignClients(basePackages = "org.wangxiaolang.api.service")
public class FeignConfig {

    /**
     * WebFlux 的，是 Reactive Web。所以根据 @Conditional 的条件，HttpMessageConvertersAutoConfiguration
     * 就不会生效，进而也不会进行自动配置，就导致容器中缺少 HttpMessageConverters 对象
     * @param converters
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
}