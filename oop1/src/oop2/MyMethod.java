package oop2;

public class MyMethod {
	
	// �ν��Ͻ� ����
	String name;
	
	// Ŭ���� ����
	
	static final double PI = 3.14;
	
	// �ν��Ͻ� �޼ҵ�
	void memberMethod() {
		System.out.println("�ν��Ͻ����� ���" + name);
		System.out.println("Ŭ�������� ���" + MyMethod.PI);
	}
	
	// Ŭ���� �޼ҵ�, �����޼ҵ� => Ŭ�����޼ҵ�� Ŭ���� ������ ����� �� �ִ�.
	static void staticMethod() {
		System.out.println("�ν��Ͻ����� ���" + name);
		System.out.println("Ŭ�������� ���" + MyMethod.PI);
	}
		
}
