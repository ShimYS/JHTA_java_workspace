package operator;

public class OpDemo2 {
	public static void main(String[] args) {
		// 증감연산자
		// **아래의 기술된 수행문 중 일부는 비추천 수행문
		
		// 증감연산자를 비교연산자와 같이 사용한 경우
		// 
		int num1 = 10;
		int num2 = 10;
		
		// 강력히 비추천, 절대로 비추천, 진짜로 비추천
		boolean result1 = num1++ > 10;	// 값을 참조(비교연산)후 증가
		boolean result2 = ++num2 > 10;	// 증가된 후 값을 참조(비교연산)
		System.out.println(result1);
		System.out.println(result2);
		
		// 증감연산자를 비교연산자와 같이 사용하지 않는 경우
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
