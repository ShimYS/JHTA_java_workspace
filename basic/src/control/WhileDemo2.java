package control;

import java.util.Scanner;

public class WhileDemo2 {

	public static void main(String[] args) {
		
		// 1���� ���ڸ� �ϳ��� ���ذ� ��
		// ���ʷ� ����ڰ� ������ �� �̻��� �Ǵ� ���ڴ� �����ΰ�?
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ���:");
		int max = sc.nextInt();
		int sum = 0;
		
		int number = 1;	
		while(true) {
			sum += number;
			System.out.println("["+sum+"] ---> "+ number);
			if(sum >= max) {
				
				System.out.println("�հ�:" + sum +", ����:"+number);
				break;
			}
			number++;
		}
	}
}
