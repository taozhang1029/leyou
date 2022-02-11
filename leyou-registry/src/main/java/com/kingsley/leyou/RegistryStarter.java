package com.kingsley.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author kingsley
 * @time 2022/2/11 13:45
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.RegistryStarter
 * @desc 乐优商城注册中心启动类
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryStarter {
    public static void main(String[] args) {
        SpringApplication.run(RegistryStarter.class, args);
    }
}
