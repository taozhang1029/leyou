package com.kingsley.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author kingsley
 * @time 2022/2/12 19:27
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.gateway.config.LeyouCrosConfiguration
 * @desc 跨域配置类
 */
@Configuration
public class CorsFilterConfiguration {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 设置可以跨域的域名
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        // 设置允许携带cookie，同时需要保证 addAllowedOrigin 的参数不能为*
        corsConfiguration.setAllowCredentials(true);
        // 允许所有请求方法跨域
        corsConfiguration.addAllowedMethod("*");
        // 允许携带所有请求头
        corsConfiguration.addAllowedHeader("*");
        
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // 拦截所有请求，校验是否允许跨域
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }
}
