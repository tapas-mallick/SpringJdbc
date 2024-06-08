package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;


public interface StudentDao {
	public int insert(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int id);
	public Student selectStudent(int id);
	public List<Student> selectAllStudent();
}
