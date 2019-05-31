package com.zero.customer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.zero.base.service.BaseService;
import com.zero.customer.domain.SysUserInfo;
import com.zero.customer.domain.SysUsers;
import com.zero.customer.persistence.SysUsersMapper;

@Service
public class CustomerService extends BaseService{
public Page<SysUserInfo> queryCustomerForList(){
	this.selectList(new HashMap<String, String>());
	return null ;
}

public SysUsers querySysUsersByPrincipal(String userAccount ,String password){
	Map<String,Object> paramMap = new HashMap<String, Object>(5);
	paramMap.put("userAccount", userAccount);
	paramMap.put("password", password);
	paramMap.put(SQL_ID, SysUsersMapper.class.getName()+".querySysUsersByPrincipal");
	//return (SysUsers) this.selectOne(paramMap);
	return null;
}

}
