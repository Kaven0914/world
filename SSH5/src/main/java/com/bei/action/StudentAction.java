package com.bei.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;
import com.bei.beans.StudentSSH;
import com.bei.service.IStudentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("StudentAction")
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
public class StudentAction extends ActionSupport implements SessionAware{
	private StudentSSH studentSSH;
	private int age;
	private Map<String,Object> session;
	private int page;
	private int pageSize;
	private int id;
	private List<StudentSSH> list;
	@Resource(name="StudentService")
	private IStudentService studentService;
	
	@Action(value="/add",results={@Result(name="success",location="/jsp/index.jsp")})
	public String Add(){
		studentSSH.setAge(age);
		studentService.add(studentSSH);
		return SUCCESS;
	}
	 
	@Action(value="/index" ,results={@Result(name="success",location="/jsp/add.jsp")})
	public String toAdd(){
		return SUCCESS;
	}
	
	@Action(value="list",results={@Result(name="success",location="/jsp/list.jsp")})
	public String toList(){
		list = studentService.list(page, pageSize);
		return SUCCESS;
	}
	
	@Action(value="update",results={@Result(name="success",type="redirectAction",location="list")})
	public String update(){
		studentSSH = studentService.modifyByID(id);
		studentService.update(studentSSH);
		return SUCCESS;
	}
	@Action(value="del",results={@Result(name="success",type="redirectAction",location="list")})
	public String delete(){
		studentService.delete(id);
		return SUCCESS;
	}
	@Action(value="modify",results={@Result(name="success",location="/jsp/update.jsp")})
	public String modifyById(){
		return SUCCESS;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<StudentSSH> getList() {
		return list;
	}

	public void setList(List<StudentSSH> list) {
		this.list = list;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public StudentSSH getStudentSSH() {
		return studentSSH;
	}
	public void setStudentSSH(StudentSSH studentSSH) {
		this.studentSSH = studentSSH;
	}
	public IStudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
