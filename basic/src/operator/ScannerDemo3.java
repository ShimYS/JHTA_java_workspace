package operator;

import java.util.Scanner;

public class ScannerDemo3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * ����, ��ǰ��, ����, ���ż���, �������Ʈ�� �Է¹޴´�.
		 * ��³���
		 * 		����, ��ǰ��, ����, ���ż���, ���Ű���, �������Ʈ, �����ݾ�, ��������Ʈ
		 * 			* �������Ʈ�� ���� �̹� ������ ����Ʈ�� �ִٰ� �����ϰ�, ������ ������ �Է¹޴´�.
		 * 			* ����ݾ��� ���Ű��ݿ��� ����Ʈ ��뷮�� ������ �ݾ��̴�.
		 * 			* ��������Ʈ�� �ǰ���ݾ��� 3%��.
		 */
		
		System.out.print("������ �Է��ϼ���: ");
		String customerName = sc.next();
		
		System.out.print("��ǰ���� �Է��ϼ���: ");
		String productName = sc.next();
		
		System.out.print("������ �Է��ϼ���: ");
		int productPrice = sc.nextInt();
		
		System.out.print("���ż����� �Է��ϼ���: ");
		int buyAmount = sc.nextInt();
		
		System.out.print("����� ����Ʈ�� �Է��ϼ���: ");
		int usedPoint = sc.nextInt();
		
		int totalPrice = productPrice * buyAmount;
		int payment = totalPrice - usedPoint;
		int point = (int)(payment * 0.03);
		
		System.out.println();
		System.out.println("-------- �� ���� --------");
		System.out.println("����:" + customerName);
		System.out.println("��ǰ��:" + productName);
		System.out.println("����:" + productPrice);
		System.out.println("�� �� �� ��:" + buyAmount);
		System.out.println("�ѱ��Ű���:" + totalPrice);
		System.out.println("�Ѱ����ݾ�:" + payment);
		System.out.println("��������Ʈ:" + point);
				
	}
}
