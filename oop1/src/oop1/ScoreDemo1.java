package oop1;

import java.util.Scanner;

public class ScoreDemo1 {

	public static void main(String[] args) {
		/*
		 * 	�л��� �̸�, ����, ����, ���������� �Է¹޾Ƽ� �迭�� �����Ѵ�.
		 * 	�迭�� ����� �л����������� ����� �� �ִ�.
		 * 	�迭�� ����� �л����������� �˻��� �� �ִ�.
		 */
		
		Scanner scanner = new Scanner(System.in);
		Score[] scores = new Score[100];
		int savePosition = 0;
			
		while(true) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("1.��ȸ	2.�˻�	3.�Է�	4.����	0.����");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("��ȣ�� �Է��ϼ���: ");
			int menuNo = scanner.nextInt();
			System.out.println();
			
				
			if(menuNo == 1) {
				System.out.println("�̸�	����	����	����	����	���	�հ�");
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
				System.out.println("[�������� �˻�]");
				
				System.out.print("��ȸ�� �̸��� �Է��ϼ���: ");
				String name = scanner.next();
				
				Score foundScore = null;	// ��ü�� ���� ���������� null�� �ʱ�ȭ �ؾ��Ѵ�.
				for(int i=0; i<savePosition; i++) {
					Score score = scores[i];
					if(name.equals(score.studentName)) {
						foundScore = score;
						break;
					}
				}
				
				if(foundScore != null) {
					System.out.println("------ �˻� ��� ------");
					System.out.println("��	�� :	"+foundScore.studentName + "	");
					System.out.println("��	�� :	"+foundScore.kor + "	" );	
					System.out.println("��	�� :	"+foundScore.eng + "	");	
					System.out.println("��	�� :	"+foundScore.math + "	");	
					System.out.println("��	�� :	"+foundScore.total + "	");	
					System.out.println("��	�� :	"+foundScore.average + "	");	
					System.out.println("��	�� :	"+foundScore.isPassed + "	");
					System.out.println("--------------------");
				} else {
					System.out.println("["+name+"]�� ��ġ�ϴ� �л������� ã�� �� �����ϴ�.");
				}
				
				
			} else if(menuNo == 3) {
				System.out.println("[�������� �Է�]");
				System.out.print("�̸��� �Է��ϼ���:");
				String name = scanner.next();
				
				System.out.print("���������� �Է��ϼ���:");
				int kor = scanner.nextInt();
				
				System.out.print("���������� �Է��ϼ���:");
				int eng = scanner.nextInt();
				
				System.out.print("���������� �Է��ϼ���:");
				int math = scanner.nextInt();
				
				// Score��ü�� �����Ѵ�.
				Score score = new Score();
										
				// ������ Score��ü�� �� �Ӽ��� �Է¹��� �̸�, ����, ����, ���������� �����Ѵ�.
				score.studentName = name;
				score.kor = kor;
				score.eng = eng;
				score.math = math;
				score.total = kor + eng + math;
				score.average = score.total/3;
				score.isPassed = (score.average >= 60 ? true : false);
				
				// ���������� ����� Score��ü�� ������ ������ scores�迭�� ������� �����Ѵ�.
				scores[savePosition] = score;				
				savePosition++;
						
				
			} else if(menuNo == 4) {
				System.out.println("[�������� ����]");
				
				System.out.print("������ ������ �л��̸��� �Է��ϼ���: ");
				String name = scanner.next();
				System.out.print("������ ������ ������� �Է��ϼ���: ");
				String subject = scanner.next();
				System.out.print("����� ������ �Է��ϼ���: ");
				int changeScore = scanner.nextInt();
				
				// scores�迭���� �̸��� ��ġ�ϴ� �л��� ã�´�.
				Score foundScore = null;
				for(int i=0; i<savePosition; i++) {
					Score score = scores[i];
					if(name.equals(score.studentName)) {
						foundScore = score;
						break;
					}
				}
				
				// foundScore�� null�� �ƴ϶�� �Է��� ����� �ش� ������ �����Ѵ�.
				// ������� "����"��� foundScore�� kor���� �����ϰ�,
				// ������� "����"��� foundScore�� eng���� �����ϰ�,
				// ������� "����"��� foundScore�� math���� �����Ѵ�.
				if(foundScore != null) {
					if(subject.equals("kor")) {
						foundScore.kor = changeScore;
					} else if(subject.equals("eng")) {
						foundScore.eng = changeScore;
					} else if(subject.equals("math")) {
						foundScore.math = changeScore;
					} else {
						System.out.println("["+subject+"]�� ��ġ�ϴ� ���������� ã�� �� �����ϴ�.");
					}
					foundScore.total = foundScore.kor + foundScore.eng + foundScore.math;
					foundScore.average = foundScore.total/3;
					foundScore.isPassed = (foundScore.average >= 60 ? true : false);
				} else {
					System.out.println("["+name+"]�� ��ġ�ϴ� �л������� ã�� �� �����ϴ�.");
				}
				
				
				
			} else if(menuNo == 0) {
				System.out.println("[���α׷��� �����մϴ�]");
				break;
			}
			
			
			
			
			
			
			
			
			
		}
		
	}

}
