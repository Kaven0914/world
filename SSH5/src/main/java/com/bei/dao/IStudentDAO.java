package com.bei.dao;

import java.util.List;

import com.bei.beans.StudentSSH;

public interface IStudentDAO {
	 public int add(StudentSSH student);
	 public List<StudentSSH> list(int page,int pageSize) ;
	 public void delete(int id);
	 public void update(StudentSSH stu);
	 public StudentSSH modifyByID(int id);
	 
}
