package control;

import java.util.Scanner;

public class BreakDemo {

	public static void main(String[] args) {
		//break
		// �ݺ����� Ż���Ѵ�. for��, while�� �ȿ��� ���ȴ�.
		
		// ���� �Է��� �ֻ��� ���ڿ� ������ ���ڰ� ������ Ż��
		Scanner scanner = new Scanner(System.in);
		
		for(;;) {
			System.out.print("���ڸ� �Է��ϼ���(1~6):");
			int myNumber = scanner.nextInt();			
			int randomNumber = (int)(Math.random()*6+1);
			
			System.out.println("["+myNumber+", "+randomNumber+"]");
			
			if(myNumber == randomNumber) {
				System.out.println("���� Ż���մϴ�.");
				break;
			} 
		}

	}

}
