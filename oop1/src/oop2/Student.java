package oop2;

public class Student {
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	//����°� �ٽ�
	int totalScore() {
		return kor + eng + math;
	}
	
	int averageScore() {
		int total = totalScore();	
		return total/3;
	}
	
	void displayStudentInfo() {
		System.out.println("------ �л����� ------");
		System.out.println("�л��̸�: " + name);
		System.out.println("    ��: " + ban);
		System.out.println("��      ȣ: " + no);
		System.out.println("��������: " + kor);
		System.out.println("��������: " + eng);
		System.out.println("��������: " + math);
		System.out.println("��      ��: " + totalScore());
		System.out.println("��      ��: " + averageScore());
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
