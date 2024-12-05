package org.wangxiaolang.cloudgateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description: 记录gateway 请求记录
 * @author: zuoyuwang
 * @create: 2024年12月04日 14:26
 **/
@Component
@Order(-1)
public class RequestLoggingFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        log.info("Method: {}, URL: {}", request.getMethod(), request.getURI());
        // 打印请求头信息
        //request.getHeaders().forEach((key, value) -> log.info("{}: {}", key, value));

        // 可以打印请求体等更详细的信息，但是需注意，这里可能会导致请求体流的冲突
        // 如果确实需要打印请求体，可以使用如下方式：
        // DataBufferUtils.join(exchange.getRequest().getBody()).flatMap(dataBuffer -> {
        //     byte[] bytes = new byte[dataBuffer.readableByteCount()];
        //     dataBuffer.read(bytes);
        //     DataBufferUtils.release(dataBuffer);
        //     String body = new String(bytes, StandardCharsets.UTF_8);
        //     log.info("Request Body: {}", body);
        //     ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(request) {
        //         @Override
        //         public Flux<DataBuffer> getBody() {
        //             return Flux.just(buffer(bytes));
        //         }
        //     };
        //     return chain.filter(exchange.mutate().request(mutatedRequest).build());
        // });

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
            // 打印响应状态码和头信息
            log.info("Response Status code: {}, Headers: {}", response.getStatusCode(), response.getHeaders());
            // 如果需要打印响应体，可以在这里添加代码
        }));
    }
}