package org.wangxiaolang.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wangxiaolang.api.fallback.TestFallBack;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 14:59
 **/

@FeignClient(name = "service-provider",path = "/provider",
        fallback = TestFallBack.class ,dismiss404 = true ,url = "http://localhost:9093")
public interface TestServiceClient {

    @GetMapping("/feign/test")
    String test(@RequestParam(name = "name") String name);
}