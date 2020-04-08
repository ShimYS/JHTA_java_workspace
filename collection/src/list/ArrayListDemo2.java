package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		// ���� : Ÿ���Ķ����<E>���� Ŭ�������� ���ǵǾ�� �Ѵ�.
		//		int�� �ڹ��� Ű�����. Ŭ�������� �ƴϴ�.
		// ArrayList<int> numbers = new ArrayList<int>();
		// ArrayList<long> numbers = new ArrayList<long>();
		// ArrayList<double> numbers = new ArrayList<double>();
		
		// �⺻�ڷ����� �����Ǵ� wrapper Ŭ������ Ÿ���Ķ���ͷ� �����Ѵ�.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
			
		// Wrapper Ŭ������ ���ؼ� ����ڽ� �ȴ�.
		numbers.add(new Integer(10));
		// ����ڽ�
		numbers.add(10);							// ������ ����Ǵ� �ڵ� : numbers.add(new Integer(10));
		
		currencies.add(new Long(1000000000000L));
		// ����ڽ�
		currencies.add(1000000000000L);				// ������ ����Ǵ� �ڵ� : currencies.add(new Long(1000000000000L));
		
		scores.add(new Double(4.2));
		// ����ڽ�
		scores.add(4.2);							// ������ ����Ǵ� �ڵ� : scores.add(new Double(4.2));
		
		
		for(Integer i : numbers) {
			System.out.println(i);
		}
		
		for(int num : numbers) {					// �ݺ��� �� ���� Integer ��ü�� �������� --> ��ڽ̵Ǿ ���ڸ� num�� ���Եȴ�.
			System.out.println(num);
		}
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();					// itr.next() --> Long��ü ��ȯ --> ��ڽ̵Ǿ ���ڸ� curr�� ����
			System.out.println(curr);
		}
		
	}

}
