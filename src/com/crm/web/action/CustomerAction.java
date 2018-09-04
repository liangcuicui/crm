package com.crm.web.action;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.Customer;
import com.crm.domain.PageBean;
import com.crm.service.CustomerService;
import com.crm.utils.UploadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//ʹ��set������������
	private Integer currPage=1;//��ǰҳ��
	private Integer pageSize=3;//ÿҳ���ټ�¼��

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
	 * Ϊ�ļ��ϴ��ṩ����������
	 */
	private String uploadFileName;//�ļ�����
	private File upload;
	private String uploadContentType;//�ļ����� 
	

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	/**
	 * �����ͻ�����ת������ҳ��
	 * @return
	 */
	public String saveUI() {
		
		return "saveUI";
	}
	/**
	 * ����ͻ�
	 * @return
	 */
	public String save() {
		//�ϴ��ļ�
		if(upload!=null) {
			//ָ��һ���ϴ���·��
			String path="C:/upload";
			//����ϴ����ļ�����Ϊ�ļ�����ͬ��������ס��ô�죬����������һ��������ļ�������׺����
			String uuidFileName = UploadUtil.getUuidFileName(uploadFileName);
			//Ŀ¼����
			String realPath = UploadUtil.getPath(uuidFileName);
			String url = path+realPath;
			//�ֶ�����Ŀ¼
			File file = new File(url);
			if(!file.exists()) {
				//�����ڣ��ʹ���
				file.mkdirs();
			}
			try {
				//�ļ��ϴ�
				File dicFile = new File(url+"/"+uuidFileName);
				FileUtils.copyFile(upload, dicFile);
				//���ÿͻ�����ͼƬ��ֵ
				customer.setCust_image(url+"/"+uuidFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		customerService.save(customer);
		return "save";
	}
	/**
	 * 
	 * ��ѯ�ͻ�
	 * @return
	 */
	public String findAll() {
		/*//���ղ�������ҳ����
		//ʹ��DetachedCriteria�������ṩ�˷�ҳ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		PageBean<Customer> pageBean = customerService.findAByPage(detachedCriteria,currPage,pageSize);
		//�õ�����֮��������Ҫ�����ݴ���ҳ����ȥ�������Ҫʹ��ֵջ
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
		//��д�����ʱ���ṩ������ɸѡ
		//ʹ��DetachedCriteria�������ṩ�˷�ҳ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//��������,Ȼ�����ӵ�DetachedCriteria��
		//����ɸѡ
		if(customer.getCust_name()!=null)
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		System.out.println("-----------------------------------------------"+customer.getCust_name());
		
		//customer.getBaseDictSource()!=null���Ϊnull������û��ѡ
		if(customer.getBaseDictSource()!=null)
			if(customer.getBaseDictSource().getDict_id()!=null && !"".equals(customer.getBaseDictSource().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}
		
		if(customer.getBaseDictLevel()!=null && customer.getBaseDictLevel().getDict_id()!=null && !"".equals(customer.getBaseDictLevel().getDict_id()))
			detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
		
		if(customer.getBaseDictIndustry()!=null && customer.getBaseDictIndustry().getDict_id()!=null && !"".equals(customer.getBaseDictIndustry().getDict_id()))
			detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
		
		if(customer.getCust_phone()!=null)
			detachedCriteria.add(Restrictions.like("cust_phone", "%"+customer.getCust_phone()+"%"));
		if(customer.getCust_mobile()!=null)
			detachedCriteria.add(Restrictions.like("cust_mobile", "%"+customer.getCust_mobile()+"%"));
		//��������Ҳ��Ҫ���ݻ���
		PageBean<Customer> pageBean = customerService.findAllByPage(detachedCriteria,currPage,pageSize);
		//�õ�����֮��������Ҫ�����ݴ���ҳ����ȥ�������Ҫʹ��ֵջ
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * ɾ���ͻ���Ϣ
	 * @return
	 */
	public String delete() {
		//�Ȳ�ѯ����ɾ��
		customer = customerService.findById(customer.getCust_id());
		//ɾ��ͼƬ
		if(customer.getCust_image()!=null) {
			File file = new File(customer.getCust_image());
			if(file.exists()) {
				file.delete();
			}
		}
		//���ȣ��ý���һ���ͻ���ID
		customerService.delete(customer);
		return "deleteSuccess";
	}
	/**
	 * �޸Ŀͻ�
	 * @return
	 */
	public String edit() {
		//�޸Ŀͻ�ʱ��������Ҫ�Ƚ��ͻ����� 
		//��ȡID����תҳ��
		customer = customerService.findById(customer.getCust_id());
		ActionContext.getContext().getValueStack().push(customer);
		return "editSuccess";
	}
	/**
	 * �����޸ĺ�Ŀͻ�
	 * @return
	 */
	public String update() {
		//��ѡ���ϴ��ļ�ʱ�������ж�һ�£��Ƿ����ϴ����ļ�
		if(upload!=null) {//��ʱ�Ѿ�ѡ�����ϴ��ļ��İ�ť
			//Ҫɾ��
			String cust_image = customer.getCust_image();
			if(cust_image!=null || !"".equals(cust_image)) {
				File file = new File(cust_image);
				file.delete();
			}
			//����Ļ����ϴ�
			//ָ��һ���ϴ���·��
			String path="C:/upload";
			//����ϴ����ļ�����Ϊ�ļ�����ͬ��������ס��ô�죬����������һ��������ļ�������׺����
			String uuidFileName = UploadUtil.getUuidFileName(uploadFileName);
			//Ŀ¼����
			String realPath = UploadUtil.getPath(uuidFileName);
			String url = path+realPath;
			//�ֶ�����Ŀ¼
			File file = new File(url);
			if(!file.exists()) {
				//�����ڣ��ʹ���
				file.mkdirs();
			}
			try {
				//�ļ��ϴ�
				File dicFile = new File(url+"/"+uuidFileName);
				FileUtils.copyFile(upload, dicFile);
				//���ÿͻ�����ͼƬ��ֵ
				customer.setCust_image(url+"/"+uuidFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		customerService.update(customer);
		return "save";
	}
	public String findAllCustomer() throws IOException {
		List<Customer> list = customerService.findAll();
		//listתjson
		JsonConfig jsonConfig = new JsonConfig();
		//��Щ�ǲ���Ҫ��
		jsonConfig.setExcludes(new String[] {"linkMans","baseDictSource","baseDictLevel","baseDictIndustry"});
		//תjson
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		System.out.println(jsonArray.toString());
		return NONE;
	}
}