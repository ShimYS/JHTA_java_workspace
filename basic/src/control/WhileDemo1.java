package control;

import java.util.Scanner;

public class WhileDemo1 {

	public static void main(String[] args) {
		
		/*
		 * 	while(���ǽ�){
		 * 		���ǽ��� true�� ������ ���� ����Ǵ� ���๮;
		 * 	}
		 */
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("���ڸ� �Է��ϼ���:");
			int number = scanner.nextInt();
			
			// ���ѹݺ� Ż������
			if(number == 0) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			
			System.out.println("�Է��� ��ȣ�� "+number+"�Դϴ�.");
		}
	}

}
