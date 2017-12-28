package com.zyj.service;

import java.util.List;

import com.zyj.domain.Dept;

public interface DeptService {

	/**查询所有组织机构*/
	public List<Dept> listDept(); 

	/**添加机构*/
	public void addDept(Dept d);

	/**根据ID获取机构信息*/
	public Dept get(String id);

	/**修改机构*/
	public void update(Dept d);

	/**删除机构*/
	public void delete(String id);
	
	/**查询机构*/
	public List<Dept> listByCondition(Dept d); 

	/**查询机构总数*/
	public int getCount(Dept d);
}
