package com.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 权限拦截器
 * @author 梁翠翠
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session中是否有登录的用户的信息
		User user = (User) ServletActionContext.getRequest().getAttribute("existUser");
		if(user == null) {
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("请登录！");
			return actionSupport.LOGIN;
		}else {
			return invocation.invoke();
		}
	}
	
}
