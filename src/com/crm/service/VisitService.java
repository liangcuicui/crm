package com.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.PageBean;
import com.crm.domain.Visit;

public interface VisitService {

	PageBean<Visit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(Visit visit);

}
