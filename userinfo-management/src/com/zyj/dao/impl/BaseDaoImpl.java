package com.zyj.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyj.dao.BaseDao;

/**
 * @author 赵云娇
 * @description 公共的dao
 */
@Repository("baseDao")
public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
	@Autowired

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/**添加，默认id是add*/
	public void add(Class<?> cl,Object o){
		getSqlSession().insert(cl.getName()+".add",o);
	}

	/**查看，默认id是list*/
	public List<?> list(Class<?> cl){
		return getSqlSession().selectList(cl.getName()+".list");
	}
	
	/**查看，带条件查询*/
	public List<?> list(Class<?> cl,String mapperId,Object param){
		return getSqlSession().selectList(cl.getName()+"."+mapperId,param);
	}

	/**修改，默认id是edit*/
	public void update(Class<?> cl,Object o){
		getSqlSession().update(cl.getName()+".edit",o);
	}

	/**修改，自定义id*/
	public void update(Class<?> cl,String mapperId,Object o){
		getSqlSession().update(cl.getName()+"."+mapperId,o);
	}
	
	/**删除，默认id是delete*/
	public void delete(Class<?> cl,String id){
		getSqlSession().delete(cl.getName()+".delete",id);
	}
	
	/**根据id，查询一条数据，默认id是get*/
	public Object get(Class<?> cl,String id){
		return getSqlSession().selectOne(cl.getName()+".get",id);
	}

	/**根据条件，查询一条数据，自定义id*/
	public Object query(Class<?> cl,String mapperId,Object param){
		return getSqlSession().selectOne(cl.getName()+"."+mapperId,param);
	}

	/**根据条件，查询一条数据，自定义id*/
	public int queryOne(Class<?> cl,String mapperId,Object param){
		return getSqlSession().selectOne(cl.getName()+"."+mapperId,param);
	}

}
