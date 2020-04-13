package demo2;

public class GradeDemo {
	
	public static void main(String[] args) {
		// 열거형의 주요 메소드
		
		// 열거형 상수의 이름을 문자열로 반환한다.
		// String name()
		String name = Grade.VIP.name();
		System.out.println(name);
		
		// 열거형 상수의 순서값을 반환한다. (0부터 시작)
		// int ordinal()
		int no1 = Grade.VIP.ordinal();
		int no2 = Grade.GOLD.ordinal();
		int no3 = Grade.SILVER.ordinal();
		int no4 = Grade.BRONZE.ordinal();
		
		System.out.println(Grade.VIP + " " + no1);
		System.out.println(Grade.GOLD + " " + no2);
		System.out.println(Grade.SILVER + " " + no3);
		System.out.println(Grade.BRONZE + " " + no4);
		
		// static T Enum.valueOf(Class<T> enumType, String name)
		// static T valueOf(String name)		
		// 지정된 열거형 타입에서 이름에 해당하는 열거형 상수를 반환한다.
		Grade grade1 = Enum.valueOf(Grade.class, "VIP");
//		Grade grade2 = Grade.valueOf("Silver");
		System.out.println(grade1.name() + ", " + grade1.ordinal());
	}
}
