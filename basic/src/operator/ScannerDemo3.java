package operator;

import java.util.Scanner;

public class ScannerDemo3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 * 출력내용
		 * 		고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결제금액, 적립포인트
		 * 			* 사용포인트는 고객이 이미 적립한 포인트가 있다고 가정하고, 임의의 값으로 입력받는다.
		 * 			* 결재금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 * 			* 적립포인트는 실결재금액의 3%다.
		 */
		
		System.out.print("고객명을 입력하세요: ");
		String customerName = sc.next();
		
		System.out.print("상품명을 입력하세요: ");
		String productName = sc.next();
		
		System.out.print("가격을 입력하세요: ");
		int productPrice = sc.nextInt();
		
		System.out.print("구매수량을 입력하세요: ");
		int buyAmount = sc.nextInt();
		
		System.out.print("사용할 포인트를 입력하세요: ");
		int usedPoint = sc.nextInt();
		
		int totalPrice = productPrice * buyAmount;
		int payment = totalPrice - usedPoint;
		int point = (int)(payment * 0.03);
		
		System.out.println();
		System.out.println("-------- 상세 정보 --------");
		System.out.println("고객명:" + customerName);
		System.out.println("상품명:" + productName);
		System.out.println("가격:" + productPrice);
		System.out.println("구 매 수 량:" + buyAmount);
		System.out.println("총구매가격:" + totalPrice);
		System.out.println("총결제금액:" + payment);
		System.out.println("적립포인트:" + point);
				
	}
}
