package collection.demo;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Product;

public class ProductApp {

	public static void main(String[] args) {
		
		ProductRepository repo = new ProductRepository();
			
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("============================");
				System.out.println("1.전체조회	2.검색	3.등록	0종료");
				System.out.println("============================");
				
				System.out.print("메뉴를 선택하세요: ");
				int menuNo = scanner.nextInt();
				if (menuNo == 1) {
					System.out.println("[전체 상품 조회]");
					ArrayList<Product> products = repo.getAllProducts();
					if(products.isEmpty()) {
						System.out.println("조회된 상품이 없습니다.");
					}
					System.out.println("상품번호\t상품명\t가격");
					for(Product product : products) {
						System.out.print(product.getNo() +"\t");
						System.out.print(product.getName() +"\t");			
						System.out.println(product.getPrice());
					}
					
				} else if (menuNo == 2) {
					System.out.println("[상품 검색]");
					System.out.println("1.상품번호로 검색	2.키워드로 검색");
					int searchMenuNo = scanner.nextInt();
					
					if(searchMenuNo == 1) {
						System.out.println("[상품번호로 검색]");
						System.out.print("상품번호를 입력하세요: ");
						int productNo = scanner.nextInt();
						Product product = repo.getProductByNo(productNo);
						if(product == null) {
							System.out.println("입력한 번호와 일치하는 상품이 없습니다.");
						}
						System.out.println("상품번호: " + product.getNo());
						System.out.println("상 품 명 : " + product.getName());
						System.out.println("제 조 사 : " + product.getMaker());
						System.out.println("가      격: " + product.getPrice());
						System.out.println("제조일자: " + product.getCreateDate());
						
					} else if(searchMenuNo == 2) {
						System.out.println("[상품명으로 검색]");
						System.out.print("키워드를 입력하세요: ");
						String keyword = scanner.next();
						ArrayList<Product> products = repo.searchProducts(keyword);
						if(products.isEmpty()) {
							System.out.println("["+keyword+"] 검색어에 해당하는 상품을 찾을 수 없습니다.");
						} else {
							System.out.println("전체 ["+ products.size() +"]건이 검색되었습니다.");
						}
						System.out.println("상품번호\t상품명\t가격");
						for(Product product : products) {
							System.out.print(product.getNo() +"\t");
							System.out.print(product.getName() +"\t");			
							System.out.println(product.getPrice());
						}
					}
						
				} else if (menuNo == 3) {
					System.out.println("[신규 상품 등록]");
					
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					
					Product product = new Product();
					product.setName(name);
					product.setMaker(maker);
					product.setPrice(price);
					
					repo.insertProduct(product);
					System.out.println("### 신규상품이 등록되었습니다 ###");
					
				} else if (menuNo == 0) {
					System.out.println("[프로그램 종료]");
					break;
				}
			} catch(Exception e) {
				System.out.println("### 메인 메뉴로 되돌아 갑니다 ###");
			}
		}
	}
}
