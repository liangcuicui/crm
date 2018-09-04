package com.crm.dao.impl;


import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	
	public CustomerDaoImpl() {
		super(Customer.class);
	}
	/**
	 * 保存用户
	 *//*
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}*/
	/**
	 * 查询总记录数,带条件的哟，比如说，姓氏，性别，，，，
	 */
	/*@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//类似select count(*) from ... where ...
		detachedCriteria.setProjection(Projections.rowCount());
		 List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		 if(list.size()>0)
			 return list.get(0).intValue();
		return null;
	}*/
	/**
	 * 分页查询客户
	 */
	/*@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//清理数据,findCount中的，默认查所有
		detachedCriteria.setProjection(null);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}*/
	/**
	 * 根据客户ID，查找客户
	 */
	/*@Override
	public Customer findById(Long cust_id) {
		Customer customer = this.getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}*/
	/**
	 * 查询之后，删除客户
	 *//*
	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}
	*//**
	 * 更新用户
	 *//*
	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);;
	}*/
	/*@Override
	public List<Customer> findAll() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}
*/


}
