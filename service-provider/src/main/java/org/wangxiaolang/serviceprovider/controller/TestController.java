package org.wangxiaolang.serviceprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wangxiaolang.serviceprovider.service.TestService;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 16:01
 **/
@RestController
@RequestMapping("/feign")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(@RequestParam(name = "name") String name) {
        return testService.test(name);
    }
}