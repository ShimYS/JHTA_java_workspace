package control;

import java.util.Scanner;

public class IfDemo4 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * ���� ���(�Ϲ�, �ξ�, �÷�Ƽ�� �� �ϳ�)�� �ѱ��űݾ��� �Է¹޴´�.
		 * ���� ����� �÷�Ƽ���� ��� ���űݾ��� 10%�� �����Ѵ�.
		 * 			�ξ��� ��� ���űݾ��� 3%�� �����Ѵ�.
		 * 			�Ϲ��� ��� ���űݾ��� 1%�� �����Ѵ�.
		 * ����ݾ��� �ѱ��űݾ׿��� ���ε� �ݾ׸�ŭ�� ������ �ݾ��̴�.
		 * ��������Ʈ�� ����ݾ��� 3%�� �����Ѵ�.
		 * 
		 * ��³����� 
		 * 		�ѱ��űݾ�, �����, ���ε� �ݾ�, ������ �ݾ�, ������ ����Ʈ
		 */
		
		System.out.print("�ѱ��űݾ��� �Է��ϼ���:");
		int totalPrice = scanner.nextInt();
		
		System.out.print("���� ����� �Է��ϼ���:");
		String userGrade = scanner.next();
						
		int discountPrice = 0;
		int payTotalPrice = 0;
		int depositPoint = 0;
		
		if(userGrade.equals("�÷�Ƽ��")) {
			discountPrice = (int) (totalPrice * 0.1);			
		} else if(userGrade.equals("�ξ�")) {
			discountPrice = (int) (totalPrice * 0.03);
		} else if(userGrade.equals("�Ϲ�")) {
			discountPrice = (int) (totalPrice * 0.01);
		}
		
		payTotalPrice = totalPrice - discountPrice;
		depositPoint = (int)(payTotalPrice * 0.03);
		
		System.out.println();
		System.out.println("----- �� ���� -----");
		System.out.println("�ѱ��űݾ�:"+totalPrice);
		System.out.println("��   ���:"+userGrade);
		System.out.println("����   �ݾ�:"+discountPrice);
		System.out.println("����   �ݾ�:"+payTotalPrice);
		System.out.println("��������Ʈ:"+depositPoint);
		
	}
}
