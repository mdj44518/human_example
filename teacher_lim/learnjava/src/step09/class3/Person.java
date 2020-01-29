package step09.class3;

public class Person {

	String name;
	int age;
	char gender;
	
	// 다앙한 생성자
	public Person() {
		age = 1;
		gender = 'f';
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}
