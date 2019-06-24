package com.zero.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zero.customer.domain.SysUsers;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="/userLogin",method = RequestMethod.POST)
	public String userLogin(HttpServletRequest req){
		String userAccount = req.getParameter("userAccount");
		String password = req.getParameter("password");
	//	Subject user = SecurityUtils.getSubject();
	//	AuthenticationToken token = new UsernamePasswordToken(userAccount,password);
	//	user.login(token);
		
		
		return "page/index";
	}
	
}
