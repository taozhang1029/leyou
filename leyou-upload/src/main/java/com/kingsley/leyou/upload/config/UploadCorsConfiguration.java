package com.kingsley.leyou.upload.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kingsley
 * @time 2022/2/12 23:40
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.upload.config.UploadCorsConfiguration
 * @desc 文件上传服务跨域配置
 */
@Configuration
public class UploadCorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("http://manage.leyou.com");
    }
}
