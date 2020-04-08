package Quiz;

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/*
		 * 1. ���� 3���� �迭�� ��´�.
		 * 2. ���� 3���� �Է� �޾Ƽ� �迭�� ��´�.
		 * 3. �� �迭�� ���Ѵ�
		 * 	- ��ġ�� ���� ��� ��ġ Strike
		 * 	- ���ڸ� ��ġ Ball
		 * 4. 3Strike�� �Ǹ� ���α׷� ����
		 * 
		 */
		Scanner scanner = new Scanner(System.in);
		// ���� 3�� �迭�� ����
		int[] ranNum = new int[3];		
		int[] userNum = new int[3];
		
		for(int i=0; i<3; i++) {
			ranNum[i] = (int) (Math.random()*9+1);
			System.out.println(ranNum[i]);
		}
		System.out.println();

		// ���� ����
		int count = 0;
		while(true) {
			int strike = 0;
			int ball = 0;
			// ���� 3�� �Է¹ޱ�
			System.out.print("ù��° ���ڸ� �Է��ϼ���:");
			userNum[0] = scanner.nextInt();
			System.out.print("�ι�° ���ڸ� �Է��ϼ���:");
			userNum[1] = scanner.nextInt();
			System.out.print("����° ���ڸ� �Է��ϼ���:");
			userNum[2] = scanner.nextInt();
			
			//���� for�� �ݺ��� ���� �� Strike or Ball�� ���ѹ��� ī��Ʈ �Ǿ�� �Ѵ�.(�ߺ��� ������ �� ����)
			for(int i=0; i<3; i++) {
				boolean isStrike = false;
				boolean isBall = false;
				
				for(int j=0; j<3; j++) {
					if(userNum[j] == ranNum[i] && i == j) {
						isStrike = true;

					} else if(userNum[j] == ranNum[i] && i != j) {
						isBall = true;

					}
				}
				
				if(isStrike) {
					strike++;
				} else if(isBall) {
					ball++;
				}
			}
			
			System.out.println(strike+"S "+ball+"B");
			
			
			if(strike == 3) {
				System.out.println("����");
				break;
			}
			
			count++;
			if(count == 10) {
				System.out.println("����");
				break;
			}
			
		}
		
	}

}
