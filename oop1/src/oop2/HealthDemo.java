package oop2;

public class HealthDemo {

	public static void main(String[] args) {
		
		Health health = new Health();
		double result1 = health.bmi(50, 1.60);
		System.out.println("bmi����: "+result1);
		
		String result2 = health.bmiText(50, 1.60);
		System.out.println("bmi���: "+result2);
	}

}
