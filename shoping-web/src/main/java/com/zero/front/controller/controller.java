package com.zero.front.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.hash.Md5Hash;
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
	
	
	
	
	@RequestMapping("deteleCustomer")
	@ResponseBody
	public String deteleCustomer() throws Exception{
	//	remoteService.call();
		return "hehe";
	}
	
	@RequestMapping("addCustomer")
	@ResponseBody
	public Object addCustomer(SysUserInfo sysUserInfo){
		
		customerService.saveOrUpdate(sysUserInfo);
		
		return null ;
	}
}
