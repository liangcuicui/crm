package com.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{


//	void save(Customer customer);

//	Integer findCount(DetachedCriteria detachedCriteria);

//	List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

//	Customer findById(Long cust_id);

//	void delete(Customer customer);

//	void update(Customer customer);

	List<Customer> findAll();
}
