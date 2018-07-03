package com.bei.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bei.beans.StudentSSH;

@Transactional
public interface IStudentService {
	 public int add(StudentSSH student);
	 public List<StudentSSH> list(int page,int pageSize) ;
	 public void delete(int id);
	 public void update(StudentSSH stu);
	 public StudentSSH modifyByID(int id);
}
