package lang1;

import java.util.Date;

public class ObjectDemo3 {

	public static void main(String[] args) {
		User user1 = new User(10, "ȫ�浿", "010-1234-5678");
		User user2 = new User(20, "������", "010-4532-5879");
		
		// ���������� ����ϸ�
		// Object�� toString() �޼ҵ� �������� ��µȴ�.
		// Object�� toString() �޼ҵ�� "Ŭ������@�ؽ��ڵ�"�� ��ȯ�Ѵ�.
		// Object�� toString() �޼ҵ带 �������ؼ� ��ü�� �������(�Ӽ���)���� �ؽ�Ʈ�� ��ȯ�ϵ��� �ϴ� ��찡 ����.
		System.out.println(user1);
		System.out.println(user1.toString());
		
		System.out.println(user2);
		System.out.println(user2.toString());
		
		// Date��ü�� Object�� toString()�� �������ߴ�.
		Date today = new Date();
		System.out.println(today);	// Thu Apr 02 15:43:50 KST 2020
	}

}
