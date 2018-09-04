package com.crm.domain;

import java.util.Date;

/**
 * 客户拜访记录表，用户和客户的中间表,是多的一方
 * @author 梁翠翠
 *
 */
public class Visit {
	private String visit_id;//拜访者ID
	private Integer visit_cust_id;//客户ID
	private Integer visit_user_id;//用户ID
	private Date visit_time;//拜访时间
	private String visit_addr;//拜访地点
	private String visit_detail;//拜访详情
	private Date visit_nexttime;//下次拜访时间
	
	private Customer customer;
	private User user;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public Integer getVisit_cust_id() {
		return visit_cust_id;
	}
	public void setVisit_cust_id(Integer visit_cust_id) {
		this.visit_cust_id = visit_cust_id;
	}
	public Integer getVisit_user_id() {
		return visit_user_id;
	}
	public void setVisit_user_id(Integer visit_user_id) {
		this.visit_user_id = visit_user_id;
	}
	public Date getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_addr() {
		return visit_addr;
	}
	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public Date getVisit_nexttime() {
		return visit_nexttime;
	}
	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	
}
