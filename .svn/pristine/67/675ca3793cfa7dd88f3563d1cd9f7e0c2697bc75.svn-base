package com.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * Í¨ÓÃµÄDao
 * @author Áº´ä´ä
 *
 */
public interface BaseDao<T> {
	
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T findById(Serializable id);
	public Integer findCount(DetachedCriteria detachedCriteria);
	public T findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);
	public List<T> findAll();
}
