package step10.inher2;

import java.util.Arrays;

public class InheritanceDemo2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Family f1 = new Family();
		
		f1.parents = new String[2];
		f1.parents[0] = "홍";
		f1.parents[1] = "박";
		
		// Family f2 복사
		Family f2 = (Family)f1.clone();

		System.out.println(Arrays.toString(f2.parents));
		
		// Family f1 부모 1  변경
		f1.parents[1] = "최";
		
		// Family f2 다시 출력 ???
		System.out.println(Arrays.toString(f2.parents));
	}

}

class Family implements Cloneable {
	String[] parents;
	String[] siblings;
	
	public Family() { }
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
