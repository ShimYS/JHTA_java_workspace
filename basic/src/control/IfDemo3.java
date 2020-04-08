package control;

import java.util.Scanner;

public class IfDemo3 {
	
	public static void main(String[] args) {
		/*
		 *	if ~ else if ~ else if ~ else 문
		 *	3개 이상의 경우의 수를 처리해야 할 때 사용되는 조건문이다.
		 *	if (조건1) {
		 *		수행문; => 조건1이 true일때
		 *	} else if (조건2) {
		 *		수행문; => 조건2가 true일때
		 *	} else if (조건3) {
		 *		수행문; => 조건3이 true일때
		 *	} else {
		 *		수행문; => 조건1,2,3 모두 false일때
		 *	}
		 */
		
		/*
		 * 구매금액이 500만원 이상인 경우 10만원 상품권 지급
		 * 		  100만원 이상인 경우 1만원 상품권 지급
		 * 		  50만원 이상인 경우 커피쿠폰 지급
		 * 		    그 외는 주차할인권 지급
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매 금액을 입력하세요 : ");
		int orderPrice = sc.nextInt();
		
		if(orderPrice >= 5000000) {
			System.out.println("10만원 상품권 지급");
		} else if (orderPrice >= 1000000) {
			System.out.println("1만원 상품권 지급");
		} else if (orderPrice > 500000) {
			System.out.println("커피쿠폰 지급");
		} else {
			System.out.println("주차할인권 지급");
		}
		
	}
}
