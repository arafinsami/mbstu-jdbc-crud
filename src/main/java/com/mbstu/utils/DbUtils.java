package com.mbstu.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USER = "root";

	private static final String PASSWORD = "";

	private static final String URL = "jdbc:mysql://localhost:3306/mbstu";

	public static Connection connection() {

		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connected");
		} catch (Exception e) {
			System.out.println("No connection");
		}
		return connection;
	}

	public static void main(String [] args) {
		DbUtils.connection();
	}

}
