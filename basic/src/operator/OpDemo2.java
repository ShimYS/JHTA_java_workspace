package operator;

public class OpDemo2 {
	public static void main(String[] args) {
		// ����������
		// **�Ʒ��� ����� ���๮ �� �Ϻδ� ����õ ���๮
		
		// ���������ڸ� �񱳿����ڿ� ���� ����� ���
		// 
		int num1 = 10;
		int num2 = 10;
		
		// ������ ����õ, ����� ����õ, ��¥�� ����õ
		boolean result1 = num1++ > 10;	// ���� ����(�񱳿���)�� ����
		boolean result2 = ++num2 > 10;	// ������ �� ���� ����(�񱳿���)
		System.out.println(result1);
		System.out.println(result2);
		
		// ���������ڸ� �񱳿����ڿ� ���� ������� �ʴ� ���
		int num3 = 10;
		int num4 = 10;		
		num3++;
		++num4;
		
		boolean result3 = num3 > 10;
		boolean result4 = num4 > 10;		
		System.out.println(result3);
		System.out.println(result4);
	}
}
