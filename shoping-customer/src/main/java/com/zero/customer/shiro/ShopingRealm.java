package com.zero.customer.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zero.customer.domain.SysUsers;
import com.zero.customer.service.CustomerService;

@Component
public class ShopingRealm extends AuthorizingRealm{
	
	@Autowired 
	CustomerService customerService ;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return new SimpleAuthorizationInfo();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;		
		SysUsers sysUser = new SysUsers();
		
		sysUser.setUserAccount(upToken.getUsername());
		sysUser = (SysUsers) customerService.selectByPrimaryKey(sysUser);
		if(sysUser==null){
			return null ;
		}

		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser.getUserAccount(),sysUser.getPassword(),getName()); 

	    return authenticationInfo;
	}

}
