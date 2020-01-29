package step10.inher2;

import java.util.Arrays;

public class InheritanceDemo3 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Family2 f1 = new Family2();
		
		f1.parents = new String[2];
		f1.parents[0] = "홍";
		f1.parents[1] = "박";
		
		// Family f2 복사
		Family2 f2 = (Family2)f1.clone();

		System.out.println(Arrays.toString(f2.parents));
		
		// Family f1 부모 1  변경
		f1.parents[1] = "최";
		
		// Family f2 다시 출력 ???
		System.out.println(Arrays.toString(f2.parents));
		
		// Family f1 출력 확인
		System.out.println(Arrays.toString(f1.parents));
	}

}

class Family2 implements Cloneable {
	String[] parents;
	String[] siblings;
	
	public Family2() { }
	
	public Object clone() throws CloneNotSupportedException {
		Family2 f = (Family2)super.clone();
		
		Family2 clone = new Family2();
		if (f.parents != null) {
			clone.parents = new String[f.parents.length];
			
			for (int i = 0; i < clone.parents.length; i++) {
				clone.parents[i] = f.parents[i];
			}
		}
		
		if (f.siblings != null) {
			clone.siblings = new String[f.siblings.length];
			
			for (int i = 0; i < clone.siblings.length; i++) {
				clone.siblings[i] = f.siblings[i];
			}
		}

		return clone;
	}
}
