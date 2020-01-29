package level1;

public class SubakSubak {

	public static void main(String[] args) {
		System.out.println(getMySubak2(1));
		System.out.println(getMySubak2(2));
		System.out.println(getMySubak2(3));
		System.out.println(getMySubak2(4));
		System.out.println(getMySubak2(5));
		System.out.println(getMySubak2(10));
		System.out.println(getMySubak2(11));
		System.out.println(getMySubak2(0));
	}

	public static String getMySubak(int n) {
		if (n <= 0) {
			return null;
		}
		
		String subak = "수박";
		String result = "";
		int index = 0;
		while (n > 0) {
			result += subak.charAt(index);	// result = result + subak.charAt(index);
			index++;
			if (index > 1) {
				index = 0;
			} 
			n--;
		}
		return result;
	}
	
	public static String getMySubak2(int n) {
		if (n <= 0) {
			return null;
		} else if (n == 1) {
			return "수";
		}
		
		String subak = "수박";
		for (int i = 0; i < n/2-1; i++) {
			subak += "수박";
		}
		
		if (n % 2 == 0) {
			return subak;
		} else {
			return subak + "수";
		}

	}
}
