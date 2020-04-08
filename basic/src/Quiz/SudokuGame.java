package Quiz;

import java.util.Scanner;

public class SudokuGame {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("스도쿠의 크기를 입력하세요: ");
		int sudokuNum = scanner.nextInt();
		
		int[][] sudoku = new int[sudokuNum][sudokuNum];
		while(true) {
			int ranNum = (int)(Math.random()*sudokuNum + 1);
			// x축검사
			
			
			// y축검사
			
			
			// x, y축 모두 중복 없을시 해당 배열에 ranNum 입력
			
			
			// 출력
			
			
		}
	}
}
