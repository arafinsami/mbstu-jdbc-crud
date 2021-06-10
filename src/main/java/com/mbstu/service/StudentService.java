package com.mbstu.service;

import java.sql.SQLException;
import java.util.List;

import com.mbstu.entity.Student;

public interface StudentService {

	public boolean save(Student student) throws SQLException;

	public Student findById(int id) throws SQLException;

	public boolean update(Student student) throws SQLException;

	public boolean delete(Student student) throws SQLException;

	public List<Student> getAll() throws SQLException;
}
