package step10.inher2;

public class SalariedEmployee extends Employee {
	private double salary;
	private double bonus;
	
	// 자식 객체의 생성자가 불리울때, 
	// 자동적으로 부모의 생성자가 불려요.
	public SalariedEmployee(String name) {
		super();
	}
	
}
