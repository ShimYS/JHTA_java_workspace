package control;

import java.util.Scanner;

public class ForDemo3 {

	public static void main(String[] args) {
		// ���� 2���� �Է¹޾Ƽ� �� ���� ������ ���ڸ� ���� ���� ���ϱ�
		//��) 10 13
		// 	 10 + 11 + 12 + 13
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ���:");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ���:");
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
