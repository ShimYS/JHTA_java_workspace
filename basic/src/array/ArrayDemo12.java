package array;

import java.util.Scanner;

public class ArrayDemo12 {

	public static void main(String[] args) {
		/*
		 * ��ǰ��, ����, ���ż����� �Է¹޾Ƽ� �� ���Ű����� ����ϴ� ���α׷�
		 */
		Scanner scanner = new Scanner(System.in);
		
		String[] names = new String[3];
		int[] prices = new int[3];
		int[] amounts = new int[3];
		
		for(int i=0; i<names.length; i++) {
			System.out.print("��ǰ���� �Է��ϼ���: ");
			String name = scanner.next();
			System.out.print("������ �Է��ϼ���: ");
			int price = scanner.nextInt();
			System.out.print("���ż����� �Է��ϼ���: ");
			int amount = scanner.nextInt();	
			names[i] = name;
			prices[i] = price;
			amounts[i] = amount;
		}
		
		int totalOrderPrice = 0;
		System.out.println("����	��ǰ��	����	����	���Ű���");
		System.out.println("======================================");
		for(int i=0; i<names.length; i++) {			
			System.out.print(i+1+"\t");
			System.out.print(names[i]+"\t");
			System.out.print(prices[i]+"\t");
			System.out.print(amounts[i]+"\t");
			System.out.println(prices[i] * amounts[i]);
			
			totalOrderPrice += prices[i] * amounts[i];
		}
		System.out.println("======================================");
		System.out.println("�ѱ��Ű���				" + totalOrderPrice);
	}

}
