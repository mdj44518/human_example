package step09.class5;

public class Person {

	// static variable
	private static int objCnt;
	
	private String name;
	private int age;
	private char gender;
	
	static {
		objCnt = 0;
	}
	
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		
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
