package etc;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		
		// �ݷ��� �����ӿ�ũ�� ǥ�� �޼ҵ带 ����� ���
		Stack<String> stack1 = new Stack<String>();
		stack1.add("�浿");
		stack1.add("����");
		stack1.add("����");
		
		for(String value : stack1) {
			System.out.println(value);
		}
		
		System.out.println();
		
		
		// stack ������ ����� �����ϴ� �޼ҵ带 ����� ���
		// �������� �ڷΰ��� �����ΰ��� ��� �����Ҷ� ������ ����
		// �ǵ����� ���
		Stack<String> stack2 = new Stack<String>();
		stack2.push("�浿");		// Stack��ü�� ����
		stack2.push("����");		
		stack2.push("����");
		
		
		while(!stack2.isEmpty()) {
			String value = stack2.pop();		// pop()���� ������ ������ ��� ���� �����ȴ�.
			System.out.println(value);
		}
		
		
		// queue
		// ����Ʈ ��� ��������
	}
}
