package control;

import java.util.Scanner;

public class Gugudan1 {

	public static void main(String[] args) {
		// ���ڸ� �Է¹޾Ƽ� �ش� ���ڿ� ���� �������� ����ϱ�
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("����� �������� ���� �Է��ϼ���:");
		int dan = scanner.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}

	}

}
