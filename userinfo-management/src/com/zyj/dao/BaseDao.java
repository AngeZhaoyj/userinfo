package com.zyj.dao;

import java.util.List;

public interface BaseDao {

	/**添加，默认id是add*/
	public void add(Class<?> cl,Object o);

	/**查看，默认id是list*/
	public List<?> list(Class<?> cl);

	/**查看，带条件查询*/
	public List<?> list(Class<?> cl,String mapperId,Object param);

	/**修改，默认id是edit*/
	public void update(Class<?> cl,Object o);

	/**修改，自定义id*/
	public void update(Class<?> cl,String mapperId,Object o);

	/**删除，默认id是delete*/
	public void delete(Class<?> cl,String id);
	
	/**根据id，查询一条数据，默认id是get*/
	public Object get(Class<?> cl,String id);

	/**根据条件，查询一条数据，自定义id*/
	public Object query(Class<?> cl,String mapperId,Object param);

	/**根据条件，查询一条数据，自定义id*/
	public int queryOne(Class<?> cl,String mapperId,Object param);
}
