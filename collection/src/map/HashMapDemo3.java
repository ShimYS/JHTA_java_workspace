package map;

import java.util.Date;
import java.util.HashMap;

public class HashMapDemo3 {

	public static void main(String[] args) {
		
		// Map���� V�� �ش��ϴ� Ÿ���� Object�� �����ϴ� ���
		// ���� ������ ���� �����ϴ� �뵵�� Map�� ����� �� �ִ�.
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("no", 100);
		data.put("title", "�ڹ��� ����");
		data.put("writer", "���ü�");
		data.put("publisher", "�������ǻ�");
		data.put("price", 25000);
		data.put("discountRate", 0.05);
		data.put("incomeDate", new Date());
		
		// v�� Ÿ���� Object�� �����ϴ� ��� ���� ���� ��  �ݵ�� ����ȯ�� �ʿ��ϴ�.
		int no = (Integer)data.get("no");
		String title = (String)data.get("title");
		String writer = (String)data.get("writer");
		String publisher = (String)data.get("publisher");
		int price = (Integer)data.get("price");
		double discountRate = (double)data.get("discountRate");
		Date incomeDate = (Date)data.get("incomeDate");
		
		System.out.println("������ȣ: " + no);
		System.out.println("��      ��: " + title);
		System.out.println("��      ��: " + writer);
		System.out.println("�� �� �� : " + publisher);
		System.out.println("��      ��: " + price);
		System.out.println("�� �� �� : " + discountRate);
		System.out.println("�� �� �� : " + incomeDate);
	}

}
