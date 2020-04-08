package oop2;

/**
 * �������� ������ ����� �����ϴ� Ŭ������. 
 * @author ShimYS
 *
 */
public class Gugudan {
	// ��Ź�Ⱑ �⺻������ �������� ������ ¥�� => �⺻��� ����
	// 1�� 2�� 3�� => ���ܼ��� ����
	// ���� ���Ƚ�� �ڽ� ��� ���μ��� => ����ڼ��� ����
	
	// �⺻��� ����
	/**
	 * 2�� ~ 9�ܱ��� ����Ѵ�.
	 */
	void print99dan() {
		print99danByRange(2, 9);
	}
	
	// ���ܼ������ ����
	/**
	 * ������ �ܿ� �ش��ϴ� �������� ����Ѵ�.
	 * @param dan ����� ���� ����
	 */
	void print99danByNumber(int dan) {
		print99danByRange(dan, dan);
	}
	
	//����ڼ������ ����
	/**
	 * ������ ���۹�ȣ���� ����ȣ������ �������� ����Ѵ�.
	 * @param begin	����� ���� ���� ����
	 * @param end	����� �� ���� ����
	 */
	void print99danByRange(int begin, int end) {
		System.out.println("[������ ���] - ("+ begin + " ~ " + end + ")");
		for(int i=1; i<=9; i++) {
			for(int j=begin; j<=end; j++) {
				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
			}
			System.out.println();
		}
	}
	
}
