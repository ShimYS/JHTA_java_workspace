package array;

import java.util.Scanner;

public class ArrayDemo11 {

	public static void main(String[] args) {
		/*
		 * ���� 5���� �Է¹޾Ƽ� �迭�� �����Ѵ�.
		 * �迭�� n��°������ �հ踦 ���ο� �迭�� �����ϰ�, �� �迭�� ���� ���� ����Ѵ�.
		 * ��) [3, 5, 11, 7, 4] ---> [3, 8, 19, 26, 30]
		 */
		Scanner scanner = new Scanner(System.in);
		
		int[] src = new int[5];
		int[] dest = new int[5];
		
		for(int i=0; i<src.length; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int inputNumber = scanner.nextInt();
			src[i] = inputNumber;
		}
		
		int total = 0;	
		for(int i=0; i<src.length; i++) {
			total += src[i];
			dest[i] = total;
			
//			dest[i] = total + src[i];
//			total += src[i];
		}
		
		System.out.println("�����迭");
		for(int i=0; i<src.length; i++) {
			System.out.print(src[i]+" ");
		}
		System.out.println();
		
		System.out.println("�հ�迭");
		for(int i=0; i<dest.length; i++) {
			System.out.print(dest[i]+" ");
		}
		
	}

}
