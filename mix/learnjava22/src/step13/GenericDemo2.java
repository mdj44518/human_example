package step13;

public class GenericDemo2 {

	public static void main(String[] args) {
		MyGeneric<Integer> gen = new MyGeneric<> ();
		
		gen.add(10);
		
		System.out.println(gen.get());

		MyGeneric<String> gen2 = new MyGeneric<> ();
		gen2.add("Java");
		System.out.println(gen2.get());
	}

}

class MyGeneric<T> {
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}
}
