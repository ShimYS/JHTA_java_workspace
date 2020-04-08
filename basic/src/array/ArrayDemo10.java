package array;

import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		/*
		 * ���� 10���� �޾Ƽ� ������ ���ڵ鰣�� ���̸� ����ؼ� ���� ���̰� ū ���ڿ� �� ���̸� ���ϱ�
		 */
		Scanner scanner = new Scanner(System.in);
		//�迭 �����ϱ�
		int[] numbers = new int[10];
		
		// ���� 10���� �Է¹޾� �迭�� ���
		for(int i=0; i<10; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int inputNumber = scanner.nextInt();	
			numbers[i] = inputNumber;
		}
		// ����� ���� ��� ����
		int prev = 0;
		int next = 0;
		int gap = 0;
		// ������ ���ڵ鰣�� ���̸� ����ؼ� ���� ���̰� ū ���ڿ� �� ���̸� ���ϱ�
		for(int j=0; j<numbers.length-1; j++) {
			int currentPrev = numbers[j];
			int currentNext = numbers[j+1];
			int currentGap = Math.abs( currentPrev - currentNext );
			
			if(currentGap > gap) {
				gap = currentGap;
				prev = currentPrev;
				next = currentNext;
			} 			 
		}
		// ��� ����ϱ�
		System.out.println("����1: " + prev + ", ����2: " + next + ", ��: " + gap);

	}

}
