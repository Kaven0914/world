package com.bei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bei.beans.StudentSSH;
import com.bei.dao.IStudentDAO;

@Service("StudentService")
public class StudntService implements IStudentService {

	@Resource(name = "StudentDAO")
	private IStudentDAO dao;
	
	public IStudentDAO getDao() {
		return dao;
	}

	public void setDao(IStudentDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(StudentSSH student) {
		return dao.add(student);
		
	}

	@Override
	public List<StudentSSH> list(int page, int pageSize) {
		return dao.list(page, pageSize);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void update(StudentSSH stu) {
		dao.update(stu);		
	}

	@Override
	public StudentSSH modifyByID(int id) {
		return dao.modifyByID(id);
	}

}
