package control;

import java.util.Scanner;

public class ForDemo3 {

	public static void main(String[] args) {
		// 정수 2개를 입력받아서 두 정수 사이의 숫자를 더한 값을 구하기
		//예) 10 13
		// 	 10 + 11 + 12 + 13
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요:");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요:");
		int num2 = sc.nextInt();
		
		int sum = 0;
		
		if(num1 > num2) {
			for(int i=num2; i<=num1; i++) {
				sum += i;
			}
			System.out.println(sum);
		} else {
			for(int i=num1; i<=num2; i++) {
				sum += i;
			}
			System.out.println(sum);
		}
		
			
	}

}
