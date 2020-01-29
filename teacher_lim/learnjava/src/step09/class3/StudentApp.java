package step09.class3;

import java.util.Arrays;

public class StudentApp {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "tom";
		s.id = "st001";
		s.scores = new int[] {90, 80, 70};
		
		Student s2 = new Student();
		s2.name = "rancy";
		s2.id = "st011";
		s2.scores = null;
		
		s.displayInfo();
		s2.displayInfo();
	}
	
	// Student 정보를 콘솔에 출력
	// 입력: student 객체
	// 리턴: void
	public static void displayStudent(Student s) {
		System.out.println(s.name);
		System.out.println(s.id);
		System.out.println(Arrays.toString(s.scores));
	}

}
