package com.zero.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Apptest {
	public static void main(String[] args) {
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				 new IniSecurityManagerFactory("classpath:shiro.ini"); 
				 //2、得到 SecurityManager 实例 并绑定给 SecurityUtils 
		          DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance(); 
				 SecurityUtils.setSecurityManager(securityManager); 
				 //3、得到 Subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
				 Subject subject = SecurityUtils.getSubject(); 
				 UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123"); 
				 
				 DefaultSecurityManager defaultSecurityManager = null ;
				 Md5Hash md5Hash = new Md5Hash("123456",null,2);
				 System.out.println(md5Hash.toString());
				 System.out.println(md5Hash.toBase64());
				 try { 
				 //4、登录，即身份验证
				 subject.login(token); 
				 } catch (AuthenticationException e) { 
				 //5、身份验证失败
				 } 
			//	 Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
				 //6、退出
				 subject.logout();
	}
}
