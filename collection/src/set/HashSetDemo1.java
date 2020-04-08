package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		
		names.add("ȫ�浿");
		names.add("������");
		names.add("������");
		names.add("�̼���");
		names.add("������");
		names.add("���߱�");
		
		// ������
		// Enhanced-for��
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		// Iterator
		Iterator<String> nameItr = names.iterator();
		while(nameItr.hasNext()) {
			String name = nameItr.next();
			System.out.println(name);
		}
		System.out.println();
		
		// ����� ��ü�� ���� ��ȸ
		int size = names.size();
		System.out.println("����� ��ü�� ����: " + size);
		
		// ���� ����
		names.clear();
		System.out.println("��ü ��ü ����  �Ϸ�");
		
		// ��������� true�� ��ȯ
		boolean empty = names.isEmpty();
		System.out.println("����ִ°�? " + empty);
		
		System.out.println(names);

	}

}
