package date1;

import java.util.Calendar;

public class CalendarDemo2 {

	public static void main(String[] args) {
		// Ư����¥�� Ķ���� ��ü �����
		Calendar date1 = Calendar.getInstance();

		// 2019�� 4�� 11��
		date1.set(2019, 3, 11);
		System.out.println(toString(date1));

		// 3���� ��¥ ���ϱ�
		Calendar date2 = Calendar.getInstance();
		date2.add(Calendar.DATE, -3);
		System.out.println("���� ���� 3����: " + toString(date2));

		// 7���� ��¥ ���ϱ�
		Calendar date3 = Calendar.getInstance();
		date3.add(Calendar.DATE, -7);
		System.out.println("���� ���� 7����: " + toString(date3));

		// 7���� ��¥ ���ϱ�
		Calendar date4 = Calendar.getInstance();
		date4.add(Calendar.MONTH, -3);
		System.out.println("���� ���� 3����: " + toString(date4));
	}
	// MONTH�� 0���� �����ϱ� ������ + 1 �� ���ش�.
	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH) + 1) + "�� " + date.get(Calendar.DAY_OF_MONTH)
				+ "��";
	}
}
