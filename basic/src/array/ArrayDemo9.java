package array;

import java.util.Scanner;

public class ArrayDemo9 {
	
	public static void main(String[] args) {
		/*
		 * ���ڸ� 10�� �Է¹޾Ƽ� �� �߿� ¦������ �հ踸 ���ؼ� ����ϱ�
		 */
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[10];
		
		for(int i=0; i<numbers.length; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int inputNumber = scanner.nextInt();
			numbers[i] = inputNumber;
		}
		
		int total = 0;
		for(int num:numbers) {
			if(num%2 == 0) {
				total += num;
			}
		}
		System.out.println("¦���� ��: " + total);
	}
}
