package com.zero.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.base.util.RestTemplateUtil;
import com.zero.base.util.UUIDUtil;
import com.zero.customer.domain.SysUserInfo;
import com.zero.customer.domain.SysUsers;
import com.zero.customer.persistence.SysUserInfoMapper;
import com.zero.customer.persistence.SysUsersMapper;
import com.zero.customer.service.CustomerService;
import com.zero.front.service.RemoteService;

@Controller
public class controller {

	@Autowired
	CustomerService customerService ;
	
	@Autowired
	SecurityManager securityManager ;
	
	
	@RequestMapping("deteleCustomer")
	@ResponseBody
	public String deteleCustomer(HttpServletResponse res) throws Exception{
	//	remoteService.call();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject(); 
		Session session = subject.getSession();
		System.out.println(session.getId());
		System.out.println(Thread.currentThread().getName());
		
		return "hehe";
	}
	
	@RequestMapping("addCustomer")
	@ResponseBody
	public Object addCustomer(SysUserInfo sysUserInfo){
		
	//	customerService.saveOrUpdate(sysUserInfo);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject(); 
		Session session = subject.getSession();
		System.out.println(session.getId());
		System.out.println(Thread.currentThread().getName());
		
		return null ;
	}
}
