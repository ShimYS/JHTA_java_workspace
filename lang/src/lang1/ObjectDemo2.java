package lang1;

import java.util.HashSet;

public class ObjectDemo2 {
	public static void main(String[] args) {
		User user1 = new User(10, "ȫ�浿", "010-1111-1111"); 
		User user2 = new User(10, "ȫ�浿", "010-1111-1111");
		
		// HashSet�� ��ü�� ���� �� ���� �� �ִ� �ڷᱸ�� ��ü��
		// HashSet�� ������ ��ü�� �ߺ��������� �ʴ´�..
		HashSet<User> set = new HashSet<User>();
		
		set.add(user1);
		set.add(user2);
		
		System.out.println("Set�� ����� ��ü --> " + set);
	}
	
}
