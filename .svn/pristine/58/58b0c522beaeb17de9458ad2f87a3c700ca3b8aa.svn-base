package com.crm.web.action;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.PageBean;
import com.crm.domain.Visit;
import com.crm.service.VisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户拜访
 * @author 梁翠翠
 *
 */
public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	private Visit visit = new Visit();

	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit ;
	}
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	//接收分页数据：
	private Integer currPage = 1;
	private Integer pageSize = 3;
	
	public void setCurrPage(Integer currPage) {
		if(currPage == null)
			currPage = 1;
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == null)
			pageSize = 3;
		this.pageSize = pageSize;
	}

	//接收数据
	private Date visit_begin_time;
	private Date visit_end_time;
	
	public Date getVisit_begin_time() {
		return visit_begin_time;
	}

	public Date getVisit_end_time() {
		return visit_end_time;
	}

	public void setVisit_begin_time(Date visit_begin_time) {
		this.visit_begin_time = visit_begin_time;
	}

	public void setVisit_end_time(Date visit_end_time) {
		this.visit_end_time = visit_end_time;
	}

	/**
	 * 查询客户拜访列表
	 * @return
	 */
	public String findAll() {
		//创建离线条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Visit.class);
		//设置条件
		if(visit_begin_time!=null)
			detachedCriteria.add(Restrictions.ge("visit_time", visit_begin_time));
		if(visit_end_time!=null)
			detachedCriteria.add(Restrictions.le("visit_time", visit_end_time));
		//调用
		PageBean<Visit> pageBean = visitService.findByPage(detachedCriteria,currPage,pageSize);
		//存到值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	public String saveUI() {
		return "saveUI";
	}
	public String save() {
		visitService.save(visit);
		return "save";
	}
}
