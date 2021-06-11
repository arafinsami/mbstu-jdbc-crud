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

@WebServlet("/edit")
public class EditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService service;

	public EditController() {
		super();
	}

	public void init() {
		this.service = new StudentServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int studentId = Integer.parseInt(request.getParameter("id"));
			Student student = service.findById(studentId);
			request.setAttribute("student", student);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int studentId = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Student student = new Student(studentId, name, email, address);
			service.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/");
	}

}
