package map;

import java.util.HashMap;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		HashMap<String, Double> pointDepositRate = new HashMap<String, Double>();
		pointDepositRate.put("bronze", 0.01);
		pointDepositRate.put("silver", 0.03);
		pointDepositRate.put("gold", 0.05);
		
		// �������(bronze, silver, gold)�� ���� ���� ���űݾ��� 1%, 3%, 5% ���κz��
		String grade = "silver";
		int orderPrice = 34000;
		double depositRate = pointDepositRate.get(grade);
		int point = (int)(orderPrice * depositRate);
		
//		int point = 0;
//		if(grade.equals("bronze")) {
//			point = (int)(orderPrice * 0.01);
//		} else if(grade.equals("silver")) {
//			point = (int)(orderPrice * 0.03);
//		} else if(grade.equals("gold")) {
//			point = (int)(orderPrice * 0.05);
//		}
		
		System.out.println("�����: " + grade);
		System.out.println("���űݾ�: " + orderPrice);
		System.out.println("�� �� Ʈ : " + point);
	}

}
