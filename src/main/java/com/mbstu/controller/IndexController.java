package com.mbstu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbstu.entity.Student;
import com.mbstu.service.StudentService;
import com.mbstu.serviceimpl.StudentServiceImpl;

@WebServlet("/")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService service;

	public IndexController() {
		super();
	}

	public void init() {
		this.service = new StudentServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Student> students = service.getAll();
			request.setAttribute("students", students);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/index.jsp");
		dispatcher.forward(request, response);
	}

}
