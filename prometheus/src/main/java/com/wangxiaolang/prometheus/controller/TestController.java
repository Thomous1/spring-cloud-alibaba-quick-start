package com.wangxiaolang.prometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ZuoYu Wang
 * @create: 2024年12月25日 16:20
 **/
@RestController
public class TestController {


    @GetMapping("/test")
    public String test(@RequestParam(name = "tag") String tag,@RequestParam(name = "value") String value) {
        Metrics.addRegistry(new SimpleMeterRegistry());
        Counter counter = Metrics.counter("wangxiaolang_test_qps", tag, value);
        counter.increment();
        return "success";
    }

}