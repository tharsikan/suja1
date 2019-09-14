package com.sgic.student.dao;

import java.util.List;

import com.sgic.student.entity.Student;

public interface StudentDao {
	int save(Student student);

	int update(Student student);

	int delete(int id);

	Student selectByid(int id);

	List<Student> selectAll();
}
