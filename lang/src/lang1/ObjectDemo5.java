package lang1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectDemo5 {

	public static void main(String[] args) {
		
		User user = new User(10, "ȫ�浿", "010-1234-5678");
		
		// user���������� �����ϴ� ��ü�� ���赵 ������ ������ �ִ� class��ü�� ��ȯ�ȴ�.
		Class<? extends User> clazz = user.getClass();	
		String className = clazz.getName();
		System.out.println("Ŭ�����̸�: " + className);
		
		// Field => ������ ���� ������ ����ִ°�
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("�ʵ��: " + field.getName() + ", " + field.getType().getTypeName());
		}
		
			
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			String returnTypeName = method.getReturnType().getTypeName();
			String methodName = method.getName();
			System.out.println("�޼ҵ� ��ȯŸ��: " + returnTypeName + "	�޼ҵ�: " + methodName);
		}
	}

}
