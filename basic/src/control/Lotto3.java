package control;

import java.util.Scanner;

public class Lotto3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요 : ");
		int income = scanner.nextInt();
		System.out.println();
		
		int setCount = income/1000;
		
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		
		for(int j=1; j<=setCount; j++) {
			for(int i=1; i<=6; i++) {
				int num = (int)(Math.random()*45+1);
				if (num == n1 || num == n2 || num == n3 || num == n4 || num == n5 || num == n6) {
					i--;
				} else {
					if(i == 1) {
						n1 = num;
					} else if (i == 2) {
						n2 = num;
					} else if (i == 3) {
						n3 = num;
					} else if (i == 4) {
						n4 = num;
					} else if (i == 5) {
						n5 = num;
					} else if (i == 6) {
						n6 = num;
					}
				}
			}
			System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);
			if(j%5==0) {
				System.out.println();
			}
		}
		
	}
}
