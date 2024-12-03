package org.wangxiaolang.serviceprovider.service.impl;

import org.springframework.stereotype.Service;
import org.wangxiaolang.serviceprovider.service.TestService;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 14:48
 **/

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test(String name) {
        return "feign:" + name;
    }
}