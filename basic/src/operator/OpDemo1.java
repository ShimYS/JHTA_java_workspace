package operator;

public class OpDemo1 {
	
	public static void main(String[] args) {
		
		// ���� ������(���� ������)
		// ++  --
		// ++ �ǿ������� ���� 1 ������Ų��
		// -- �ǿ������� ���� 1 ���ҽ�Ų��
		int a = 10;
		a++;
		System.out.println(a);
		a++;
		System.out.println(a);
		
		int b = 20;
		++b;
		System.out.println(b);
		++b;
		System.out.println(b);
		
		int c = 30;
		c--;
		System.out.println(c);
		c--;
		System.out.println(c);
		
		//���ͷ��� ǥ�õ� ���� ������̱� ������ ���������ڷ� �����ų �� ����
		//System.out.println(6++);
		//System.out.println(10--);
	}
}
