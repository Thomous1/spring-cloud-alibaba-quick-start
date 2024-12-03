package org.wangxiaolang.api.fallback;

import org.springframework.stereotype.Component;
import org.wangxiaolang.api.service.TestServiceClient;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月03日 16:09
 **/
@Component
public class TestFallBack implements TestServiceClient {
    @Override
    public String test(String name) {
        return "this is fallback :" + name;
    }
}