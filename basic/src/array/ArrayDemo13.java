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
			System.out.println("[�������� ���α׷�]");
			System.out.println("[1.��ȸ\t2.�˻�\t3.�Է�\t0.����]");			
			System.out.print("�޴�����> ");
			int menu = scanner.nextInt();
			System.out.println();
			
			//  [����]
			if(menu == 0) {
				break;
			
			//  [������ȸ]
			} else if (menu == 1) {
				System.out.println("[���� ��ȸ]");
				System.out.println("����	�̸�	����	����	����	����	���");
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
			
			//  [�����˻�]
			} else if (menu == 2) {
				System.out.println("[���� �˻�]");
				System.out.print("��ȸ�� �л��̸��� �Է��ϼ���: ");
				String searchName = scanner.next();
				int index = -1; //���� ���� �� ���� �迭��ȣ�� �־�����Ѵ�.
				
				for(int i=0; i<savePosition; i++) {
					if(searchName.equals(names[i])) {
						index = i;
						break;
					}
				}
				
				if(index != -1) {
					System.out.println("����	�̸�	����	����	����	����	���");
					System.out.println("===================================================");
					System.out.print(index+1+"\t");
					System.out.print(names[index]+"\t");
					System.out.print(korArr[index]+"\t");
					System.out.print(engArr[index]+"\t");
					System.out.print(mathArr[index]+"\t");
					System.out.print(totalArr[index]+"\t");
					System.out.println(avgArr[index]+"\t");
				} else {
					System.out.println("'"+searchName+"'�� ��ġ�ϴ� ���������� �������� �ʽ��ϴ�.");
				}
				
			//  [�����Է�]	
			} else if (menu == 3) {
				System.out.println("[���� �Է�]");
				
				System.out.print("�̸��� �Է��ϼ���:");
				String name = scanner.next();				
				System.out.print("������� �Է��ϼ���:");
				int kor = scanner.nextInt();				
				System.out.print("������� �Է��ϼ���:");
				int eng = scanner.nextInt();				
				System.out.print("���м����� �Է��ϼ���:");
				int math = scanner.nextInt();
				
				names[savePosition] = name;
				korArr[savePosition] = kor;
				engArr[savePosition] = eng;
				mathArr[savePosition] = math;
				totalArr[savePosition] = korArr[savePosition] + engArr[savePosition] + mathArr[savePosition];
				avgArr[savePosition] = (int)(totalArr[savePosition]/3);
				
				System.out.println(savePosition+1+"�� ���� ������ ����Ǿ����ϴ�");
				savePosition++;
			
			//  [���]
			} else {
				System.out.println("0, 1, 2, 3�� �޴��߿� ����ּ���.");
			}
		}
		System.out.println("[�������� ���α׷�]�� �����մϴ�.");
	}

}
