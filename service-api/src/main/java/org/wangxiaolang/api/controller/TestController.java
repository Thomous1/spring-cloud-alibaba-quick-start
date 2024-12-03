package org.wangxiaolang.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wangxiaolang.api.service.TestServiceClient;


/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 14:52
 **/
@RestController
public class TestController {

    @Autowired
    private TestServiceClient testServiceClient;

    @GetMapping("/test")
    public String test(@RequestParam(name = "name") String name) {
        return testServiceClient.test(name);
    }
}