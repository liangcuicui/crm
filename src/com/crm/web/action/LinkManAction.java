package com.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.Customer;
import com.crm.domain.LinkMan;
import com.crm.domain.PageBean;
import com.crm.service.CustomerService;
import com.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan ;
	}
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/**
	 * 这次使用同步，去查询客户信息
	 * @return
	 */
	public String saveUI() {
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	public String save() {
		linkManService.save(linkMan);
		return "save";
	}
	private Integer currPage = 1;//当前页
	private Integer pageSize = 3;//每页多少记录
	
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
	/**
	 * 这里还要注意分页的功能
	 * @return
	 */
	public String findAll() {
		//创建离线条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//设置一下筛选的条件
		if(linkMan.getLkm_name()!=null) {
			detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getLkm_mobile()!=null) {
			detachedCriteria.add(Restrictions.like("lkm_mobile", "%"+linkMan.getLkm_mobile()+"%"));
		}
		if(linkMan.getLkm_qq()!=null) {
			detachedCriteria.add(Restrictions.like("lkm_qq", "%"+linkMan.getLkm_qq()+"%"));
		}
		/*if(linkMan.getCustomer().getCust_id()!=null && !"".equals(linkMan.getCustomer().getCust_name())) {
			detachedCriteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}*/
		PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 修改联系人
	 * @return
	 */
	public String edit() {
		//查询某个联系人，所有客户
		List<Customer> list = customerService.findAll();
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//将list对象带到页面
		ActionContext.getContext().getValueStack().set("list", list);
		//将对象的值带到值栈中
		ActionContext.getContext().getValueStack().push(linkMan);
		return "edit";
	}
	/**
	 * 更新修改后的
	 * @return
	 */
	public String update() {
		linkManService.update(linkMan);
		return "update";
	}
	public String delete() {
		//先查
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//删除
		linkManService.delete(linkMan);
		return "delete";
	}
}
