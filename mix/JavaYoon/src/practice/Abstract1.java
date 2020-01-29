package practice;

public class Abstract1{

	public static void main(String[] args) {
		Tv t = new Tv(34) {
			private int color = 1024;
			@Override
			protected void printProperty() {
				System.out.println(getSize() + "인치 " + color + "컬러 Tv");
				deful();
//				privay();
			}
		};
		t.printProperty();
		InterTv a = () -> {
			System.out.println("인터페이스 람다람다");
		};
		t.getSize();
		a.print2();
		t.getSize();
	}
	
}

abstract class Tv {
	private int size;
	public Tv (int size) {this.size = size;}
	protected int getSize() {return size;}
	abstract protected void printProperty();
	void deful() {
		System.out.println("디폴트지롱" + size);
		privay();
	}
	private void privay() {
		System.out.println("프롸빗. 나만보지롱");
	}
}

interface InterTv {
	void print2();
}