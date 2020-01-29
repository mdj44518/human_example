package step05;

public class StringSplitDemo01 {

	public static void main(String[] args) {
		String str = "더 휴먼 컴퓨터 아트   아카데미";
		String[] tokens = str.split("\\s+");
		
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(i + ": |" + tokens[i] + "|");
		}
	}

}
