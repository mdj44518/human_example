package model;

//사용자가 Engineer 객체를 생성할 때,
// 자동적으로 Engineer의 부모(Employee)의 객체를 생성시킨다
public class Engineer extends Employee {

	String skill;
	EngineerGrade grade;
	
	// 생성자
	public Engineer(String name, String ssn) {
		// 반드시 첫줄은 부모 객체 생성을 위한 코드
		super(name, ssn);
	}
	
	@Override
	public long getAnualSalary() {
		double rate = grade.getIncentiveRate();
		return (long)((getSalary() * 12) * (1 + rate));
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public EngineerGrade getGrade() {
		return grade;
	}

	public void setGrade(EngineerGrade grade) {
		this.grade = grade;
	}
}
