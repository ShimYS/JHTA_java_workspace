package array;

import java.util.Scanner;

public class ArrayDemo8 {

	public static void main(String[] args) {
		/*
		 * 5���� ������ �Է¹޾Ƽ� �� �߿� ���� ū ���� ����Ͻÿ�
		 */	
		
		Scanner scanner = new Scanner(System.in);	
		// �迭 ����
		int[] numbers = new int[5];		
		// 5�� �ݺ��ؼ� ���ڸ� �Է¹ް� �迭�� ���
		for (int i=0; i<5; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int inputNumber = scanner.nextInt();			
			numbers[i] = inputNumber;
		}		
		// �ִ밪�� ������ ���� ���� �� �ʱ�ȭ
		int max = 0;
		// �迭���� ���� ū ���� ã�Ƽ� max�� ���
		for (int i:numbers) {
			if(i > max) {
				max = i;
			}
		}
		// �ִ밪 ����ϱ�
		System.out.println("�ִ밪: " + max);
	}

}
