package control;

public class IfDemo5 {
	
	public static void main(String[] args) {
		// ��ø if��
		// if���� ��ϳ��� �ٸ� if���� ���Խ�Ű�� ��
		
		/*
		 * ����ǥ ����ϱ�
		 * 		60�� �̻��� ��� �հ�, �� �ܴ� ���հ�
		 * 		��, �հ��� �߿��� ������ 100�� �̻��� ��� �������б� ����
		 * 						 96�� �̻��� ��� �ݾ����б� ����
		 * 		��, ������ 40�� ������ ��� ����ȸ�� ���ñ�ȸ�� ��Ż.
		 */
		
		int score = 100;
		
		if(score >= 60) {
			System.out.println("�հ��Դϴ�.");
			if(score == 100) {
				System.out.println("���� ���б��� ���޵˴ϴ�.");
			} else if(score >= 96) {
				System.out.println("�ݾ� ���б��� ���޵˴ϴ�.");
			}
		} else {
			System.out.println("���հ��Դϴ�.");
			if(score <= 40) {
				System.out.println("����ȸ�� ���ñ�ȸ�� ��Ż�մϴ�.");
			}
		}
		
	}
}
