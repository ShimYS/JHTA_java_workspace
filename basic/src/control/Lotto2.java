package control;

import java.util.Scanner;

public class Lotto2 {

	public static void main(String[] args) {		
		/*
		 * �ݾ��� �Է¹޴´�.
		 * �ݾ��� 1000�� ������ ���� �Է¹޴´�.
		 * �ζǹ�ȣ�� �Էµ� �ݾ׸�ŭ �����Ѵ�.
		 * 1000���� 1��Ʈ
		 */
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�ݾ��� �Է��ϼ���(���� : õ��) : ");		
		int money = scanner.nextInt();
		
		int setCount = money/1000;
		int makeNumberCount = setCount*6;
		
		for(int i=1; i<=makeNumberCount; i++) {
			int num = (int)(Math.random()*45+1);
			System.out.print(num+" ");
			if(i%6 == 0) {
				System.out.println();
			}
			if(i%30 == 0) {
				System.out.println();
			}
		}
	}

}
