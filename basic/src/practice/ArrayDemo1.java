package practice;

import java.util.Scanner;

public class ArrayDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[][] quiz = {
				{"Chair", "����"},
				{"Computer", "��ǻ��"},
				{"Apple", "���"},
				{"Integer", "����"}
		};
		
		for(int i=0; i<quiz.length; i++) {
			System.out.print(i+1+ "�� ����. "+quiz[i][0]+"�� ����?");
			String answer = scanner.next();
			
			if(answer.equals(quiz[i][1])) {
				System.out.println("�����Դϴ�.");
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}
		}
		
	}

}
