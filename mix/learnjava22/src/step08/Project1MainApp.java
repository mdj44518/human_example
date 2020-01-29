package step08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project1MainApp {
	final static int MAX_TODO_SIZE = 500;
	static String[][] todos = new String[MAX_TODO_SIZE][4];
	//static int currentIdx = 0;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 일정 초기화
		initTodo();
		
		// 사용법 출력
		printGuide();
		
		// 메인 루프
		
		char cmd;
		do {
			System.out.print("커맨드 입력(가이드출력[g]): ");
			String cmdLine = scanner.nextLine();
			cmd = cmdLine.toLowerCase().charAt(0);
			
			switch (cmd) {
			case 'i':
				System.out.println("일정 추가");
				procInsert();
				break;
			case 'd':
				System.out.println("일정 삭제");
				procDelete();
				break;
			case 's':
				System.out.println("일정 검색");
				procSearch();
				break;
			case 'u':
				System.out.println("일정 변경");
				procUpdate();
				break;
			case 'g':
				System.out.println("가이드 출력");
				printGuide();
				break;
			case 'q':
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 명령입니다");
				break;
			}
		} while (cmd != 'q');

	}

	// 초기 일정 삽입
	public static void initTodo() {
		String[][] initData = {
				{"청소하기", "2019-01-02", "2019-01-03", "0"},
				{"study Java", "2019-01-03", "2019-01-05", "0"},
				{"buy java book", "2019-02-15", "2019-02-16", "1"},
				{"study english", "2019-02-15", "2019-03-17", "0"},
		};
		
		for (int i = 0; i < initData.length; i++) {
			int idx = getAvailableIndex();
			todos[idx][0] = initData[i][0];
			todos[idx][1] = initData[i][1];
			todos[idx][2] = initData[i][2];
			todos[idx][3] = initData[i][3];
		}
	}
	
	// 가이드 출력
	public static void printGuide() {
		printClear();
		System.out.println("\t================");
		System.out.println("\t일정관리 프로그램");
		System.out.println("\t----------------");
		System.out.println("\t일정 추가: \'i\'");
		System.out.println("\t일정 삭제: \'d\'");
		System.out.println("\t일정 검색: \'s\'");
		System.out.println("\t일정 변경: \'u\'");
		System.out.println("\t가이드 출력: \'g\'");
		System.out.println("\t종료: \'q\'");
		System.out.println("\t----------------");
		System.out.println("\n\n");
	}
	
	private static void printClear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	public static int getAvailableIndex() {
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] == null) {
				return i;
			}
		}
		
		// 빈공간이 없는 상태
		return -1;
	}
	
	////////////////////////////////////////////
	// 검색관련 함수
	public static void procSearch() {
		printClear();
		System.out.println("\t----------------");
		System.out.println("\t검색 서브 메뉴를 선택하세요");
		System.out.println("\t----------------");
		System.out.println("\t전체일정 출력: \'a\'");
		System.out.println("\t오늘 완료일정: \'t\'");
		System.out.println("\t미완료 일정: \'m\'");
		System.out.println("\t일정설명 쿼리: \'q\'");
		System.out.println("\n\n");
		char ch;
		
		while (true) {
			System.out.print("검색 모드: ");
			String mode = scanner.nextLine();
			ch = mode.toLowerCase().charAt(0);
			
			if (ch == 'a') {
				printAllTodos();
				break;
			} else if (ch == 't') {
				printTodayTodos();	
				break;
			} else if (ch == 'm') { 
				printNotDoneTodos();
				break;
			} else if (ch == 'q') {
				System.out.print("검색어: ");
				String search = scanner.nextLine();
				printTodos(search);
				break;
			} else {
				System.out.println("잘못된 모드 입니다. 다시 입력해주세요");
			}
		}
		
	}
	
	public static void printAllTodos() {
		printClear();
		System.out.println("\t----------------");
		System.out.println("\t전체 일정 리스트");
		System.out.println("\t-------------------------");
		String header = "\t일정 설명 (완료일) [완료시:\u26CC]";
		System.out.println(header);
		System.out.println("\t-------------------------");
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] != null) {
				System.out.printf("\t%s", todos[i][0]);
				System.out.printf(" (%s) ", todos[i][2].substring(5));
				String done = todos[i][3].equals("1") ? "\u26CC" : "";
				System.out.printf("%s\n", done);
			}
		}
		System.out.println("\t-------------------------");
		System.out.println("\n\n");
	}
	
	public static void printTodayTodos() {
		printClear();
		
		LocalDate today = LocalDate.now();
		String tdStr = today.format(DateTimeFormatter.ofPattern("MM-dd"));
		System.out.println("\t----------------");
		System.out.println("\t오늘 완료일정 리스트");
		System.out.println("\t-------------------------");
		String header = "\t일정 설명 (완료일) [완료시:\u26CC]";
		System.out.println(header);
		System.out.println("\t-------------------------");
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] != null && tdStr.equals(todos[i][2].substring(5))) {
				System.out.printf("\t%s", todos[i][0]);
				System.out.printf(" (%s) ", todos[i][2].substring(5));
				String done = todos[i][3].equals("1") ? "\u26CC" : "";
				System.out.printf("%s\n", done);
			}
		}
		System.out.println("\t-------------------------");
		System.out.println("\n\n");
	}
	
	public static void printNotDoneTodos() {
		printClear();
		
		System.out.println("\t----------------");
		System.out.println("\t미완료 일정 리스트");
		System.out.println("\t-------------------------");
		String header = "\t일정 설명 (완료일)";
		System.out.println(header);
		System.out.println("\t-------------------------");
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] != null && todos[i][3].equals("0")) {
				System.out.printf("\t%s", todos[i][0]);
				System.out.printf(" (%s)\n", todos[i][2].substring(5));
			}
		}
		System.out.println("\t-------------------------");
		System.out.println("\n\n");
	}
	
	public static void printTodos(String s) {
		printClear();
		
		System.out.println("\t----------------");
		System.out.println("\t검색 일정 리스트");
		System.out.println("\t-------------------------");
		String header = "\t일정 설명 (완료일) [완료시:\u26CC]";
		System.out.println(header);
		System.out.println("\t-------------------------");
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] != null && todos[i][0].contains(s)) {
				System.out.printf("\t%s", todos[i][0]);
				System.out.printf(" (%s) ", todos[i][2].substring(5));
				String done = todos[i][3].equals("1") ? "\u26CC" : "";
				System.out.printf("%s\n", done);
			}
		}
		System.out.println("\t-------------------------");
		System.out.println("\n\n");
	}
	////////////////////////////////////////////
	
	////////////////////////////////////////////
	// 추가관련 함수
	public static void procInsert() {
		printClear();
		
		System.out.println("\t----------------");
		System.out.println("\t일정을 추가 하세요");
		System.out.println("\t----------------");
		System.out.println("\n\n");
		
		System.out.print("일정설명: ");
		String desc = scanner.nextLine();
		
		String dDay = "";
		while (true) {
			System.out.print("완료일 [0(오늘), 숫자(오늘로 부터 며칠)]: ");
			dDay = scanner.nextLine();
			if (!isValidNum(dDay)) {
				System.out.println("잘못 입력하였습니다");
			} else {
				break;
			}
		}
		
		// 일정 삽입
		int idx = getAvailableIndex();
		if (idx == -1) {
			return;
		}
		
		LocalDate today = LocalDate.now();
		todos[idx][0] = desc;
		todos[idx][1] = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		todos[idx][2] = today.plusDays(Integer.parseInt(dDay)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		todos[idx][3] = "0";
		
		printClear();
		System.out.println("\t일정 추가를 성공하였습니다.\n\n");
	}
	
	////////////////////////////////////////////
	// 삭제관련 함수
	public static void procDelete() {
		printTodoList();

		int index = -1;
		while (true) {
			System.out.print("삭제할 인덱스: ");
			String line = scanner.nextLine();
			
			if (isValidNum(line)) {
				index = Integer.parseInt(line);
				if (todos[index][0] == null) {
					System.out.println("잘못 입력하였습니다.");
				} else {
					break;
				}
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		// 해당 인덱스 값 null처리
		todos[index][0] = null;
		todos[index][1] = null;
		todos[index][2] = null;
		todos[index][3] = null;
		
		printClear();
		System.out.println("\t일정 삭제를 성공하였습니다.\n\n");
	}
	
	public static void printTodoList() {
		printClear();
		
		System.out.println("\t----------------");
		System.out.println("\t전체 일정 리스트");
		System.out.println("\t-------------------------");
		String header = "\t[인덱스] 일정 설명 (생성일, 완료일) [완료시:\u26CC]";
		System.out.println(header);
		System.out.println("\t-------------------------");
		for (int i = 0; i < MAX_TODO_SIZE; i++) {
			if (todos[i][0] != null) {
				System.out.printf("\t[ %d ] ", i);
				System.out.printf("%s", todos[i][0]);
				System.out.printf(" (%s, ", todos[i][1].substring(5));
				System.out.printf("%s) ", todos[i][2].substring(5));
				String done = todos[i][3].equals("1") ? "\u26CC" : "";
				System.out.printf("%s\n", done);
			}
		}
		System.out.println("\t-------------------------");
		System.out.println("\n\n");
	}
	
	////////////////////////////////////////////
	// 변경관련 함수
	public static void procUpdate() {
		printTodoList();
		
		int index = -1;
		while (true) {
			System.out.print("변경할 인덱스: ");
			String line = scanner.nextLine();
			
			if (isValidNum(line)) {
				index = Integer.parseInt(line);
				
				if (todos[index][0] == null) {
					System.out.println("잘못 입력하였습니다.");
				} else {
					break;
				}
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		
		
		System.out.print("일정설명: ");
		String desc = scanner.nextLine();
		
		String dDay = "";
		while (true) {
			System.out.print("완료일 [0(오늘), 숫자(오늘로 부터 며칠)]: ");
			dDay = scanner.nextLine();
			if (!isValidNum(dDay)) {
				System.out.println("잘못 입력하였습니다");
			} else {
				break;
			}
		}
		
		if (desc.length() > 0) {
			todos[index][0] = desc;
		}
		
		LocalDate today = LocalDate.now();
		
		todos[index][1] = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		todos[index][2] = today.plusDays(Integer.parseInt(dDay)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		todos[index][3] = "0";
		
		printClear();
		System.out.println("\t일정 변경을 성공하였습니다.\n\n");
	}
	
	////////////////////////////////////////
	// 일반 유틸리티 함수
	public static boolean isValidNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
}
