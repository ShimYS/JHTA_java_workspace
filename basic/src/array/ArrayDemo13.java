package array;

import java.util.Scanner;

public class ArrayDemo13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] names = new String[20];
		int[] korArr = new int[20];
		int[] engArr = new int[20];
		int[] mathArr = new int[20];
		int[] totalArr = new int[20];
		int[] avgArr = new int[20];
		int savePosition = 0;

		while(true) {
			System.out.println();
			System.out.println("[성적관리 프로그램]");
			System.out.println("[1.조회\t2.검색\t3.입력\t0.종료]");			
			System.out.print("메뉴선택> ");
			int menu = scanner.nextInt();
			System.out.println();
			
			//  [종료]
			if(menu == 0) {
				break;
			
			//  [성적조회]
			} else if (menu == 1) {
				System.out.println("[성적 조회]");
				System.out.println("순번	이름	국어	영어	수학	총점	평균");
				System.out.println("===================================================");
				for(int i=0; i<savePosition; i++) {
					System.out.print(i+1+"\t");
					System.out.print(names[i]+"\t");
					System.out.print(korArr[i]+"\t");
					System.out.print(engArr[i]+"\t");
					System.out.print(mathArr[i]+"\t");
					System.out.print(totalArr[i]+"\t");
					System.out.println(avgArr[i]+"\t");
				}
			
			//  [성적검색]
			} else if (menu == 2) {
				System.out.println("[성적 검색]");
				System.out.print("조회할 학생이름을 입력하세요: ");
				String searchName = scanner.next();
				int index = -1; //절대 나올 수 없는 배열번호를 넣어줘야한다.
				
				for(int i=0; i<savePosition; i++) {
					if(searchName.equals(names[i])) {
						index = i;
						break;
					}
				}
				
				if(index != -1) {
					System.out.println("순번	이름	국어	영어	수학	총점	평균");
					System.out.println("===================================================");
					System.out.print(index+1+"\t");
					System.out.print(names[index]+"\t");
					System.out.print(korArr[index]+"\t");
					System.out.print(engArr[index]+"\t");
					System.out.print(mathArr[index]+"\t");
					System.out.print(totalArr[index]+"\t");
					System.out.println(avgArr[index]+"\t");
				} else {
					System.out.println("'"+searchName+"'과 일치하는 성적정보가 존재하지 않습니다.");
				}
				
			//  [성적입력]	
			} else if (menu == 3) {
				System.out.println("[성적 입력]");
				
				System.out.print("이름을 입력하세요:");
				String name = scanner.next();				
				System.out.print("국어성적을 입력하세요:");
				int kor = scanner.nextInt();				
				System.out.print("영어성적을 입력하세요:");
				int eng = scanner.nextInt();				
				System.out.print("수학성적을 입력하세요:");
				int math = scanner.nextInt();
				
				names[savePosition] = name;
				korArr[savePosition] = kor;
				engArr[savePosition] = eng;
				mathArr[savePosition] = math;
				totalArr[savePosition] = korArr[savePosition] + engArr[savePosition] + mathArr[savePosition];
				avgArr[savePosition] = (int)(totalArr[savePosition]/3);
				
				System.out.println(savePosition+1+"번 성적 정보가 저장되었습니다");
				savePosition++;
			
			//  [경고]
			} else {
				System.out.println("0, 1, 2, 3번 메뉴중에 골라주세요.");
			}
		}
		System.out.println("[성적관리 프로그램]을 종료합니다.");
	}

}
