package operator;

public class OpDemo5 {
	public static void main(String[] args) {
		// �� ������(���� ������)
		// >  <  >=  <=  ==  !=
		// �� ������ ���ǹ��� �ݺ����� ���ǽ����� ���ȴ�.
		// �� �������� ���� ����� �׻� true/false �� �ϳ��̴�.
		// == ������
		// 		�⺻�ڷ����� ���� ������ ����� ���� ���Ѵ�.
		// 		�����ڷ����� ���� ������ ����� �ּҰ��� ���Ѵ�.
		//		*�����ڷ����� �� == �����ڴ� �������.
		
		int num1 = 20;
		int num2 = 30;
		boolean result = num1 > num2;
		System.out.println(result);
		
		boolean result2 = (num1 == num2);	// �������� �켱������ ���� �������� �����ʴ�.
		boolean result3 = num1 != num2;		// �������� �켱������ ���� �������� ����
		System.out.println("�� ���� �����Ѱ�? " + result2);
		System.out.println("�� ���� �������� ������? " + result3);
		
	}
}
