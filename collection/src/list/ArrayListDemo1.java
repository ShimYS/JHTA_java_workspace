package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		/*
		 * 	ArrayList�� Ư¡
		 * 		0. �����ߴ� ������� �ٽ� ���� �� �ִ�.(��������)
		 * 		1. Ÿ�� �Ķ����<E>�� ����Ͽ� Ư��Ÿ�Ը� �����ϴ� �ݷ¼��� �����Ѵ�.(Ÿ�Ծ�����)
		 * 		2. ������� ũ�⸦ ������ ������ �ʿ䰡 ����.
		 * 		3. ���̻� ������ ������ ������ ������ ũ�⸦ �ڵ����� �����Ѵ�.
		 * 		4. ������ �� �ε����� ������ ������ �ʿ䰡 ����.(�ڵ����� �ǳ��� ����ȴ�.)
		 * 		5. Enhanced-for���� ����ؼ� ����� ��� ��ü�� ���� ���� �� �ִ�.
		 * 		6. Ư�� ��ġ�� ��ü�� �����ϸ� �ڵ����� �� ������ ��ġ�ϰ� �ִ� ��ü���� ������ �̵��ؼ� �� ���� ä���.
		 */
		
		// Array �����ϱ� <--- String��ü�� ��� ArrayList��ü ����
		ArrayList<String> names = new ArrayList<String>();
		
		// ArrayList ����ҿ�  String��ü ���
		names.add("ȫ�浿");
		names.add("������");
		names.add("������");
		names.add("�̼���");
		names.add("������");
		
		// ArrayList ����ҿ� ����� String��ü ������
		// 1. Enhanced-for�� ���
		//		* ��ȸ�� �����ϴ�.
		//		* ������ �ȵȴ�.
		for(String name : names) {
			System.out.println(name);	
		}
		
		// 2. Iterator ���
		//		* ��ȸ�� �����ϴ�.
		//		* ������ �����ϴ�.(Iterator���� �����ϸ� ArrayList������ �����ȴ�.)
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			// �����ϱ� ����
			/*
			if(name.equals("������")) {
				itr.remove(); 			// ���� �������� ���� ������
			}
			*/
			System.out.println(name);
		}
		
		// 3. �Ϲ� for�� ���(List�� �ڼյ鸸 ����) => �������� ����
		int length = names.size();			// size() => List�� element������ ��ȯ
		for(int i=0; i<length; i++) {		// names.size()�� for�� �� �ȿ��� ������ ����� �ȵȴ�. �ݺ��� 100ȸ�ϸ� size()�޼ҵ带 100���ϴ� ���� �ȴ�.
			String name = names.get(i);
			System.out.println(name);
		}
		
		boolean empty = names.isEmpty();
		System.out.println("����ִ°�? " + empty);
		
		// ����� ��ü ���� �����ϱ�
		names.clear();
		System.out.println("����� ��� ��ü ������");
		
		empty = names.isEmpty();
		System.out.println("����ִ°�? " + empty);
		
		// ����� ��ü�� ���� ��ȸ�ϱ�
		int size = names.size();
		System.out.println("����� ����: " + size);
	}

}
