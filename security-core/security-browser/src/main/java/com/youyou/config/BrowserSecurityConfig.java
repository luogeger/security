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


        http.formLogin() // 表单页面的形式认证，代替httpBasic认证(弹窗)
                .loginPage("/login.html")
                .loginProcessingUrl("/login/form")// security默认是"/login", "POST", 而且还有csrf的防跨站攻击
        //http.httpBasic()
                .and()
                .authorizeRequests()// 下面的都是授权的配置
                .antMatchers("/login.html").permitAll()// 访问这个页面不需要身份验证
                .anyRequest()
                .authenticated()// 都需要身份认证
                .and().csrf().disable();// 关闭防跨站攻击 -- Could not verify the provided CSRF token because your session was not found

    }
}
