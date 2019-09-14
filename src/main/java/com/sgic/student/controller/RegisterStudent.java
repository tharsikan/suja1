package com.sgic.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String fname = (String) req.getAttribute("fname");
		String lname = (String) req.getAttribute("lname");
		Student s = new Student();
		s.setFirstname(fname);
		s.setLastname(lname);
		StudentDao sd = new StudentDaoImpl();
		int n = sd.save(s);
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
