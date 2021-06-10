package com.mbstu.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import com.mbstu.dao.StudentDao;
import com.mbstu.daoimpl.StudentDaoImpl;
import com.mbstu.entity.Student;
import com.mbstu.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao = new StudentDaoImpl();

	@Override
	public boolean save(Student student) throws SQLException {
		return dao.save(student);
	}

	@Override
	public Student findById(int id) throws SQLException {
		return dao.findById(id);
	}

	@Override
	public boolean update(Student student) throws SQLException {
		return dao.update(student);
	}

	@Override
	public boolean delete(Student student) throws SQLException {
		return dao.delete(student);
	}

	@Override
	public List<Student> getAll() throws SQLException {
		return dao.getAll();
	}

}
