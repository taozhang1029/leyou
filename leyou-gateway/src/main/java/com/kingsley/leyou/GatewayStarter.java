package com.kingsley.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author kingsley
 * @time 2022/2/11 14:14
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.GatewayStarter
 * @desc 乐优商城网关启动类
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStarter.class, args);
    }
}
