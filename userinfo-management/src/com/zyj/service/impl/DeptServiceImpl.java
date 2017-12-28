package com.zyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.dao.BaseDao;
import com.zyj.domain.Dept;
import com.zyj.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private BaseDao baseDao;
	
	/**查询所有组织机构*/
	@SuppressWarnings("unchecked")
	public List<Dept> listDept(){
		return (List<Dept>)baseDao.list(Dept.class);
	} 

	/**添加机构*/
	public void addDept(Dept d){
		baseDao.add(Dept.class, d);
	}

	/**根据ID获取机构信息*/
	public Dept get(String id){
		return (Dept)baseDao.get(Dept.class, id);
	}

	/**修改机构*/
	public void update(Dept d){
		baseDao.update(Dept.class, d);
	}

	/**删除机构*/
	public void delete(String id){
		baseDao.delete(Dept.class, id);
	}
	
	/**查询机构*/
	@SuppressWarnings("unchecked")
	public List<Dept> listByCondition(Dept d){
		return (List<Dept>)baseDao.list(Dept.class, "listByCondition", d);
	} 

	/**查询机构总数*/
	public int getCount(Dept d){
		int count = baseDao.queryOne(Dept.class, "count", d);
		return count;
	} 

}
