package step09.class5;

public class Person {

	// static variable
	private static int objCnt;
	
	private String name;
	private int age;
	private char gender;
	
	// static 초기화블록
	static {
		System.out.println("static 초기화 블록이 실행");
		objCnt = 0;
	}
	
	// non-static 초기화 블록 
	{
		System.out.println("non-static 초기화 블록이 실행");
	}
	
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		
		System.out.println("생성자 함수 호출");
		objCnt++;
	}
	
	public static int getPersonObjCount() {
		return objCnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
