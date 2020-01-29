package step07;

import java.util.Arrays;

public class VariableScopeDemo01 {

	static String[] names = new String[5];
	static int currentPos = 0;
	static int totalNum = 0;
	
	public static void main(String[] args) {
		// 등록 절차
		addName("홍길동");
		addName("홍길순");
		addName("홍길자");

		removeName("홍길동");
		addName("전준명");
		addName("이미경");
		addName("이혜정");
		removeName("홍길순");
		addName("박진우");
		addName("심상우");
		addName("서재호");
		
		removeName("홍길자");
		addName("문동주");
		addName("이순근");
		addName("우미타");
		
		removeName("임지택");
		addName("김지현");
		addName("박수경");
		addName("구용효");
		
		printNames();
	}

	// 사람을 등록
	// 입력: 사람이름(String)
	// 리턴: void
	public static void addName(String name) {
		int pos = getCurrentPos();
		if (pos != -1) {
			names[pos] = name;
			totalNum++;
		}
	}
	
	// 사람을 해지(등록철회)
	// 입력: 사람이름(String)
	// 리턴: void
	public static void removeName(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].equals(name)) {
				names[i] = null;
				totalNum--;
				break;
			}
		}
	}
	
	// 사람 리스트 출력
	// 입력: 무
	// 리턴: 무
	//  ------------------
	//  홍길동
	//  홀길순
	//  ------------------
	//  총: 2명
	public static void printNames() {
		System.out.println("--------------------");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null) {
				System.out.println(names[i]);
			}
		}
		System.out.println("--------------------");
		System.out.println("총: " + totalNum + "명");
		System.out.println();
	}
	
	// 추가 해야할 배열의 위치를 알려주는 함수
	// 입력: 
	// 리턴: 추가 해야할 배열의 위치(인덱스) int
	public static int getCurrentPos() {
		if (totalNum == names.length ) {
			doubleArray();
		}
		
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				return i;
			}
		}

		return -1;
	}
	
	// 배열을 더블로 확장하는 기능
	// 입력: 무
	// 리턴: 무
	public static void doubleArray() {
		String[] newArr = new String[names.length * 2];
		System.arraycopy(names, 0, newArr, 0, names.length);
		
		names = newArr;
	}
}




