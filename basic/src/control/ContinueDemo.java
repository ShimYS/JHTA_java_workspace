package control;

public class ContinueDemo {

	public static void main(String[] args) {
		// continue
		// �ݺ����ȿ� �ִ� ���๮�� �����ϴٰ� continue�� ����Ǹ� �����ִ�
		// ���๮�� ������ ����ϰ� ���������� �̵��ؼ� ���� �� �ݺ��� �Ϸ� ����.
		
		for (int i=1; i<=10; i++) {
			if(i%3 == 0) {
				System.out.println("¦!");
				continue;
			}
			System.out.println(i);
		}

	}

}
