package com.youyou.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * create by luoxiaoqing
 * 自定义获取用户信息的配置类
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired// 密码解密：注入来源于BrowserSecurityConfig
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username: " + username);
        // 根据用户名查找用户信息
        //return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        // 通过用户信息判断用户是否过期, 这里返回的对象非必须是User对象，只要是UserDetails的实现类就可以，
        String password = passwordEncoder.encode("123");// 相当于是从后数据拿到的加密后的密码
        logger.info("数据库密码： "+ password);
        return new User(username,password, true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(""));

    }
}
