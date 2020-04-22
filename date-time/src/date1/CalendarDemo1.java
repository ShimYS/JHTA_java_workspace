package date1;

import java.util.Calendar;

public class CalendarDemo1 {

	public static void main(String[] args) {
		// Calendar�� �߻�Ŭ������ new�� ��ü���� �Ұ�		
		Calendar cal = Calendar.getInstance();	
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		int yoil = cal.get(Calendar.DAY_OF_WEEK);		// 1~7	1:�Ͽ���
		System.out.println("��: " + year);
		System.out.println("��: " + month);
		System.out.println("��: " + day);
		System.out.println("��: " + hour);
		System.out.println("��: " + minute);
		System.out.println("��: " + second);
		System.out.println("����: " + yoil);
	}

}
