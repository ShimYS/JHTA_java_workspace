package operator;

import java.util.Scanner;

public class ScannerDemo2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * �л��̸�, ��������, ��������, ���������� �Է¹޴´�.
		 * ��³���
		 * 		�л��̸�, ��������, ��������, ��������, ����, ���, �հݿ���, ���б����޿���
		 * 		* �հݿ��δ� ����� 60�� �̻��� ��츸 "��"�� ��� �׿ܴ� "�ƴϿ�" ���
		 * 		* ���б����޿��δ� ����� 96�� �̻��� ��츸 "��"�� ���, �� �ܴ� "�ƴϿ�" ���
		 */
		
		System.out.print("�л��̸��� �Է��ϼ���: ");
		String name = sc.next();
		
		System.out.print("���������� �Է��ϼ���: ");
		int kor = sc.nextInt();
		
		System.out.print("���������� �Է��ϼ���: ");
		int eng = sc.nextInt();
		
		System.out.print("���������� �Է��ϼ���: ");
		int math = sc.nextInt();
		
		int total = kor + eng + math;
		int avg = (int)(total/3);
		
		String passed = (avg >= 60 ? "��" : "�ƴϿ�");
		String isScholarship = (avg >= 96 ? "��" : "�ƴϿ�");
		
		System.out.println();
		System.out.println("-------- �� ���� --------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t�հݿ���\t���б����޿���");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+passed+"\t"+isScholarship);
		
		System.out.println();
		System.out.println("-------- �� ���� --------");
		System.out.println("�л��̸�: " + name);
		System.out.println("��������: " + kor);
		System.out.println("��������: " + eng);
		System.out.println("��������: " + math);
		System.out.println("��     ��: " + total);
		System.out.println("�������: " + avg);
		System.out.println("�հݿ���: " + passed);
		System.out.println("���б����޿���: " + isScholarship);
		
	}
}
