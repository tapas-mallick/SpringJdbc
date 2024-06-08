package com.spring.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao bean = context.getBean("impl", StudentDao.class);
		Student student = new Student();

		//INSERT RECORD
//		 student.setId(6); 
//		 student.setName("Balia"); 
//		 student.setCity("Banglore"); 
//		 int result = bean.insert(student);

		//UPDATE RECORD
//       student.setId(3);
//       student.setName("Dipti Mayee Mallick"); 
//       student.setCity("Daringbadi");
//       int result=bean.updateStudent(student);

		//DELETE RECORD
//		int result = bean.deleteStudent(5);
//		System.out.println("Deleted:" + result + " record");
		
		//SELECT ONE RECORD
		Student stu= bean.selectStudent(4);
		System.out.println("id :"+stu.getId()+" Name :"+stu.getName()+" city :"+stu.getCity());
		
		//SELECT ALL RECORD
//		List<Student> students=bean.selectAllStudent();
//		
//		for(Student s:students) {
//			System.out.println(s);
//		}
//		
	}
}
