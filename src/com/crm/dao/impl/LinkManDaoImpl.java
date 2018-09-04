package com.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.dao.LinkManDao;
import com.crm.domain.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {
	
	public LinkManDaoImpl() {
		//去调用父类的构造
		super(LinkMan.class);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 保存联系人信息
	 */
/*	@Override
	public void save(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
		
	}*/
	/**
	 * 查找联系人总记录数
	 */
/*	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0)
			return list.get(0).intValue();
		return null;
	}*/
	/**
	 * 分页查询联系人
	 */
/*	@Override
	public List<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//清除数据
		detachedCriteria.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}*/
	/**
	 * 根据ID，查询联系人
	 */
	/*@Override
	public LinkMan findById(Long lkm_id) {
		LinkMan linkMan = this.getHibernateTemplate().get(LinkMan.class, lkm_id);
		return linkMan;
	}*/
/*	@Override
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}*/
	/**
	 * 删除联系人的所有信息
	 */
/*	@Override
	public void delete(LinkMan linkMan) {
		this.getHibernateTemplate().delete(linkMan);
	}*/


}
