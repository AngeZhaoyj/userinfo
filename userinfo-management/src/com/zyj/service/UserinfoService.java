package com.zyj.service;

import java.util.List;

import com.zyj.domain.Admin;
import com.zyj.domain.Userinfo;

public interface UserinfoService {

	/**根据账号密码查询用户*/
	public Admin queryForLogin(Admin param);

	/**添加用户*/
	public void addUserinfo(Userinfo u);

	/**修改密码*/
	public void updPassword(Admin a);

	/**根据ID获取用户信息*/
	public Userinfo get(String id);

	/**修改用户*/
	public void update(Userinfo u);

	/**删除用户*/
	public void delete(String id);
	
	/**查询用户*/
	public List<Userinfo> listByCondition(Userinfo u); 

	/**查询用户总数*/
	public int getCount(Userinfo u);

	/**验证账号是否唯一*/
	public int checkCoded(String coded);

	/**验证手机号是否唯一*/
	public int checkTelephone(String telephone);
}
