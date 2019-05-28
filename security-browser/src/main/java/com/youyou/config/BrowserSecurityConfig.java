package com.youyou.config;

import com.youyou.component.MyAuthenticationFailureHandler;
import com.youyou.component.MyAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean// 密码加密配置
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// 默认通过这个方法来对密码加密，也可以自定义加密对象
    }

    @Autowired
    public SecurityYml securityYml;// login.html可配置，使用这个类。@Autowired会报错

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override// 自定义安全配置，configure 有三个重载方法
    protected void configure(HttpSecurity http) throws Exception {
        logger.error(securityYml.getBrowserYml().toString());
        logger.error(securityYml.getBrowserYml().getLoginPage());

        http.formLogin() // 表单页面的形式认证，代替httpBasic认证(弹窗)
                .loginPage("/authentication/browser")// 不再是跳转到login.html，而是引导到controller，在里面写逻辑判断
                .loginProcessingUrl("/login/form")// security默认是"/login", "POST", 而且还有csrf的防跨站攻击
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .authorizeRequests()// 下面的都是授权的配置
                .antMatchers("/authentication/browser",securityYml.getBrowserYml().getLoginPage()).permitAll()// 访问这里的url和html不需要身份验证
                .anyRequest()// 所有请求
                .authenticated()// 都需要身份认证
                .and()
                .csrf().disable();// 关闭防跨站攻击 -- Could not verify the provided CSRF token because your session was not found

    }
}
