package app;

import java.util.Scanner;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

//1. 이름
// 2. 전공 (500)
// 3. 주소
// 4. 아이디 
// 5. 비밀번호

// 6. 학생번호: 숫자로 된 고유한 값 (사용자 정하는 것이 아니고
//    내부적으로 발생되는 고유키)
//    500-xxx
// 7. email

// 기능 (C.R.U.D)
// 사용자 추가 (Create)
// 사용자 조회 (Read)
// 사용자 변경 (Update)
// 사용자 삭제 (Delete)
public class StudentRegisterApp {
	
	static Scanner scan = new Scanner(System.in);
	static StudentDAO dao = new StudentDAOImpl();
	
	public static void main(String[] args) {
		
		char cmd = '0';
		while (cmd != 'q') {
			System.out.println("등록(r) / 삭제(d) / 변경(u)/ 종료(q) ");
			cmd = Character.toLowerCase(scan.nextLine().charAt(0));
			
			switch (cmd) {
			case 'r':
				procRegister();
				break;
			case 'd':
				procDelete();
				break;
			case 'u':
				break;
			case 'q':
				break;
			}
		}
		
		
	}

	private static void procDelete() {
		System.out.println("학생 삭제");

		// student id
		// jitaek hehe
		System.out.print("아이디: ");
		String sId = scan.nextLine().split("\\s+")[0];
			
		// student password
		System.out.print("비밀번호: ");
		String sPw = scan.nextLine().split("\\s+")[0];
		
		if (dao.validateUser(sId, sPw)) {
			if (dao.deleteUser(sId)) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제가 실패");
			}
		} else {
			System.out.println("로그인 실패. 다시 시도");
		}
		
	}

	private static void procRegister() {
		Student st = new Student("", "");
		System.out.println("등록 정보를 입력");
		
		// student id
		// jitaek hehe
		while (true) {
			System.out.print("아이디: ");
			String sId = scan.nextLine().split("\\s+")[0];
			if (!dao.existsUserId(sId)) {
				st.setsId(sId);
				break;
			}
			System.out.println("아이디가 중복. 다시 입력");
		}
		
		// student password
		System.out.print("비밀번호: ");
		st.setsPw(scan.nextLine().split("\\s+")[0]);
		
		// student name
		System.out.print("이름: ");
		st.setsName(scan.nextLine());
		
		// studnet major
		while (true) {
			System.out.print("전공: ");
			try {
				int sMajor = Integer.parseInt(scan.nextLine().split("\\s+")[0]);
				st.setsMajor(sMajor);
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력. 다시 입력");
			}
		}
		
		// student birthday
		while (true) {
			System.out.print("생년월일(YYYY-MM-DD: ");
			String birthStr = scan.nextLine().split("\\s+")[0];
			String[] tokens = birthStr.split("-");
			
			if (tokens.length == 3) {
				try {
					for (int i = 0; i < 3; i++) {
						int temp = Integer.parseInt(tokens[i]);
					}
					st.setsBirthDate(birthStr);
					break;
				} catch (Exception e) {
					System.out.println("잘못 입력. 다시 입력");
				}
			} else {
				System.out.println("잘못 입력. 다시 입력");
			}
		}
		
		if(dao.createUser(st)) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패 다시 시도");
		}
	}

}









