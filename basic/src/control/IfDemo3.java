package control;

import java.util.Scanner;

public class IfDemo3 {
	
	public static void main(String[] args) {
		/*
		 *	if ~ else if ~ else if ~ else ��
		 *	3�� �̻��� ����� ���� ó���ؾ� �� �� ���Ǵ� ���ǹ��̴�.
		 *	if (����1) {
		 *		���๮; => ����1�� true�϶�
		 *	} else if (����2) {
		 *		���๮; => ����2�� true�϶�
		 *	} else if (����3) {
		 *		���๮; => ����3�� true�϶�
		 *	} else {
		 *		���๮; => ����1,2,3 ��� false�϶�
		 *	}
		 */
		
		/*
		 * ���űݾ��� 500���� �̻��� ��� 10���� ��ǰ�� ����
		 * 		  100���� �̻��� ��� 1���� ��ǰ�� ����
		 * 		  50���� �̻��� ��� Ŀ������ ����
		 * 		    �� �ܴ� �������α� ����
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ݾ��� �Է��ϼ��� : ");
		int orderPrice = sc.nextInt();
		
		if(orderPrice >= 5000000) {
			System.out.println("10���� ��ǰ�� ����");
		} else if (orderPrice >= 1000000) {
			System.out.println("1���� ��ǰ�� ����");
		} else if (orderPrice > 500000) {
			System.out.println("Ŀ������ ����");
		} else {
			System.out.println("�������α� ����");
		}
		
	}
}
