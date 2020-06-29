package com.cishenn.ccs.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.Realm;

import java.util.LinkedHashMap;
import java.util.Map;

// Notation @Configuration 这是一个配置对象
// spring容器初始化的时候, 创建此bean
@Configuration
public class ShiroConfig {

    // 告诉Spring 调用此方法 返回对象以shiroFilter作为bean保存和引用
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");               // 登陆Url
        shiroFilterFactoryBean.setUnauthorizedUrl("/noRule");       // 未授权的Url


        Map<String, String> map=new LinkedHashMap<>();
        // 可以匿名访问的资源
        map.put("", "anon");
        // 需要登录认证的资源
        map.put("", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(CustomRealm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }

}
