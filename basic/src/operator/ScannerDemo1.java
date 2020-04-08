package operator;

import java.util.Scanner;

public class ScannerDemo1 {
	
	public static void main(String[] args) {
		// Scanner sc -> ���� sc��  Scanner ���赵�� ������ ��ü�� �ּҰ��� ��� ������. 
		// new Scaner(System.in) -> new�� Scanner���赵�� ��ü�� �����ϰ�,
		// 							��ü�� �ּҰ��� sc�� �����Ѵ�.
		//							System.in�� ǥ���Է���ġ(Ű����)�̴�.
		// ����, Ű���� �Է��� ��ĵ�ϴ� ��ü�� ������ ���̴�.
		Scanner sc = new Scanner(System.in);
		
		/*
		 * ��ǰ��, ����, ���ż���, ������� �Է¹޴´�.
		 * ��³���
		 * 	   ��ǰ��, ����, ���ż���, �����, ���Ű���, ��������Ʈ�� ����Ѵ�.
		 * 	   * ��������Ʈ�� �÷�Ƽ�� ���� 5%����, �׿ܴ� 3%�����Ѵ�.
		 */
		
		System.out.print("��ǰ���� �Է��ϼ��� : ");
		String productName = sc.next();
		
		System.out.print("������ �Է��ϼ��� : ");
		int price = sc.nextInt();
		
		System.out.print("���ż����� �Է��ϼ��� : ");
		int amount = sc.nextInt();
		
		System.out.print("���� ����� �Է��ϼ���(�Ϲ�, �ξ�, �÷�Ƽ�� �� �ϳ�) : ");
		String grade = sc.next();
		
		int orderPrice = price * amount;
		int point = grade.equals("�÷�Ƽ��") ? (int)(orderPrice*0.05) : (int)(orderPrice*0.03);
	
		System.out.println();
		System.out.println("------ �� ���� ------");
		System.out.println("�� ǰ ��: " + productName);
		System.out.println("��     ��: " + price);
		System.out.println("���ż���: " + amount);
		System.out.println("�����: " + grade);
		System.out.println("���űݾ�: " + price*amount);
		System.out.println("�� �� Ʈ: " + point);
		
		
		
	}
}
