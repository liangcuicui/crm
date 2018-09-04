package com.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport  implements BaseDao<T>{

	private Class clazz;
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}
	/**
	 * 更新
	 */
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}
	public BaseDaoImpl(Class clazz){
		this.clazz = clazz;
	}
	/**
	 * 根据ID查找
	 */
	@Override
	public T findById(Serializable id) {
		
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	/**
	 * 查找出一共有多少条记录
	 */
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0)
			return list.get(0).intValue();
		return null;
	}
	/**
	 * 分页查询
	 */
	@Override
	public T findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//清除数据
		detachedCriteria.setProjection(null);
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return (T) list;
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<T> findAll() {
		List<T> list = (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
		return list;
	}
	
}
