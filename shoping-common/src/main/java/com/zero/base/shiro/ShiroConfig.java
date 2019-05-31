package com.zero.base.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class ShiroConfig {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	/**
	 * 缓存管理器 使用 Ehcache 实现
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
	//	ehCacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return ehCacheManager;
	}

	@Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("rememberMe");
        simpleCookie.setMaxAge(20000000);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie());
        return cookieRememberMeManager;
    }

    /**
     * 开启MD5加密
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        return matcher;
    }

    /**
     * 自定义Realm密码验证与加密
     * @return
     */
    @Bean
    public SystemRealm systemRealm(){
      SystemRealm customRealm = new SystemRealm();
      customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
      return customRealm;
    }

    /**
     * 创建SecurityManager环境
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(systemRealm());
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    /**
     * Shiro在Web项目中的过滤
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
       
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(getSecurityManager());
        /**
         *  只有在下面配置路径访问权限，Shiro才会执行自动跳转。
         *  如果使用Shiro注解权限，就只会报异常，
         *  就只能采用统一异常处理的方法。
         */
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        
        filterChainDefinitionMap.put("/*", "authc");
        filterChainDefinitionMap.put("/image/*", "anon");
        filterChainDefinitionMap.put("/js/*", "anon");
        filterChainDefinitionMap.put("/css/*", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        filterFactoryBean.setLoginUrl("/login.html");      
        filterFactoryBean.setSuccessUrl("/");
       
        
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterFactoryBean;
    }


    /**
     * 保证Shiro的声明周期
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro授权生效
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        return new AuthorizationAttributeSourceAdvisor();
    }



}
