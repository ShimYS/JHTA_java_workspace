package operator;

public class OpDemo3 {
	
	public static void main(String[] args) {
		// 산술연산자(이항 연산자)
		// +  -  *  /  %
		// 1. 산술연산은 피연산자의 타입을 동일하게 만든 다음에 연산이 진행된다.
		// 2. 산술연산은 연산에 참여한 피연산자의 데이터타입과 동일한 타입의 결과값이 획득된다.
		// 3. 나머지 연산에서 0으로 나눌 수 없다. (즉, 나눌값을 입력받은 후 0인지 아닌지 검증먼저 해야한다)
		
		// 0으로 나누는 경우 ArithmeticException이 발생된다.
		// 예외가 발생하면 즉시 해당 메소드의 실행이 중지된다.
		// 따라서, 예외가 발생한 수행문 이후의 수행문들은 실행되지 않는다.
//		int num1 = 10;
//		int num2 = 0;
//		System.out.println(num1/num2);		
			
		int num3 = 10;
		int num4 = 6;
		System.out.println("나머지 : " + num3%num4);
	}
}
