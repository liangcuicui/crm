package com.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.crm.domain.BaseDict;
import com.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 字典类
 * @author 梁翠翠
 *
 */
public class BaseDictAtion extends ActionSupport implements ModelDriven<BaseDict>{

	private BaseDict baseDict = new BaseDict();

	@Override
	public BaseDict getModel() {
		// TODO Auto-generated method stub
		return baseDict ;
	}
	private BaseDictService baseDictService;

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	/**
	 * 根据字典类别查询
	 * @return
	 */
	public String findByTypeCode() {
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//将list转为json,,因为异步
		/**
		 * JSONConfig:转JSON的配置对象
		 * JSONArray:将数组和list集合转为JSON
		 * JSONObject:将对象和Map集合转为JSON
		 */
		JsonConfig jsonConfig = new JsonConfig();
		//一下属性不需要查询出来
		jsonConfig.setExcludes(new String[] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		//将JSON传送到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}
