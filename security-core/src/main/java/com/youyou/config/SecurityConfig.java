package com.youyou.config;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * create by luoxiaoqing
 * 读取所有的配置类
 */
@Data
@Configuration
@EnableConfigurationProperties(SecurityYml.class)
public class SecurityConfig {

}
