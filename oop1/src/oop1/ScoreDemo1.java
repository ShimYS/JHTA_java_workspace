package oop1;

import java.util.Scanner;

public class ScoreDemo1 {

	public static void main(String[] args) {
		/*
		 * 	학생의 이름, 국어, 영어, 수학점수를 입력받아서 배열에 저장한다.
		 * 	배열에 저장된 학생성적정보를 출력할 수 있다.
		 * 	배열에 저장된 학생성적정보를 검색할 수 있다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		Score[] scores = new Score[100];
		int savePosition = 0;
			
		while(true) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("1.조회	2.검색	3.입력	4.수정	0.종료");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("번호를 입력하세요: ");
			int menuNo = scanner.nextInt();
			System.out.println();
			
				
			if(menuNo == 1) {
				System.out.println("이름	국어	영어	수학	총점	평균	합격");
				System.out.println("-----------------------------------------------------");
				for(int i=0; i<savePosition; i++) {
					Score score = scores[i];
					System.out.print(score.studentName + "	");
					System.out.print(score.kor + "	" );	
					System.out.print(score.eng + "	");	
					System.out.print(score.math + "	");	
					System.out.print(score.total + "	");	
					System.out.print(score.average + "	");	
					System.out.print(score.isPassed + "	");
					System.out.println();
				}
			
			} else if(menuNo == 2) {
				System.out.println("[성적정보 검색]");
				
				System.out.print("조회할 이름을 입력하세요: ");
				String name = scanner.next();
				
				Score foundScore = null;	// 객체를 담을 참조변수는 null로 초기화 해야한다.
				for(int i=0; i<savePosition; i++) {
					Score score = scores[i];
					if(name.equals(score.studentName)) {
						foundScore = score;
						break;
					}
				}
				
				if(foundScore != null) {
					System.out.println("------ 검색 결과 ------");
					System.out.println("이	름 :	"+foundScore.studentName + "	");
					System.out.println("국	어 :	"+foundScore.kor + "	" );	
					System.out.println("영	어 :	"+foundScore.eng + "	");	
					System.out.println("수	학 :	"+foundScore.math + "	");	
					System.out.println("총	점 :	"+foundScore.total + "	");	
					System.out.println("평	균 :	"+foundScore.average + "	");	
					System.out.println("합	격 :	"+foundScore.isPassed + "	");
					System.out.println("--------------------");
				} else {
					System.out.println("["+name+"]과 일치하는 학생정보를 찾을 수 없습니다.");
				}
				
				
			} else if(menuNo == 3) {
				System.out.println("[성적정보 입력]");
				System.out.print("이름을 입력하세요:");
				String name = scanner.next();
				
				System.out.print("국어점수를 입력하세요:");
				int kor = scanner.nextInt();
				
				System.out.print("영어점수를 입력하세요:");
				int eng = scanner.nextInt();
				
				System.out.print("수학점수를 입력하세요:");
				int math = scanner.nextInt();
				
				// Score객체를 생성한다.
				Score score = new Score();
										
				// 생성된 Score객체의 각 속성에 입력받은 이름, 국어, 영어, 수학점수를 저장한다.
				score.studentName = name;
				score.kor = kor;
				score.eng = eng;
				score.math = math;
				score.total = kor + eng + math;
				score.average = score.total/3;
				score.isPassed = (score.average >= 60 ? true : false);
				
				// 성적정보가 저장된 Score객체를 위에서 정의한 scores배열에 순서대로 저장한다.
				scores[savePosition] = score;				
				savePosition++;
						
				
			} else if(menuNo == 4) {
				System.out.println("[성적정보 변경]");
				
				System.out.print("성적을 변경할 학생이름을 입력하세요: ");
				String name = scanner.next();
				System.out.print("성적을 변경할 과목명을 입력하세요: ");
				String subject = scanner.next();
				System.out.print("변경된 성적을 입력하세요: ");
				int changeScore = scanner.nextInt();
				
				// scores배열에서 이름과 일치하는 학생을 찾는다.
				Score foundScore = null;
				for(int i=0; i<savePosition; i++) {
					Score score = scores[i];
					if(name.equals(score.studentName)) {
						foundScore = score;
						break;
					}
				}
				
				// foundScore가 null이 아니라면 입력한 과목명에 해당 점수를 변경한다.
				// 과목명이 "국어"라면 foundScore의 kor값을 변경하고,
				// 과목명이 "영어"라면 foundScore의 eng값을 변경하고,
				// 과목명이 "수학"라면 foundScore의 math값을 변경한다.
				if(foundScore != null) {
					if(subject.equals("kor")) {
						foundScore.kor = changeScore;
					} else if(subject.equals("eng")) {
						foundScore.eng = changeScore;
					} else if(subject.equals("math")) {
						foundScore.math = changeScore;
					} else {
						System.out.println("["+subject+"]와 일치하는 과목정보를 찾을 수 없습니다.");
					}
					foundScore.total = foundScore.kor + foundScore.eng + foundScore.math;
					foundScore.average = foundScore.total/3;
					foundScore.isPassed = (foundScore.average >= 60 ? true : false);
				} else {
					System.out.println("["+name+"]과 일치하는 학생정보를 찾을 수 없습니다.");
				}
				
				
				
			} else if(menuNo == 0) {
				System.out.println("[프로그램을 종료합니다]");
				break;
			}
			
			
			
			
			
			
			
			
			
		}
		
	}

}
