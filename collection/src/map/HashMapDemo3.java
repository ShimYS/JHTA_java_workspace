package map;

import java.util.Date;
import java.util.HashMap;

public class HashMapDemo3 {

	public static void main(String[] args) {
		
		// Map에서 V에 해당하는 타입을 Object로 지정하는 경우
		// 여러 종류의 값을 저장하는 용도로 Map을 사용할 수 있다.
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("no", 100);
		data.put("title", "자바의 정석");
		data.put("writer", "남궁성");
		data.put("publisher", "도우출판사");
		data.put("price", 25000);
		data.put("discountRate", 0.05);
		data.put("incomeDate", new Date());
		
		// v의 타입을 Object로 지정하는 경우 값을 꺼낼 때  반드시 형번환이 필요하다.
		int no = (Integer)data.get("no");
		String title = (String)data.get("title");
		String writer = (String)data.get("writer");
		String publisher = (String)data.get("publisher");
		int price = (Integer)data.get("price");
		double discountRate = (double)data.get("discountRate");
		Date incomeDate = (Date)data.get("incomeDate");
		
		System.out.println("도서번호: " + no);
		System.out.println("제      목: " + title);
		System.out.println("저      자: " + writer);
		System.out.println("출 판 사 : " + publisher);
		System.out.println("가      격: " + price);
		System.out.println("할 인 율 : " + discountRate);
		System.out.println("입 고 일 : " + incomeDate);
	}

}
