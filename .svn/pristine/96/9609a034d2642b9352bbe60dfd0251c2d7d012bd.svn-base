package com.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.Customer;
import com.crm.domain.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findAllByPage(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize);

	Customer findById(Long cust_id);


	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();


}
