package oop2;

import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
	
		Student[] students = new Student[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.��ȸ	2.�˻�	3.�Է�	0.����");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("��ȣ�� �Է��ϼ���> ");
			int menuNum = scanner.nextInt();
				
			//�л��̸�  ��  ��ȣ  ��������  ��������  ��������  ����  ��� �� ȭ�鿡 ����Ͻÿ�
			if(menuNum == 1) {
				System.out.println("[�л����� ��ȸ]");
				
				System.out.println("�л��̸�	��	��ȣ	��������	��������	��������	����	���");
				System.out.println("----------------------------------------------------------");
				for(int i=0; i<savePosition; i++) {
					Student viewStudent = students[i];
					viewStudent.displayStudentInfoForRow();
				}
				
			//�̸��� �Է¹޾Ƽ� �̸��� ��ġ�ϴ� �л��� ������ ȭ�鿡 ����Ͻÿ�
			} else if(menuNum == 2) {
				System.out.println("[�л����� �˻�]");
				
				System.out.print("�˻��� �̸��� �Է��ϼ���: ");
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
					System.out.println("�л������� ã�� �� �����ϴ�.");
				}
				
			//�л��̸�, ��, ��ȣ, ��������, ��������, ���������� �Է¹޾Ƽ� Student ��ü�� �����Ͻÿ�.
			} else if(menuNum == 3) {
				System.out.println("[�л����� �Է�]");
				
				System.out.print("�л��̸��� �Է��ϼ���: ");
				String name = scanner.next();
				
				System.out.print("���� �Է��ϼ���: ");
				int ban = scanner.nextInt();
				
				System.out.print("��ȣ���� �Է��ϼ���: ");
				int no = scanner.nextInt();
				
				System.out.print("���������� �Է��ϼ���: ");
				int kor = scanner.nextInt();
				
				System.out.print("���������� �Է��ϼ���: ");
				int eng = scanner.nextInt();
				
				System.out.print("���������� �Է��ϼ���: ");
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
				System.out.println("[�л����� ���α׷��� �����մϴ�]");
				break;
			} else {
				System.out.println("[��ȣ�� �߸� �Է��߽��ϴ�]");
			}
			
		}
		scanner.close();
	}

}
