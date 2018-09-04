package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.domain.PageBean;
import com.crm.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}
	/**
	 * 分页查询客户
	 */
	@Override
	public PageBean<Customer> findAllByPage(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示条数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double countValue = totalCount.doubleValue();
		Double totalPage = Math.ceil(countValue/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//封装查询到的数据
		Integer begin = (currPage-1)*pageSize;
		List<Customer> list = (List<Customer>) customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Customer findById(Long cust_id) {
		
		return customerDao.findById(cust_id);
	}
	/**
	 * 删除客户
	 */
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	/**
	 * 查询所有用户
	 */
	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}
	
	

}
