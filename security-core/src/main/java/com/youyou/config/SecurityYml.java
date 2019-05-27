package com.youyou.config;

import com.youyou.yml.BrowserYml;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by luoxiaoqing
 * 读取文件的配置类
 */
@EnableConfigurationProperties
@ConfigurationProperties("youyou.security")
@Component
@Data
public class SecurityYml {

    private BrowserYml browserYml = new BrowserYml();
}
