package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.GoodsDAOImpl;
import dao.DDAO;
import model.Company;
import model.Goods;

public class GoodsRegisterApp {
	
	// 기능 (C.R.U.D)
	// 사용자 추가 (Create)
	// 사용자 조회 (Read)
	// 사용자 변경 (Update)
	// 사용자 삭제 (Delete)
	
	static GoodsDAOImpl dao;
	static Scanner scan;
	
	public static void main(String[] args) {
		dao = new GoodsDAOImpl();
		if (GoodsDAOImpl.isReady()) {
			scan = new Scanner(System.in);
			char choice = '0';
			while (choice != 'q') {
				System.out.print("상품등록(c) / 업체등록(j) / 조회(r) / 삭제(d) / 변경(u) / 아무거나넣기(m) / 종료(q) : ");
				choice = Character.toLowerCase(scan.nextLine().charAt(0));
				switch (choice){
				case 'c':
					createGoods();
					break;
				case 'j':
					createCompany();
					break;
				case 'r':
					read();
					break;
				case 'd':
					// 코드에 맞는 상품정보 보여주고 맞는지 확인시키기?
					System.out.print("상품코드를 입력해주세요 : ");
					String goodsCode = scan.nextLine();
					if (dao.deleteGoods(goodsCode)) {
						System.out.println("삭제 완료");
					} else {
						System.out.println("삭제 실패");
					}
					break;
				case 'u':
					update();
					break;
				case 'm':
					System.out.println("DB에 상품을 아무렇게나 넣습니다. 몇개 넣을까요? : ");
					String test = scan.nextLine();
					try {
						addRandomGoods(Integer.parseInt(test));
					} catch (Exception e){
						
					}
					break;
				case 'q':
					System.out.println(dao.endApp() ? "정상 종료되었습니다." : "DB 연결해제 실패");
					break;
				default :
					System.out.println("잘못된 명령어업니다.");
					break;
				}
			}
		} else {
			System.out.println("DB 접근 실패. 종료합니다.");
		}
	}

	private static void addRandomGoods(int num) {
		for (int i = 0; i < num; i++) {
			dao.addGoods(GoodsMgrUtil.getNewGoods());
		}
		
	}

	private static void createCompany() {
		Company company = new Company();
		System.out.println("====업체 등록====");
		while (true) {
			System.out.print("업체코드 입력 : ");
			String test = scan.nextLine();
			if ((test instanceof Object) && incomplete()) {
				company.setCompanycode(test);
				break;
			} else {
				System.out.println("올바른 코드형식이 아닙니다. 다시시도.");
			}
		}
		
		while (true) {
			System.out.print("업체명 입력 : ");
			String test = scan.nextLine();
			if ((test instanceof Object) && incomplete()) {
				company.setCompanyname(test);
				break;
			} else {
				System.out.println("올바른 형식이 아닙니다. 다시시도.");
			}
		}
		
		System.out.println(dao.addCompany(company) ? "등록성공" : "등록실패");
		
	}

	private static boolean incomplete() {
		// TODO Auto-generated method stub
		return true;
	}

	private static void read() {
		char cho = '0';
		while (cho != 'q') {
			System.out.print("상품조회(1), 조건조회(2), 나가기(q) : ");
			cho = scan.nextLine().charAt(0);
			switch (cho) {
			case '1':
				System.out.print("조회할 상품의 코드를 입력해주세요. : ");
				String test = scan.nextLine();
				// 판독.. 메소드.. 
				if (test.length() < 100) {
					System.out.println(dao.readGoods(test));
				} else {
					System.out.println("잘못된 코드입니다.");
				}
				break;
			case '2':
				System.out.println("최고의제품(1), 분기별 최고매출제품(2), 나가기(q)");
				char cho2 = scan.nextLine().charAt(0);
				switch (cho2) {
				case '1':
					System.out.println(DDAO.bestGoods());
					break;
				case '2':
					char cho3 = '0';
					while (!(cho3 >= '1' && cho3 <= '4')) {
						System.out.print("몇분기 최고의 제품을 찾으시나요?(1~4) : ");
						String scanStr = scan.nextLine();
						if (scanStr.length() == 1) {
							cho3 = scanStr.charAt(0);
						}
						if (cho3 >= '1' && cho3 <= '4') {
							System.out.println(DDAO.qBestGoods(cho3 - '0'));
						} else {
							System.out.println("정확히 입력해주세요.");
						}
					}
					break;
				case 'q':
					break;
				default :
					break;
				}
				break;
			case 'q':
				break;
			default :
				System.out.println("잘못된 명령어입니다.");
				break;
			}
		}
	}

	private static void update() {
		char cho = '0';
		while (cho != 'q') {
			System.out.println("변경할 상품의 상품코드를 입력해주세요 : ");
			String test = scan.nextLine();
			Goods goods = dao.readGoods(test);
			if (goods != null) {
				System.out.println(goods);
				while (cho != 'q') {
					System.out.println("변경할 목록을 선택하세요");
					System.out.println("(1)상품명 / (2)상품코드 / (3)Q1 / (4)Q2 / (5)Q3 / (6)Q4 / (7)업체코드 / (q)종료 : ");
					cho = scan.nextLine().charAt(0);
					switch(cho) {
					case '1':
						System.out.print("변경할 상품명 : ");
						test = scan.nextLine();
						// 판독하자아
						if (test.length() < 100) {
//							dao.choiceUpdate(test, GoodsDAOImpl.List.GNAME);
						}
						break;
					case '2':
						break;
					case '3':
						break;
					case '4':
						break;
					case '5':
						break;
					case '6':
						break;
					case '7':
						break;
					case 'q':
						break;
					default :
						System.out.println("잘못된 명령어입니다.");
						break;
					}
				}
			} else {
				System.out.println("해당코드의 상품이 존재하지 않습니다.");
			}
		}
		
	}

	private static void createGoods() {
		Goods goods = new Goods();
		String test = "";
		System.out.println("===상품등록===");
		while (true) {
			System.out.print("상품명 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setGoodsName(test);
				break;
			} else {
				System.out.println("사용불가능한 명칭입니다. 다시 입력해주세요");
			}
		}
		while (true) {
			System.out.print("상품코드 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setGoodsCode(test);
				break;
			} else {
				System.out.println("올바르지 않은 코드입니다. 다시 입력해주세요");
			}
		}
		while (true) {
			System.out.print("1분기 판매량 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setQ1_selling(Integer.parseInt(test));
				break;
			} else {
				System.out.println("올바른 판매량을 입력해주세요.");
			}
		}
		while (true) {
			System.out.print("2분기 판매량 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setQ2_selling(Integer.parseInt(test));
				break;
			} else {
				System.out.println("올바른 판매량을 입력해주세요.");
			}
		}
		while (true) {
			System.out.print("3분기 판매량 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setQ3_selling(Integer.parseInt(test));
				break;
			} else {
				System.out.println("올바른 판매량을 입력해주세요.");
			}
		}
		while (true) {
			System.out.print("4분기 판매량 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setQ4_selling(Integer.parseInt(test));
				break;
			} else {
				System.out.println("올바른 판매량을 입력해주세요.");
			}
		}
		while (true) {
			System.out.print("업체코드 : ");
			test = scan.nextLine();
			//판독 메소드 만들기
			if (test.length() < 100) {
				goods.setCompanyCode(test);
				break;
			} else {
				System.out.println("등록된 업체코드가 아닙니다.");
			}
		}
		System.out.println(dao.addGoods(goods) ? "등록성공" : "등록실패");
	}

}
