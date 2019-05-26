

### 4-2 覆盖httpBasic及基本原理

> Filter

- `UsernamePasswordAuthenticationFilter`
- `BasicAuthenticationFilter`
- // ....

> Exception


> FilterSecurityInterceptor

### 4-3 自定义用户认证逻辑

> 如何获取用户信息

```markdown
`Spring-Security`获取用户名的逻辑是封装这个接口后面的，`interface UserDetailsService`, 里面只有一个方法
`UserDetails loadUserByUsername(String username) throws UsernameNotFoundException`
通过这个方法：把前端传来的用户名到数据查到后，把数据封装到`UserDeatils`的某个实现类，并且返回。
`Security`会拿着这个数据做校验，校验通过以后就把这个用户存到到`Session`里面，就是登陆成功了。
如果找不到这个用户就会抛出异常。
```

> 校验

```markdown
    返回的对象非必须是User对象，只要是UserDetails的实现类就可以

    `username`
    `password`: 数据库存的密码
    `enabled`: 是否删除
    `accountNonExpired`: 账户是否过期
    `accountNonLocked`: 是否锁定
    `credentialsNonExpired`: 密码是否过期
    `authorities`: 用户的权限，返回当前用户拥有哪些权限，然后到安全配置(BrowserSecurityConfig)里面去验证用户的权限，
```

> 密码的加密解密过程

```markdown
    处理加密解密的过程在 `interface PasswordEncoder`里
```


### 4-12
    
- `ValidateCodeFilter` 验证码过滤器
- `BrowserSecurity`    
- `interface SecurityConstants` 常量

### 5-1

> OAuth协议简介
    
- 协议要解决的问题
    - app可以访问用户在微信上的所有数据
    - 用户只有修改密码，才能收回授权，(可能授权给其他程序了)
    - 密码泄露的可能性大大提高
    - 解决方案：
        - 用户只是给app一个`token`, `token`有有效期, 用户根本就没有泄露密码

- 协议中的各种角色
    - `Provider`: 服务提供商，提供`token`
        - `Authorization Server` 认证服务器：认证用户身份，提供`token`
        - `Resource Server` 资源服务器：验证`token`, 存放用户数据
    - `Resource Owner`: 资源所有者, 就是用户
    - `Client`: 第三方app

- 协议运行流程    
     