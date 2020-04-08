package oop2;

public class MyMethod {
	
	// 인스턴스 변수
	String name;
	
	// 클래스 변수
	
	static final double PI = 3.14;
	
	// 인스턴스 메소드
	void memberMethod() {
		System.out.println("인스턴스변수 사용" + name);
		System.out.println("클래스변수 사용" + MyMethod.PI);
	}
	
	// 클래스 메소드, 정적메소드 => 클래스메소드는 클래스 변수만 사용할 수 있다.
	static void staticMethod() {
		System.out.println("인스턴스변수 사용" + name);
		System.out.println("클래스변수 사용" + MyMethod.PI);
	}
		
}
