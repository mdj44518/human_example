package step09.exercise;

public class IntBoxApp {

	public static void main(String[] args) {
		IntBox box = new IntBox();

		for (int i = 0; i < 200; i++) {
			box.add(i);
		}

		System.out.println(box.size());
		
		int a = box.get(100);
		System.out.println(a);
		
		box.remove(50);
		box.remove(100);
		if (box.remove(200) == false) {
			System.out.println("200은 없습니다");
		}
		
		for (int i = 0; i < box.size(); i++) {
			System.out.println(box.get(i));
		}
	}

}
