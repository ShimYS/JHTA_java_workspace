package control;

import java.util.Scanner;

public class Lotto2 {

	public static void main(String[] args) {		
		/*
		 * 금액을 입력받는다.
		 * 금액은 1000원 단위의 값만 입력받는다.
		 * 로또번호를 입력된 금액만큼 발행한다.
		 * 1000원당 1세트
		 */
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요(단위 : 천원) : ");		
		int money = scanner.nextInt();
		
		int setCount = money/1000;
		int makeNumberCount = setCount*6;
		
		for(int i=1; i<=makeNumberCount; i++) {
			int num = (int)(Math.random()*45+1);
			System.out.print(num+" ");
			if(i%6 == 0) {
				System.out.println();
			}
			if(i%30 == 0) {
				System.out.println();
			}
		}
	}

}
