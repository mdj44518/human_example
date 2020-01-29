package org.study.model;

import java.sql.Date;

public class Student {
	private String name;
	private int number;
	private Date birthDay;
	
	public Student() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", birthDay=" + birthDay + "]";
	}
	
	
}
