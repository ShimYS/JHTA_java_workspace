package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		// 오류 : 타입파라미터<E>에는 클래스명이 정의되어야 한다.
		//		int는 자바의 키워드다. 클래스명이 아니다.
		// ArrayList<int> numbers = new ArrayList<int>();
		// ArrayList<long> numbers = new ArrayList<long>();
		// ArrayList<double> numbers = new ArrayList<double>();
		
		// 기본자료형에 대응되는 wrapper 클래스를 타입파라미터로 지정한다.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
			
		// Wrapper 클래스에 한해서 오토박싱 된다.
		numbers.add(new Integer(10));
		// 오토박싱
		numbers.add(10);							// 실제로 실행되는 코드 : numbers.add(new Integer(10));
		
		currencies.add(new Long(1000000000000L));
		// 오토박싱
		currencies.add(1000000000000L);				// 실제로 실행되는 코드 : currencies.add(new Long(1000000000000L));
		
		scores.add(new Double(4.2));
		// 오토박싱
		scores.add(4.2);							// 실제로 실행되는 코드 : scores.add(new Double(4.2));
		
		
		for(Integer i : numbers) {
			System.out.println(i);
		}
		
		for(int num : numbers) {					// 반복될 때 마다 Integer 객체가 꺼내진다 --> 언박싱되어서 숫자만 num에 대입된다.
			System.out.println(num);
		}
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();					// itr.next() --> Long객체 반환 --> 언박싱되어서 숫자만 curr에 대입
			System.out.println(curr);
		}
		
	}

}
