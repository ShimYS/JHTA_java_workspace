package date1;

import java.util.Date;

public class DateDemo2 {
	
	public static void main(String[] args) {
		
		// long값을 넣어주면 그 당시의 날짜를 알 수 있다.
		Date date = new Date(0);
		System.out.println(date);
		
		Date date0 = new Date(1000000000000L);
		System.out.println(date0);
		
		Date date1 = new Date(1100000000000L);
		System.out.println(date1);

		Date date2 = new Date(1200000000000L);
		System.out.println(date2);

		Date date3 = new Date(1300000000000L);
		System.out.println(date3);

		Date date4 = new Date(1400000000000L);
		System.out.println(date4);
		
		Date date5 = new Date(1500000000000L);
		System.out.println(date5);

		Date date10 = new Date(10000000000000L);
		System.out.println(date10);

		
	}
}
