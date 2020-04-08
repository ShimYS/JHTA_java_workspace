package oop4;

import java.util.Scanner;

public class ProductDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();
			
		while(true) {
			System.out.println();
			System.out.println("[상품 관리 프로그램]");
			System.out.println("================================================");
			System.out.println("1.조회	2.입고	3.출고	4.검색	0.종료");
			System.out.println("================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[전체 상품 조회]");
				//TODO 서비스의 전체 상품 조회기능을 실행시키시오
				service.printAllProducts();
				
			} else if(menuNo == 2) {
				System.out.println("[신규 및 기존 상품 입고처리]");
				
				System.out.println("================================");
				System.out.println("1.신규상품	2.이월상품	3.재고추가");
				System.out.println("================================");
				
				System.out.print("입고처리 대상을 선택하세요: ");
				int stockMenuNo = scanner.nextInt();
				
				
				if(stockMenuNo == 1) {
					// 상품명, 제조사, 카테고리, 가격, 입고량을 입력받아서 입고처리한다.
					//TODO 서비스의 신규상품 입고기능을 실행시키시오.
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					System.out.print("재고량을 입력하세요: ");
					int stock = scanner.nextInt();
					
					Product product = new Product(name, maker, category, price, stock);
					service.insertProduct(product);
					
				} else if(stockMenuNo == 2) {
					// 상품명, 제조사, 카테고리, 가격, 할인률, 입고량을 입력받아서 처리한다.
					//TODO 서비스의 상품 입고기능을 실행시키시오.
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					System.out.print("재고량을 입력하세요: ");
					int stock = scanner.nextInt();
					System.out.print("할인율을 입력하세요: ");
					double discountRate = scanner.nextDouble();
					
					Product product = new Product(name, maker, category, price, discountRate, stock);
					service.insertProduct(product);
					
				} else if(stockMenuNo == 3) {
					// 상품명, 입고량을 입력받아서 입고처리한다.
					//TODO 서비스의 재고량 증가기능을 실행시키시오.
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("재고량을 입력하세요: ");
					int stock = scanner.nextInt();
					
					service.addProductStock(name, stock);
				}
				
				
			} else if(menuNo == 3) {
				
				System.out.println("[상품 출고처리]");
				// 상품명과 출고량을 입력받아서 출고처리한다.
				//TODO 서비스의 재고량 감소기능을 실행시키시오.
				System.out.print("상품명을 입력하세요: ");
				String name = scanner.next();
				System.out.print("출고량을 입력하세요: ");
				int amount = scanner.nextInt();
				
				service.exportProduct(name, amount);
				
			} else if(menuNo == 4) {
				System.out.println("[상품 검색]");
					
				System.out.println("================================");
				System.out.println("1.이름	2.제조사	3.카테고리	4.가격");
				System.out.println("================================");
				
				System.out.print("검색방식을 선택하세요: ");
				int searchMenuNo = scanner.nextInt();
				
				if(searchMenuNo == 1) {
					// 제목을 입력받아서 상품을 검색하시오.
					//TODO 서비스의 제목검색기능을 실행하시오
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					
					service.printProductByName(name);
					
				} else if(searchMenuNo == 2) {
					// 제조사를 입력받아서 상품을 검색하시오.
					//TODO 서비스의 제조사검색기능을 실행하시오
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					
					service.printProductByMaker(maker);
					
				} else if(searchMenuNo == 3) {
					// 카테고리를 입력받아서 상품을 검색하시오.
					//TODO 서비스의 카테고리검색기능을 실행하시오
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					
					service.printProductByCategory(category);
					
				} else if(searchMenuNo == 4) {
					// 최소가격과 최대가격을 입력받아서 그 가격범위내의 상품을 검색하시오.
					//TODO 서비스의 가격검색기능을 실행하시오
					System.out.print("최소가격을 입력하세요: ");
					int minPrice = scanner.nextInt();
					System.out.print("최대가격을 입력하세요: ");
					int maxPrice = scanner.nextInt();
					
					service.printProductByPrice(minPrice, maxPrice);
				}
				
			} else if(menuNo == 0) {
				System.out.println("[상품 관리 프로그램 종료]");
				break;
			}
			
			
		}
		scanner.close();
	}

}