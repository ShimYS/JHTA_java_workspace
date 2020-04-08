package practice;

import java.util.Scanner;

public class StarDemo {
	
	public static void main(String[] args) {		
		/*
		 * 숫자를 입력받고, 숫자크기에 비례하는 마름모를 그려라.
		 */
		
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			Scanner scanner = new Scanner(System.in);
			
			int num = scanner.nextInt();
			
			if(num == 0) {
				System.out.println("종료");
				break;
			}
			
			for(int i=0; i<=1+num; i++) {
				for(int j=0; j<=num-i; j++) {
					System.out.print(" ");
				}
				for(int k=0; k<=2*i; k++) {
					System.out.print("1");
				}
				System.out.println();
			}
			
			for(int i=0; i<=num; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(" ");
				}
				for(int h=0; h<=num-i; h++) {
					System.out.print("2");
				}
				for(int k=0; k<num-i; k++) {
					System.out.print("3");
				}
				System.out.println();
			}
		}
	}
}
