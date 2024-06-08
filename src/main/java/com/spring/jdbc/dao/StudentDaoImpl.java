package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;


@Component("impl")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(Student student) {
		String query="insert into student(id,name,city)VALUES(?,?,?);";
		int r=this.template.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	public int updateStudent(Student student) {
		String query="update student set name=?,city=? where id=?;";
		int r=this.template.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	public int deleteStudent(int id) {
		String query="delete from student where id=?;";
		int r= this.template.update(query,id);
		return r;
	}


	public Student selectStudent(int id) {
		String query="Select * from student where id=?;";
		RowMapper<Student> rowMapper =new RowMapperImpl();
		Student student= this.template.queryForObject(query,rowMapper,id);
		return student;
	}

	@Override
	public List<Student> selectAllStudent() {
		String query="Select * from student;";
		List<Student> students=this.template.query(query, new RowMapperImpl());
		return students;
	}

}
