package array;

import java.util.Scanner;

public class ArrayDemo7 {

	public static void main(String[] args) {
		// ���ڸ� 5�� �Է¹޾Ƽ� �Է¹��� ������ ������ ����ϱ�
		
		// Ű���� �Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
			
		int[] numbers = new int[5];	// ���� 5���� �Է¹޴� �迭 �����ϱ�
		
		// ���� 5�� �Է¹ޱ�
		for(int i=0; i<numbers.length; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			
			int inputNumber = scanner.nextInt();	// �Է¹��� ���ڸ� ������ �����ϱ�
						
			numbers[i] = inputNumber;	// ������ ����� ���� �迭�� ���
		}
				
		int total = 0;		// �Է¹��� ���ڵ��� ���� ����ϱ�
		for(int i:numbers) {
			total += i;
		}
		
		System.out.println("����: " + total);
		
	}

}
