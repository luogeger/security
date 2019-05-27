package com.youyou.config;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * create by luoxiaoqing
 * 读取所有的配置类
 */
@Data
@EnableConfigurationProperties(SecurityYml.class)
public class SecurityConfig {

}
