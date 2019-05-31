package com.zero.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.customer.domain.SysUsers;
import com.zero.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
    CustomerService customerService ;
	
	@RequestMapping("/querySysUsersByPrincipal")
	@ResponseBody
	public SysUsers querySysUsersByPrincipal(HttpServletRequest req){
		
		return customerService.querySysUsersByPrincipal(req.getParameter("userAccount"), req.getParameter("password"));
	}
}
