package control;

import java.util.Scanner;

public class WhileDemo2 {

	public static void main(String[] args) {
		
		// 1부터 숫자를 하나씩 더해갈 때
		// 최초로 사용자가 지정한 값 이상이 되는 숫자는 무엇인가?
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요:");
		int max = sc.nextInt();
		int sum = 0;
		
		int number = 1;	
		while(true) {
			sum += number;
			System.out.println("["+sum+"] ---> "+ number);
			if(sum >= max) {
				
				System.out.println("합계:" + sum +", 숫자:"+number);
				break;
			}
			number++;
		}
	}
}
