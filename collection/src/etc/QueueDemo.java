package etc;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		//  LinkedList�� Queue �������̽��� ����Ŭ�����̴�.
		LinkedList<String> queue = new LinkedList<String>();
		
		// Queue�� ������ü(LinkedList)�� �� �����ϱ�
		queue.offer("�̼���");
		queue.offer("������");
		queue.offer("������");
		
		// Queue�� ������ü(LinkedList)���� �� ������
		System.out.println(queue);
		System.out.println("poll -> " + queue.poll());
		System.out.println(queue);
		System.out.println("poll -> " + queue.poll());
		System.out.println(queue);
		System.out.println("poll -> " + queue.poll());
		
		System.out.println(queue);
	}

}
