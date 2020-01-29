package app;

import model.Student;

public class TestApp {

	public static void main(String[] args) {
		Student s = new Student("jitaek", "1234");
		s.setsBirthDate("1999-12-30");
		
		System.out.println(s);
		System.out.println(s.getsBirthDateToStr());
		System.out.println(s.getsBirthDateToDate());
	}

}
