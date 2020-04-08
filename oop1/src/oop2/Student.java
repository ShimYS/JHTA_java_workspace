package oop2;

public class Student {
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	//만드는거 다시
	int totalScore() {
		return kor + eng + math;
	}
	
	int averageScore() {
		int total = totalScore();	
		return total/3;
	}
	
	void displayStudentInfo() {
		System.out.println("------ 학생정보 ------");
		System.out.println("학생이름: " + name);
		System.out.println("    반: " + ban);
		System.out.println("번      호: " + no);
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("총      점: " + totalScore());
		System.out.println("평      균: " + averageScore());
		System.out.println("-------------------");
	}
	
	void displayStudentInfoForRow() {
		System.out.print(name+"\t");
		System.out.print(ban+"\t");
		System.out.print(no+"\t");
		System.out.print(kor+"\t");
		System.out.print(eng+"\t");
		System.out.print(math+"\t");
		System.out.print(totalScore()+"\t");
		System.out.println(averageScore()+"\t");
	}
}
