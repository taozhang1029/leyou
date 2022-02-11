package com.kingsley.leyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kingsley
 * @time 2022/2/11 15:20
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.ServiceStarter
 * @desc 乐优商城微服务启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kingsley.leyou.item.mapper")
public class ServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceStarter.class, args);
    }
}
