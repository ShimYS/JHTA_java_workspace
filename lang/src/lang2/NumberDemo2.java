package lang2;

import java.math.BigInteger;

public class NumberDemo2 {

	public static void main(String[] args) {
		// BigInteger : longÀ¸·Î ´Ù·ê ¼ö ¾ø´Â Á¤¼ö
		// BigDecimal : double·Î ´Ù·ê ¼ö ¾ø´Â ½Ç¼ö
		
//		long number1 = 123456789012345678901234567890L;
//		long number2 = 1234567890L;
		
		// longÀÇ ¹üÀ§¸¦ ¹þ¾î³¯ ¶§´Â BigInteger¸¦ »ç¿ëÇÑ´Ù.
		BigInteger big1 = new BigInteger("123456789012345678901234567890");
		BigInteger big2 = new BigInteger("1234567890");
		
		BigInteger result1 = big1.add(big2);		
		System.out.println("µ¡¼À°á°ú: " + result1.toString());
		
		BigInteger result2 = big1.subtract(big2);		
		System.out.println("»¬¼À°á°ú: " + result2.toString());
		
		BigInteger result3 = big1.multiply(big2);		
		System.out.println("°ö¼À°á°ú: " + result3.toString());
		
		BigInteger result4 = big1.divide(big2);		
		System.out.println("³ª´°¼À°á°ú: " + result4.toString());
	}

}
