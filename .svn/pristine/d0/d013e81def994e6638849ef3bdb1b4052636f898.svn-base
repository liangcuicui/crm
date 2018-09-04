package com.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.crm.domain.User;
import com.crm.service.UserService;
import com.crm.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 模型驱动
	 */
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 注册
	 * @return
	 */
	public String regist() {
		String code = user.getUser_code();
		String password = user.getUser_password();
		String name = user.getUser_name();
		System.out.println("code="+code);
		System.out.println("name="+name);
		if(code.length()==0||name.length()==0) {
			//返回错误信息到页面
			this.addActionError("请填写完整");
			return "registfail";
		}else {
			userService.regist(user);
			return LOGIN;
		}
	}
	/**
	 * 用户登录
	 * @return
	 */
	public String login() {
		User existUser = userService.login(user);
		if(existUser == null) {
			//登录失败
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else {	
			//登录成功
			ActionContext.getContext().getSession().put("existUser", existUser);
			return "loginSuccess";
		}
	}
	public String findAllUser() throws IOException {
		List<User> list = userService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}
}
