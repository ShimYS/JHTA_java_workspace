package practice;

import java.util.Scanner;

public class StarDemo {
	
	public static void main(String[] args) {		
		/*
		 * ���ڸ� �Է¹ް�, ����ũ�⿡ ����ϴ� ������ �׷���.
		 */
		
		while(true) {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			Scanner scanner = new Scanner(System.in);
			
			int num = scanner.nextInt();
			
			if(num == 0) {
				System.out.println("����");
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
