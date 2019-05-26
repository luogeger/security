package com.youyou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * create by luoxiaoqing
 * 覆盖security的basic.enable配置
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override// configure 有三个重载方法
    protected void configure(HttpSecurity http) throws Exception {

        //http.formLogin() // 表单页面的形式认证，代替httpBasic认证(弹窗)
        http.httpBasic()
                .and()
                .authorizeRequests()// 下面的都是授权的配置
                .anyRequest()
                .authenticated();// 都需要身份认证

    }
}
