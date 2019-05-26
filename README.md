

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
     