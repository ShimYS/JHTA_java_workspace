package control;

public class RandomDemo {
	public static void main(String[] args) {
		System.out.println("���� ���");
		
		// �ֻ��� 1~6������ �������� �����ϰ� ���;� �Ѵ�.
		// �ּҰ�:1 �ִ밪:6
		// (int)(Math.random()*�ִ밪 + �ּҰ�)
		
		double ran1 = (int)(Math.random()*6+1);
		double ran2 = (int)(Math.random()*6+1);
		System.out.println(ran1 + ", "+ran2);
	}
}
