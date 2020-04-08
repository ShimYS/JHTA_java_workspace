package lang1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectDemo5 {

	public static void main(String[] args) {
		
		User user = new User(10, "홍길동", "010-1234-5678");
		
		// user참조변수가 참조하는 객체의 설계도 정보를 가지고 있는 class객체가 반환된다.
		Class<? extends User> clazz = user.getClass();	
		String className = clazz.getName();
		System.out.println("클래스이름: " + className);
		
		// Field => 변수에 대한 정보를 담고있는것
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("필드명: " + field.getName() + ", " + field.getType().getTypeName());
		}
		
			
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			String returnTypeName = method.getReturnType().getTypeName();
			String methodName = method.getName();
			System.out.println("메소드 반환타입: " + returnTypeName + "	메소드: " + methodName);
		}
	}

}
