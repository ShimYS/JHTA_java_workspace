package oop2;

import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
	
		Student[] students = new Student[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.조회	2.검색	3.입력	0.종료");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("번호를 입력하세요> ");
			int menuNum = scanner.nextInt();
				
			//학생이름  반  번호  국어점수  영어점수  수학점수  총점  평균 을 화면에 출력하시오
			if(menuNum == 1) {
				System.out.println("[학생정보 조회]");
				
				System.out.println("학생이름	반	번호	국어점수	영어점수	수학점수	총점	평균");
				System.out.println("----------------------------------------------------------");
				for(int i=0; i<savePosition; i++) {
					Student viewStudent = students[i];
					viewStudent.displayStudentInfoForRow();
				}
				
			//이름을 입력받아서 이름과 일치하는 학생을 정보를 화면에 출력하시오
			} else if(menuNum == 2) {
				System.out.println("[학생정보 검색]");
				
				System.out.print("검색할 이름을 입력하세요: ");
				String searchName = scanner.next();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					Student foundStudent = students[i];
					if(searchName.equals(foundStudent.name)) {						
						students[i].displayStudentInfo();
						isFound = true;
					} 					
				}
				
				if(!isFound) {
					System.out.println("학생정보를 찾을 수 없습니다.");
				}
				
			//학생이름, 반, 번호, 국어점수, 영어점수, 수학점수를 입력받아서 Student 객체에 저장하시오.
			} else if(menuNum == 3) {
				System.out.println("[학생정보 입력]");
				
				System.out.print("학생이름을 입력하세요: ");
				String name = scanner.next();
				
				System.out.print("반을 입력하세요: ");
				int ban = scanner.nextInt();
				
				System.out.print("번호를을 입력하세요: ");
				int no = scanner.nextInt();
				
				System.out.print("국어점수를 입력하세요: ");
				int kor = scanner.nextInt();
				
				System.out.print("영어점수를 입력하세요: ");
				int eng = scanner.nextInt();
				
				System.out.print("수학점수를 입력하세요: ");
				int math = scanner.nextInt();
				
				Student saveStudentInfo = new Student();
				saveStudentInfo.name = name;
				saveStudentInfo.ban = ban;
				saveStudentInfo.no = no;
				saveStudentInfo.kor = kor;
				saveStudentInfo.eng = eng;
				saveStudentInfo.math = math;			
				
				students[savePosition] = saveStudentInfo;
				savePosition++;
			
			} else if(menuNum == 0) {
				System.out.println("[학생정보 프로그램을 종료합니다]");
				break;
			} else {
				System.out.println("[번호를 잘못 입력했습니다]");
			}
			
		}
		scanner.close();
	}

}
