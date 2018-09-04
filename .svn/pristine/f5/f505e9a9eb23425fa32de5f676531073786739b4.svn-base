package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.VisitDao;
import com.crm.domain.PageBean;
import com.crm.domain.Visit;
import com.crm.service.VisitService;
@Transactional
public class VisitServiceImpl implements VisitService {
	private VisitDao visitDao;
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageBean<Visit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<Visit> pageBean = new PageBean<>();
		//当前页
		pageBean.setCurrPage(currPage);
		//每页显示多少数据
		pageBean.setPageSize(pageSize);
		//一共多少条记录
		Integer totalCount = visitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//一共多少页
		Double total = totalCount.doubleValue();
		Double totalPage =Math.ceil(total/pageSize) ;
		pageBean.setTotalPage(totalPage.intValue());
		//每页查询到的数据，list
		Integer begin = (currPage-1)*pageSize;
		List<Visit> list = (List<Visit>) visitDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public void save(Visit visit) {
		visitDao.save(visit);
	}
	
	
}
