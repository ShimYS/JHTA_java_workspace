package lang2;

public class NumberDemo1 {

	public static void main(String[] args) {
		double num1 = 0.1;
		double num2 = 0.2;
		
		// �Ǽ������� ���� ����� ��Ȯ�� ���� ������ ���� �� �ִ�.
		System.out.println(num1 + num2);				// 0.30000000000000004 => ��ǻ�ʹ� �Ǽ� ǥ���� �Ѱ谡 �ִ�.
		
		// �Ǽ������� ������ ������ 10^n ���� ���ؼ� ������ �� 10^n ������ ������� �Ѵ�.
		System.out.println( (num1*10 + num2*10)/10 );	// 0.3
		
	}

}
