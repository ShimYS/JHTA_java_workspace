package control;

import java.util.Scanner;

public class WhileDemo3 {

	public static void main(String[] args) {
		// 1~100���� ������ ������ �ϳ� �����Ѵ�.
		// ����ڰ� �Է��� ���ڿ� ������ ������ ���ؼ� up/down�� ǥ���Ѵ�.
		// ����ڰ� �Է�
		
		Scanner scanner = new Scanner(System.in);
		
		// 1~100 ������ ������ ������ �����ؼ� secretNumber�� �����Ѵ�.
		int secretNumber = (int)(Math.random()*100 + 1);
		
		// ����ڰ� ������ ���߱� ���ؼ� ���ڸ� �Է��� Ƚ��
		int inputCount = 0;
		
		while(true) {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int answer = scanner.nextInt();
			
			inputCount+=1;
			
			if(answer == secretNumber) {
				System.out.println("����:"+secretNumber+", �Է�Ƚ��:"+inputCount);
				break;
			} else if(answer>secretNumber) {
				System.out.println("Down");
			} else {
				System.out.println("Up");
			}
		}

	}

}
