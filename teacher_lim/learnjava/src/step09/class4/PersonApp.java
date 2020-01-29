package step09.class4;

public class PersonApp {

	public static void main(String[] args) {
		// Person p = new Person();
		Person p = new Person("David", 10, 'm');
		
		System.out.println("name: " + p.getName());
		System.out.println("age: " + p.getAge());
		System.out.println("gender: " + p.getGender());

		p.setName("Alice");
		p.setAge(15);
		p.setGender('f');
		
		System.out.println("name: " + p.getName());
		System.out.println("age: " + p.getAge());
		System.out.println("gender: " + p.getGender());
	}

}
