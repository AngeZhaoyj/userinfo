package com.zyj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.dao.BaseDao;
import com.zyj.domain.Admin;
import com.zyj.domain.Userinfo;
import com.zyj.service.UserinfoService;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private BaseDao baseDao;
	
	/**根据账号密码查询用户*/
	public Admin queryForLogin(Admin param){
		return (Admin)baseDao.query(Admin.class, "queryForLogin", param);
	}
	
	/**添加用户*/
	public void addUserinfo(Userinfo u){
		Date now = new Date();
		u.setGmt_create(now);
		baseDao.add(Userinfo.class, u);
	}

	/**修改密码*/
	public void updPassword(Admin a){
		baseDao.update(Userinfo.class, "updPassword", a);
	}

	/**根据ID获取用户信息*/
	public Userinfo get(String id){
		return (Userinfo)baseDao.get(Userinfo.class, id);
	}

	/**修改用户*/
	public void update(Userinfo u){
		baseDao.update(Userinfo.class, u);
	}

	/**删除用户*/
	public void delete(String id){
		baseDao.delete(Userinfo.class, id);
	}
	
	/**查询用户*/
	@SuppressWarnings("unchecked")
	public List<Userinfo> listByCondition(Userinfo u){
		return (List<Userinfo>)baseDao.list(Userinfo.class, "listByCondition", u);
	} 

	/**查询用户总数*/
	public int getCount(Userinfo u){
		int count = baseDao.queryOne(Userinfo.class, "count", u);
		return count;
	} 

	/**验证编号是否唯一*/
	public int checkCoded(String coded){
		return baseDao.queryOne(Userinfo.class, "checkCoded", coded);
	}

	/**验证手机号是否唯一*/
	public int checkTelephone(String telephone){
		return baseDao.queryOne(Userinfo.class, "checkTelephone", telephone);
	}
}
