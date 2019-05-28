package com.youyou.config;

import com.youyou.yml.BrowserYml;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * create by luoxiaoqing
 * 读取文件的配置类
 */
@Data
@ConfigurationProperties("youyou.security")
public class SecurityYml {

    private BrowserYml browserYml = new BrowserYml();
}
