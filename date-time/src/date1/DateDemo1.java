package date1;

import java.util.Date;

public class DateDemo1 {
	
	public static void main(String[] args) {
		
		// �ý����� ���� �ð������� �����ϴ� Date��ü�� �����ȴ�.
		Date now = new Date();
		System.out.println(now.toString());
		
		// 1970-01-01 00:00:00 ���ķκ��� Date��ü�� ����Ű�� �ð������� �и��ʰ�
		// 1�� ���������� 1000�� Ŀ���� => 1�ʿ� 1000�� �ٲ��.
		long unixTime = now.getTime();
		System.out.println(unixTime);
		
		// JVM�� �����Ǵ� ���� �ý����� unixŸ���� �� �� �ִ�.
		unixTime = System.currentTimeMillis();
		System.out.println(unixTime);
	}
}
