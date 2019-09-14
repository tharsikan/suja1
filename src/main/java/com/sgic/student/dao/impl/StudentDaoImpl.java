package com.sgic.student.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sgic.student.dao.StudentDao;
import com.sgic.student.entity.Student;

public class StudentDaoImpl implements StudentDao{
	 
	private JdbcTemplate conn ;


	public void setConn(JdbcTemplate conn) {
		this.conn = conn;
	}


	@Override
	public int save(Student student) {
		String sql = "INSERT INTO `students`(`firstname`,`lastname`) VALUES (?,?)";
		int result = conn.update(sql, student.getFirstname(), student.getLastname());
		return result;
	}


	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Student selectByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
