package com.mbstu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mbstu.dao.StudentDao;
import com.mbstu.entity.Student;
import com.mbstu.utils.DbUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean save(Student student) throws SQLException {
		Connection connection = DbUtils.connection();
		String query = "INSERT INTO student(name,email,address) VALUES(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, student.getName());
		ps.setString(2, student.getEmail());
		ps.setString(3, student.getAddress());
		boolean row = ps.executeUpdate() > 0;
		return row;
	}

	@Override
	public Student findById(int id) throws SQLException {
		Student student = null;
		Connection connection = DbUtils.connection();
		String query = "SELECT * student WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String studentName = rs.getString("name");
			String studentEmail = rs.getString("email");
			String studentAddress = rs.getString("address");
			student = new Student(id, studentName, studentEmail, studentAddress);
		}
		return student;
	}

	@Override
	public boolean update(Student student) throws SQLException {
		Connection connection = DbUtils.connection();
		String query = "UPDATE student SET name=?,email=?,address=? WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, student.getName());
		ps.setString(2, student.getEmail());
		ps.setString(3, student.getAddress());
		ps.setInt(4, student.getId());
		boolean row = ps.executeUpdate() > 0;
		return row;
	}

	@Override
	public boolean delete(Student student) throws SQLException {
		Connection connection = DbUtils.connection();
		String query = "DELETE FROM student WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, student.getId());
		boolean row = ps.executeUpdate() > 0;
		return row;
	}

	@Override
	public List<Student> getAll() throws SQLException {

		List<Student> lists = new ArrayList<Student>();
		Connection connection = DbUtils.connection();
		String query = "SELECT * FROM student";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int studentId = rs.getInt("id");
			String studentName = rs.getString("name");
			String studentEmail = rs.getString("email");
			String studentAddress = rs.getString("address");
			lists.add(new Student(studentId, studentName, studentEmail, studentAddress));
		}
		return lists;
	}

}
