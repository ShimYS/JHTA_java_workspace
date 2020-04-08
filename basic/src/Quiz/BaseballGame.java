package Quiz;

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/*
		 * 1. 난수 3개를 배열에 담는다.
		 * 2. 숫자 3개를 입력 받아서 배열에 담는다.
		 * 3. 두 배열을 비교한다
		 * 	- 위치와 숫자 모두 일치 Strike
		 * 	- 숫자만 일치 Ball
		 * 4. 3Strike가 되면 프로그램 종료
		 * 
		 */
		Scanner scanner = new Scanner(System.in);
		// 난수 3개 배열에 저장
		int[] ranNum = new int[3];		
		int[] userNum = new int[3];
		
		for(int i=0; i<3; i++) {
			ranNum[i] = (int) (Math.random()*9+1);
			System.out.println(ranNum[i]);
		}
		System.out.println();

		// 게임 시작
		int count = 0;
		while(true) {
			int strike = 0;
			int ball = 0;
			// 숫자 3개 입력받기
			System.out.print("첫번째 숫자를 입력하세요:");
			userNum[0] = scanner.nextInt();
			System.out.print("두번째 숫자를 입력하세요:");
			userNum[1] = scanner.nextInt();
			System.out.print("세번째 숫자를 입력하세요:");
			userNum[2] = scanner.nextInt();
			
			//내부 for문 반복이 끝난 후 Strike or Ball이 딱한번만 카운트 되어야 한다.(중복을 제거할 수 있음)
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
				System.out.println("성공");
				break;
			}
			
			count++;
			if(count == 10) {
				System.out.println("실패");
				break;
			}
			
		}
		
	}

}
