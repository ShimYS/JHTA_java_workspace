package practice;

import java.util.Scanner;

public class ArrayDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[][] quiz = {
				{"Chair", "의자"},
				{"Computer", "컴퓨터"},
				{"Apple", "사과"},
				{"Integer", "정수"}
		};
		
		for(int i=0; i<quiz.length; i++) {
			System.out.print(i+1+ "번 문제. "+quiz[i][0]+"의 뜻은?");
			String answer = scanner.next();
			
			if(answer.equals(quiz[i][1])) {
				System.out.println("정답입니다.");
			} else {
				System.out.println("틀렸습니다.");
			}
		}
		
	}

}
