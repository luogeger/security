package com.youyou.yml;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * create by luoxiaoqing
 * 浏览器端文件读取类
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrowserYml {

    /** 没有权限访问时需要跳转的页面 */
    private String  loginPage = "/login.html";

    /** 后端是redirect还是返回json*/
    private LoginType loginType = LoginType.JSON;

}
