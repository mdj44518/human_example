package step09.class3;

public class PersonApp {

	public static void main(String[] args) {
		Person person = new Person();
		Person person2 = new Person("홍길동");
		Person person3 = new Person("이수지", 22, 'f');
		
		System.out.println(person.name);
		System.out.println(person.age);
		System.out.println(person.gender);

		System.out.println(person2.name);
		System.out.println(person2.age);
		System.out.println(person2.gender);
		
		System.out.println(person3.name);
		System.out.println(person3.age);
		System.out.println(person3.gender);
		
		// 무엇이 프린트 될까?
		System.out.println(person);
		System.out.println(person2);
		System.out.println(person3);
	}

}
