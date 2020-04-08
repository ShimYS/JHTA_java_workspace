package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo5 {

	public static void main(String[] args) throws ParseException {
		// ����� ����
		Date today = new Date();
		final long ONE_DATE_TIME = 60*60*24*1000;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("1.����° ��?	2.�׳��� �����ϱ�?");
			
		System.out.println("�޴��� �����ϼ���: ");
		int menuNo = scanner.nextInt();
		
		if(menuNo == 1) {
			System.out.println("������� �Է��ϼ���(�Է¿�: 2020.4.29)) : ");
			String text = scanner.next();
			Date memorialDay = df.parse(text);
		
			long todayTime = today.getTime();
			long memorialDayTime = memorialDay.getTime();
			
			long dayCount = (todayTime - memorialDayTime)/ONE_DATE_TIME;
			System.out.println("������" + dayCount + "��° ���Դϴ�.");
		} else if(menuNo == 2) {
			System.out.println("��¥�� �Է��ϼ���(�Է¿�: 100) : ");
			int dayCount = scanner.nextInt();
			
			long todayTime = today.getTime();
			long dayTime = ONE_DATE_TIME * dayCount;
			
			Date futureDay = new Date(todayTime+ dayTime);
			String text = df.format(futureDay);
			System.out.println("���ú��� [" +dayCount+"]��°�� " + text + " �Դϴ�.");	
		}
		
	}

}
