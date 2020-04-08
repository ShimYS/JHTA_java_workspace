package array;

import java.util.Scanner;

public class ArrayDemo14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// ������ ���� 3���� �����ϴ� �迭
		int[] secretNumbers = new int[3];
		// ����ڰ� �Է��� ���� 3���� �����ϴ� �迭
		int[] inputNumbers = new int[3];
		
		// 1~9 ������ ���ڸ�  secretNumbers�� ������� �����ϱ�
		for(int i=0; i<secretNumbers.length; i++) {
			int randomNumber = (int)(Math.random()*9 + 1);
			
			// secretNumbers�� �ߺ��� ���ڰ� ������� �ʰ� �ϱ�
			boolean isExist = false;
			for(int j=0; j<i; j++) {
				// ���� �߻��� ������ secretNumbers�� �迭�� ���� ������� ���Ѵ�.
				if(secretNumbers[j] == randomNumber) {
					//������ ���ڰ� �߰ߵǸ� isExist�� true�� �����ϰ�,
					//���ڸ� ���ϴ� for���� Ż���Ѵ�.
					isExist = true;
					break; //�Ȱ����� �߰ߵǴ� ��� For�� Ż��
				}
			}
			//isExist�� false�� �ߺ�����, isExitst�� true�� �ߺ��� �߻���
			if(isExist) {
				//�̹��� ���� ������ �ߺ��� �߻������Ƿ� �ٽ� �̹�ȸ���� �̱� ���� i�� 1���ҽ�Ŵ
				i--;
			} else {
				//�ߺ��� �����Ƿ� ������ �迭�� ����
				secretNumbers[i] = randomNumber;
			}
		}
		int tryCount = 1;
		while(true) {
			if(tryCount > 10) {
				System.out.println("���� - �õ� Ƚ���� 10ȸ�� �Ѿ����ϴ�!");
				break;
			}
			
			System.out.print("ù��° ���ڸ� �Է��ϼ���:");
			inputNumbers[0] = scanner.nextInt();
			System.out.print("�ι�° ���ڸ� �Է��ϼ���:");
			inputNumbers[1] = scanner.nextInt();
			System.out.print("����° ���ڸ� �Է��ϼ���:");
			inputNumbers[2] = scanner.nextInt();
			
			int strikeCount = 0;
			int ballCount = 0;
			for(int i=0; i<inputNumbers.length; i++) {
				for(int j=0; j<secretNumbers.length; j++) {
					if(inputNumbers[i] == secretNumbers[j]) {
						if(i == j) {
							strikeCount++;
						} else {
							ballCount++;
						}
					}
				}
			}
			System.out.println("�Է°�: " + inputNumbers[0] + " " + inputNumbers[1] + " " + inputNumbers[2]);
			System.out.println("��°�: " + strikeCount + "S " + ballCount + "B");
			if(strikeCount == 3) {
				System.out.println("�����Դϴ�. �õ�Ƚ���� �� " + tryCount +"ȸ �Դϴ�.");
				break;
			}
			
			tryCount++;
		}

	}

}

