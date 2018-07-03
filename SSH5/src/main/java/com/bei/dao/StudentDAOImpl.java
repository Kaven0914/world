package com.bei.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bei.beans.StudentSSH;

@Repository("StudentDAO")
public class StudentDAOImpl implements IStudentDAO {

	@Resource
    private SessionFactory sessionFactory;
	
	@Override
	public int add(StudentSSH student) {
		return (Integer)sessionFactory.getCurrentSession().save(student);
	}
	
	@Override
	public List<StudentSSH> list(int page,int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from StudentSSH");
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

	@Override
	public void update(StudentSSH stu) {
		sessionFactory.getCurrentSession().update(stu);
	}

	@Override
	public StudentSSH modifyByID(int id) {
		return sessionFactory.getCurrentSession().get(StudentSSH.class, id);
		
	}

}
