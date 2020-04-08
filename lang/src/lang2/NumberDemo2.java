package lang2;

import java.math.BigInteger;

public class NumberDemo2 {

	public static void main(String[] args) {
		// BigInteger : long���� �ٷ� �� ���� ����
		// BigDecimal : double�� �ٷ� �� ���� �Ǽ�
		
//		long number1 = 123456789012345678901234567890L;
//		long number2 = 1234567890L;
		
		// long�� ������ ��� ���� BigInteger�� ����Ѵ�.
		BigInteger big1 = new BigInteger("123456789012345678901234567890");
		BigInteger big2 = new BigInteger("1234567890");
		
		BigInteger result1 = big1.add(big2);		
		System.out.println("�������: " + result1.toString());
		
		BigInteger result2 = big1.subtract(big2);		
		System.out.println("�������: " + result2.toString());
		
		BigInteger result3 = big1.multiply(big2);		
		System.out.println("�������: " + result3.toString());
		
		BigInteger result4 = big1.divide(big2);		
		System.out.println("���������: " + result4.toString());
	}

}
