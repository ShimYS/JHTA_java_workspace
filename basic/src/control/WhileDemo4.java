package control;

import java.util.Scanner;

public class WhileDemo4 {

	public static void main(String[] args) {
		// 10000 ~ 99999 ������ ������ ������ �Է��ϼ���.
		// ��) �Է°� : 12132 -----> ��°� 1 + 2 + 1 + 3 + 2 = 9
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ 5�ڸ� ���ڸ� �Է��ϼ���(10000 ~ 99999): ");
		int inputNumber = sc.nextInt();
		
		int sum = 0;
		
		while(inputNumber != 0) {
			int lastNumber = inputNumber % 10;
			sum += lastNumber;
			inputNumber = inputNumber / 10;	
		}
		System.out.println("�հ�: "+sum);
		
	}

}
