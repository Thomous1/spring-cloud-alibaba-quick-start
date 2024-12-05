package org.wangxiaolang.cloudgateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.wangxiaolang.common.R;
import org.wangxiaolang.dto.User;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 18:44
 **/

@FeignClient(name = "service-provider",path = "/provider", url = "http://localhost:9093")
public interface ServiceProviderClient {

    @PostMapping("/user/login")
    R<User> login(@RequestBody User user);

    @PostMapping("/user/register")
    R register(@RequestBody User user);
}