package array;

import java.util.Scanner;

public class ArrayDemo7 {

	public static void main(String[] args) {
		// 숫자를 5번 입력받아서 입력받은 숫자의 총합을 계산하기
		
		// 키보드 입력받기
		Scanner scanner = new Scanner(System.in);
			
		int[] numbers = new int[5];	// 숫자 5개를 입력받는 배열 생성하기
		
		// 숫자 5번 입력받기
		for(int i=0; i<numbers.length; i++) {
			System.out.print("숫자를 입력하세요: ");
			
			int inputNumber = scanner.nextInt();	// 입력받은 숫자를 변수에 저장하기
						
			numbers[i] = inputNumber;	// 변수에 저장된 값을 배열에 담기
		}
				
		int total = 0;		// 입력받은 숫자들의 총합 계산하기
		for(int i:numbers) {
			total += i;
		}
		
		System.out.println("총합: " + total);
		
	}

}
