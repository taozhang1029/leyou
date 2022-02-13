package com.kingsley.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kingsley
 * @time 2022/2/12 22:15
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.UploadStarter
 * @desc 乐优商城文件上传启动器
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UploadStarter {
    
    public static void main(String[] args) {
        SpringApplication.run(UploadStarter.class, args);
    }
    
}
