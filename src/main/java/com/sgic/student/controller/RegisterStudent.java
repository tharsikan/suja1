package com.sgic.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgic.student.dao.StudentDao;
import com.sgic.student.dao.impl.StudentDaoImpl;
import com.sgic.student.entity.Student;

public class RegisterStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("views/registerStudent.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		StudentDao sdao = (StudentDao) ctx.getBean("StudentDao");
		String fname = (String) req.getAttribute("fname");
		String lname = (String) req.getAttribute("lname");
		Student s = new Student();
		s.setFirstname(fname);
		s.setLastname(lname);
		int n = sdao.save(s);
		String msg;
		if(n!=0) {
			msg = "Success! fully update";
		}else {
			msg = "faild! to update";
		}
		req.setAttribute("msg", msg);
		RequestDispatcher rd = req.getRequestDispatcher("views/listStudent.jsp");
		rd.forward(req, resp);
		
	}
}
