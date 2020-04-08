package oop3;

public class ArgSample {
	
	// 기본자료형 타입의 값을 매개변수로 전달받는 경우
	void changeValue(int num) {		
		System.out.println("changeValue()에서의 before num -----> " + num);
		num = 150;
		System.out.println("changeValue()에서의 after num -----> " + num);
	}
	
	// 참조형 타입의 값을 매개변수로 전달받는 경우
	void changeDataValue(Data data) {
		System.out.println("changeDataValue()에서의 before num -----> " + data.num);
		data.num = 300;
		System.out.println("changeDataValue()에서의 after num -----> " + data.num);
	}
}
