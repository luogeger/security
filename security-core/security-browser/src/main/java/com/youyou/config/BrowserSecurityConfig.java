package com.youyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create by luoxiaoqing
 * 自定义安全配置：覆盖security的basic.enable配置
 * 密码加密配置
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean// 密码加密配置
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// 默认通过这个方法来对密码加密，也可以自定义加密对象
    }

    @Override// 自定义安全配置，configure 有三个重载方法
    protected void configure(HttpSecurity http) throws Exception {

        //http.httpBasic()
        http.formLogin() // 表单页面的形式认证，代替httpBasic认证(弹窗)
                .and()
                .authorizeRequests()// 下面的都是授权的配置
                .anyRequest()
                .authenticated();// 都需要身份认证

    }
}
