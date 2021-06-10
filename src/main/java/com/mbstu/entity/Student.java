package com.mbstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int id;

	private String name;

	private String email;

	private String address;

	public Student(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

}
