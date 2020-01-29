package step09.class2;

public class PersonApp {

	public static void main(String[] args) {
		// person 객체 생성
		Person p1 = new Person();
		
		// 객체의 속성 변경
		p1.name = "홍길동";
		p1.age = 30;
		p1.gender = 'm';
		
		Person p2 = new Person();
		p2.name = "최미숙";
		p1.age = 20;
		p1.gender = 'f';
		
		System.out.println("Person 1");
		System.out.println("name: " + p1.name);
		System.out.println("age: " + p1.name);
		System.out.println("gender: " + p1.gender);

	}

}
