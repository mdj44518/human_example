package step09.class5;

public class PersonApp {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 25, 'm');
		Person p2 = new Person("이도선", 20, 'f');
		Person p3 = new Person("김소미", 22, 'f');
		Person p4 = new Person("장소팔", 26, 'm');

		int numOfPersonObj = Person.getPersonObjCount();
		
		System.out.println("Person 객체의 수: " + numOfPersonObj);
		
		System.out.println(p4.getPersonObjCount());
	}

}
