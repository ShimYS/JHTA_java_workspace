package control;

import java.util.Scanner;

public class SwitchDemo1 {
	
	public static void main(String[] args) {
		
		/*
		 * switch��
		 * 		�񱳰��� ��ġ�ϴ� �پ��� ����� ���� ������ ǥ������ ó���� �� �ִ�.
		 * 		switch(�񱳰�){
		 * 			case ��1:
		 * 				���๮; -> �񱳰��� ��1�� ��ġ�ϴ� ��� ����Ǵ� ���๮
		 * 				break;
		 * 			case ��2:
		 * 				���๮; -> �񱳰��� ��2�� ��ġ�ϴ� ��� ����Ǵ� ���๮
		 * 				break;
		 * 			case ��3:
		 * 				���๮; -> �񱳰��� ��3�� ��ġ�ϴ� ��� ����Ǵ� ���๮
		 * 				break;
		 * 			default:
		 * 				���๮; -> �񱳰��� ���õ� ���� ��ġ�ϴ� ���� ���� �� ����Ǵ� ���๮
		 * 		}
		 * 		* �񱳰����� ����, ����, ���ڿ��� ��� �����ϴ�.
		 * 		* case�� ���õ� ���� ��� Ȥ�� ���ͷ����̾�� �Ѵ�.
		 * 		* break���� 
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("����� �Է��ϼ���:");
		String grade = scanner.next();
		
		switch(grade) {
			case "vvip":
				System.out.println("vvip���� �湮�� ȯ���մϴ�.");
				System.out.println("������ 10�� ���� �����̾� ������ ������ �ֽ��ϴ�.");
				break;
			case "vip":
				System.out.println("vip���� �湮�� ȯ���մϴ�.");
				System.out.println("������ 30�� ���� ��� �ı⼼Ʈ ������ �ֽ��ϴ�.");
				break;
			case "classic":
				System.out.println("classic���� �湮�� ȯ���մϴ�.");
				System.out.println("������ 50�� ���� �鸶��ũ ������ �ֽ��ϴ�.");
				break;
			default:
				System.out.println("�մ� �湮�� ȯ���մϴ�.");
				System.out.println("������ 100�� ���� ���������� ��簡 �ֽ��ϴ�.");			
		}
		
		if(grade.equals("vvip")) {
			System.out.println("vvip���� �ȳ��� ������.");
		} else if(grade.equals("vip")) {
			System.out.println("vip���� �ȳ��� ������.");
		} else if(grade.equals("classic")) {
			System.out.println("classic���� �ȳ��� ������.");
		} else {
			System.out.println("�մ� �ȳ��� ������.");
		}
	}
}
