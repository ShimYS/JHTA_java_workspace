package date1;

import java.util.Date;

public class DateDemo1 {
	
	public static void main(String[] args) {
		
		// 시스템의 현재 시간정보를 포함하는 Date객체가 생성된다.
		Date now = new Date();
		System.out.println(now.toString());
		
		// 1970-01-01 00:00:00 이후로부터 Date객체가 가르키는 시간까지의 밀리초값
		// 1초 지날때마다 1000씩 커진다 => 1초에 1000번 바뀐다.
		long unixTime = now.getTime();
		System.out.println(unixTime);
		
		// JVM이 구동되는 현재 시스템의 unix타임을 알 수 있다.
		unixTime = System.currentTimeMillis();
		System.out.println(unixTime);
	}
}
