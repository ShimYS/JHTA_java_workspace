package lang1;

public class ObjectDemo1 {

	public static void main(String[] args) {
		
		User user1 = new User(10, "ȫ�浿", "010-1111-1111"); 
		User user2 = new User(10, "ȫ�浿", "010-1111-1111");
		
		// user1�� �ּҰ��� user2�� �ּҰ��� ������ ���Ѵ�.
		boolean result1 = user1 == user2;
		System.out.println("���� ��ü�ΰ�? " + result1);
		
		// Object�� equals(Object other)��
		// user1�� user2�� �ּҰ��� ������ ���Ѵ�.
		
		// user���� hashCode(), equals()�� ��������
		// ���� no�� ������ ������ ���� ��ü��� �Ǵ��ϵ��� ������.
		boolean result2 = user1.equals(user2);
		System.out.println("���� ��ü�ΰ�? " + result2);
		
		
		String str1 = new String("ȫ�浿");
		String str2 = new String("ȫ�浿");
		
		boolean result3 = str1 == str2;
		System.out.println("���� ��ü�ΰ�? " + result3);
		
		// String�� Object��  equals(Object other)��
		// ���ڿ��� ������ ���ϵ��� �������ߴ�.
		boolean result4 = str1.equals(str2);
		System.out.println("������ ������? " + result4);
	}

}
