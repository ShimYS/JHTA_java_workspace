package control;

import java.util.Scanner;

public class IfDemo2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���ڸ� �Է¹޾Ƽ� ¦���� ���� "¦��", �ƴ� ���� "Ȧ��"��� ǥ���ϱ�
		// ¦���� 2�� �����.
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int number = sc.nextInt();
		
		if (number%2 == 0) {
			System.out.println("["+number+"]�� ¦���Դϴ�.");
		} else {
			System.out.println("["+number+"]�� Ȧ���Դϴ�.");
		}
		
	}
	
}
