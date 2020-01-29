package step14;

public class AbstractDemo1 {

	public static void main(String[] args) {
		// Vehicle v0 = new Vehicle();
		Vehicle v1 = new Sedan();
		Vehicle v2 = new SportsCar();
		Vehicle v3 = new SchoolBus();
		
		v1.run();
		v2.run();
		v3.run();
	}

}

abstract class Vehicle {
	private static int serialNo = 1;
	
	public Vehicle() {
		System.out.println("Vehicle is created: " + serialNo);
		serialNo++;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	
	abstract public void run();
}

class Sedan extends Vehicle {

	@Override
	public void run() {
		System.out.println("Sedan runs 100Km/h");
	}
}

class SportsCar extends Vehicle {

	@Override
	public void run() {
		System.out.println("Sports car runs 150Km/h");
	}
	
}

class SchoolBus extends Vehicle {

	@Override
	public void run() {
		System.out.println("Schoolbus runs 60Km/h");
	}
	
}
