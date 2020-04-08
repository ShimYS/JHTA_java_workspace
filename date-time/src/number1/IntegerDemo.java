package number1;

public class IntegerDemo {

	public static void main(String[] args) {
		
		String text = "1234567.89";
		double number1 = Double.parseDouble(text);
		System.out.println(number1);
		
		//공백이 있으면 에러발생 => trim()사용해서 공백제거 후 사용해야 한다.
		int number2 = Integer.parseInt(" 1000000".trim());
		System.out.println(number2);
		
	}

}
