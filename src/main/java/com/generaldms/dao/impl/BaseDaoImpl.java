package com.generaldms.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.generaldms.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(T o) {
		// TODO Auto-generated method stub
		
	}

	public void update(T o) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeHql(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeHql(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeHql(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
