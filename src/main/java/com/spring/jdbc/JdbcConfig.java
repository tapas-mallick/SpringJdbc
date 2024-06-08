package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages={"com.spring.jdbc.dao"})
public class JdbcConfig {
	
	@Bean(name= {"datasource"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Tapu@2805");
		return ds;
	}
	
	@Bean(name= {"jdbc"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate template= new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
//	@Bean(name= {"impl"})
//	public StudentDaoImpl getStudentDao(){
//		StudentDaoImpl studentDao= new StudentDaoImpl();
//		studentDao.setTemplate(getTemplate());
//		return studentDao;
//	}
}
