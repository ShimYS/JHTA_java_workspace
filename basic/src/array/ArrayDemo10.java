package array;

import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		/*
		 * 숫자 10개를 받아서 인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그 차이를 구하기
		 */
		Scanner scanner = new Scanner(System.in);
		//배열 생성하기
		int[] numbers = new int[10];
		
		// 숫자 10개를 입력받아 배열에 담기
		for(int i=0; i<10; i++) {
			System.out.print("숫자를 입력하세요: ");
			int inputNumber = scanner.nextInt();	
			numbers[i] = inputNumber;
		}
		// 출력할 값을 담는 변수
		int prev = 0;
		int next = 0;
		int gap = 0;
		// 인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그 차이를 구하기
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
		// 결과 출력하기
		System.out.println("숫자1: " + prev + ", 숫자2: " + next + ", 갭: " + gap);

	}

}
