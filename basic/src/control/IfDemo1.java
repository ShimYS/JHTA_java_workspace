package control;

public class IfDemo1 {
	
	public static void main(String[] args) {
		
		/*		 
		 * if��
		 * 	- ���õ� ���ǽ��� �������� ���� ���๮�� ����ȴ�.
		 * 	- if(���ǽ�) {
		 * 			���๮; (���ǽ��� �������� true�� ������ �� ����)
		 *    }
		 *    
		 * if ~ else��
		 * 	- if(���ǽ�) {
		 * 			���๮; (���ǽ��� true�϶� ����)
		 * 	  } else {
		 * 			���๮; (���ǽ��� false�϶� ����)
		 * 	  }
		 * 
		 * *���ǽĿ��� �񱳿�����, ��������, 'true' or 'false'�� ��ȯ�޴� �޼ҵ常 ����� �� �ִ�.
		 */
		
		// ���輺���� 60�� �̻��� ��츸 �հ��̶�� ǥ���ϱ�
		int score = 41;
		if(score >= 60) {
			System.out.println("�հ��Դϴ�.");
		}
				
		// ������� ���ٱ����� �������� ��� "�������" �� �ܴ� "���ٰź�"��� ǥ���ϱ�
		String userRole = "������";
		if(userRole.equals("������")) {
			System.out.println("�������");
		} else {
			System.out.println("���ٰź�");
		}
		
	}
}
