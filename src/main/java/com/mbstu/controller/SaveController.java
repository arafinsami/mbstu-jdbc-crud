package com.mbstu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbstu.entity.Student;
import com.mbstu.service.StudentService;
import com.mbstu.serviceimpl.StudentServiceImpl;

@WebServlet("/save")
public class SaveController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService service;

	public SaveController() {
		super();
	}

	public void init() {
		this.service = new StudentServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/create.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Student student = new Student(name, email, address);
			service.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/");
	}

}
