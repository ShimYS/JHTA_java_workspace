package array;

import java.util.Scanner;

public class ArrayDemo11 {

	public static void main(String[] args) {
		/*
		 * 숫자 5개를 입력받아서 배열에 저장한다.
		 * 배열의 n번째까지의 합계를 새로운 배열에 저장하고, 새 배열의 값을 전부 출력한다.
		 * 예) [3, 5, 11, 7, 4] ---> [3, 8, 19, 26, 30]
		 */
		Scanner scanner = new Scanner(System.in);
		
		int[] src = new int[5];
		int[] dest = new int[5];
		
		for(int i=0; i<src.length; i++) {
			System.out.print("숫자를 입력하세요: ");
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
		
		System.out.println("원본배열");
		for(int i=0; i<src.length; i++) {
			System.out.print(src[i]+" ");
		}
		System.out.println();
		
		System.out.println("합계배열");
		for(int i=0; i<dest.length; i++) {
			System.out.print(dest[i]+" ");
		}
		
	}

}
