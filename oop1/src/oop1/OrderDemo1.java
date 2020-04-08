package oop1;

import java.util.Scanner;

public class OrderDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
			
		while(true) {
			//시작페이지 + 메뉴 출력 및 입력받기
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("1.조회	2.검색	3.입력	4.종료");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("번호를 입력하세요: ");
			int menuNo = scanner.nextInt();
			System.out.println();
			
			//<메뉴 1 : 조회>
			if(menuNo == 1) {
				System.out.println("[고객 주문내용 조회]");
								
				if(savePosition == 0) {
					System.out.println("고객 주문내용이 존재하지 않습니다.");
				} else {
					System.out.println("고객명	고객등급	총구매금액	적립포인트	사은품");
					System.out.println("-----------------------------------------------------");
					for(int i=0; i<savePosition; i++) {
						Order order = new Order();
						order = orders[i];
						
						System.out.print(order.name+"	");
						System.out.print(order.grade+"	");
						System.out.print(order.price+"	");
						System.out.print(order.point+"	");
						System.out.println(order.gift+"	");
					}
				}
							
			//<메뉴 2 : 검색>		
			} else if(menuNo == 2) {				
				//검색 조건 입력받기
				System.out.println("[고객 주문내용 검색]");
				System.out.print("검색조건을 입력하세요(N:이름, G:사은품):");
				String option = scanner.next();
				System.out.print("조건값을 입력하세요:");
				String text = scanner.next();
				
//				//검색조건:고객명  => 입력받기
//				if(option.equals("N")) {
//					System.out.print("검색할 고객명을 입력하세요: ");
//					System.out.println();
//					String name = scanner.next();
//					
//					Order foundOrder = null;
//					for(int i=0; i<savePosition; i++) {
//						Order order = orders[i];
//						if(name.equals(order.name)) {
//							foundOrder = order;
//						} 
//					}
//					System.out.println("고객명: "+foundOrder.name+"\t");
//					System.out.println("고객등급: "+foundOrder.grade+"\t");
//					System.out.println("총구매금액: "+foundOrder.price+"\t");
//					System.out.println("적립포인트: "+foundOrder.point+"\t");
//					System.out.println("사은품: "+foundOrder.gift+"\t");
//				
//				//검색조건:상품명  => 입력받기
//				} else if(option.equals("G")) {
//					System.out.print("검색할 상품을 입력하세요(숙박권, 상품권, 할인권, 주차권): ");
//					System.out.println();
//					String gift = scanner.next();
//					int savePointer = 0;
//					
//					Order[] foundGift = new Order[100];
//					for(int i=0; i<savePosition; i++) {
//						Order giftCheck = orders[i];
//						
//						if(gift.equals(giftCheck.gift)) {
//							foundGift[savePointer] = giftCheck;
//							savePointer++;
//						}
//					}
//					
//					for(int i=0; i<savePointer; i++) {
//						Order order = new Order();
//						order = foundGift[i];
//						System.out.println("고객명: "+order.name+"\t");
//						System.out.println("고객등급: "+order.grade+"\t");
//						System.out.println("총구매금액: "+order.price+"\t");
//						System.out.println("적립포인트: "+order.point+"\t");
//						System.out.println("사은품: "+order.gift+"\t");
//						System.out.println();
//					}
//				
//				//검색조건 잘못입력 경고 메시지 출력
//				} else {
//					System.out.println("["+option+"]과 일치하는 검색조건을 찾을 수 없습니다.");
//				}
				
				
				
				
				
				//쌤 버전
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					Order order = orders[i];
					if(option.equals("N") && text.equals(order.name)) {
						isFound = true;
					} else if(option.equals("G") && text.equals(order.gift)) {
						isFound = true;
					} else {
						isFound = false;
					}
					
					if(isFound) {
						System.out.println("고객명: "+order.name+"\t");
						System.out.println("고객등급: "+order.grade+"\t");
						System.out.println("총구매금액: "+order.price+"\t");
						System.out.println("적립포인트: "+order.point+"\t");
						System.out.println("사은품: "+order.gift+"\t");
						System.out.println();
					}
				}
				
				// 질문 : 출력후 'isFound'를 'false'로 바꿔줘야 하는거 아닌지? 
				
				
				
				
				
				
				
			//<메뉴 3 : 입력>	
			} else if(menuNo == 3) {				
				System.out.println("[고객정보 입력]");
				
				//고객정보 입력 받기
				System.out.print("고객의 이름을 입력하세요: ");
				String name = scanner.next();				
				System.out.print("고객의 등급을 입력하세요(프리미어, 에이스, 베스트, 클래식): ");
				String grade = scanner.next();				
				System.out.print("구매 금액을 입력하세요: ");
				int price = scanner.nextInt();
				
				//객체생성
				Order order = new Order();				
				order.name = name;
				order.grade = grade;
				order.price = price;
				
				//포인트 계산
				if(grade.equals("프리미어")) {
					order.point = (int)(price * 0.05);				
				} else if(grade.equals("에이스")) {
					order.point = (int)(price * 0.03);					
				} else if(grade.equals("베스트")) {
					order.point = (int)(price * 0.02);				
				} else if(grade.equals("클래식")) {
					order.point = (int)(price * 0.01);					
				}
				
				//선물 선정
				if(price>=5000000) {
					order.gift = "숙박권";					
				} else if(price>=1000000) {
					order.gift = "상품권";					
				} else if(price>=500000) {
					order.gift = "할인권";					
				} else {
					order.gift = "주차권";
				}				
				
				//객체배열에 정리된 값 입력 및 배열 자리이동
				orders[savePosition] = order;
				savePosition++;
			
			//<메뉴 4 : 종료>
			} else if(menuNo == 4) {
				System.out.println("[프로그램을 종료합니다]");
				break;
			
			//<메뉴 번호 잘못입력>
			} else {
				System.out.println("["+menuNo+"]과 일치하는 메뉴정보를 찾을 수 없습니다.");
			}
			
		}
		scanner.close(); // 자원을 반납(읽기쓰기자원)하여 resource leak을 제거
		
	}

}
