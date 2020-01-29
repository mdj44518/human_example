package step14;

import java.util.Arrays;
import java.util.Comparator;

public class StudentApp {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		
		students[0] = new Student("김자바");
		students[0].setAge(10);
		students[1] = new Student("이스프");
		students[1].setAge(15);
		students[2] = new Student("박거미");
		students[2].setAge(12);
		students[3] = new Student("최잘해");
		students[3].setAge(13);
		students[4] = new Student("임못해");
		students[4].setAge(14);
		
		System.out.println(Arrays.toString(students));
		// 나이순으로 정렬
		//Arrays.sort(students);
		//StudentAgeComparator c = new StudentAgeComparator();
		Arrays.sort(students, new StudentAgeComparator());
		System.out.println(Arrays.toString(students));
		
	}
}

class StudentAgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		return student1.getAge() - student2.getAge();
	}
	
}
