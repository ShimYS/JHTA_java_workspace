package number1;

public class IntegerDemo {

	public static void main(String[] args) {
		
		String text = "1234567.89";
		double number1 = Double.parseDouble(text);
		System.out.println(number1);
		
		//������ ������ �����߻� => trim()����ؼ� �������� �� ����ؾ� �Ѵ�.
		int number2 = Integer.parseInt(" 1000000".trim());
		System.out.println(number2);
		
	}

}
