package array;

public class ArrayDemo1 {

	public static void main(String[] args) {
		/*
		 * �迭
		 * - ���� Ÿ���� ���� ���� �� ������ �� �ִ� ������ �����̴�.
		 * �迭�� ����
		 * - ���� 5���� �����ϴ� �迭 �����ؼ� ���������� ���
		 * 		int[] numbers = new int[5];
		 * 			������ �迭 -> [0, 0, 0, 0, 0]
		 *		int[] numbers = {10, 40, 20, 70, 40}; => �迭 ���ͷ�
		 *			������ �迭 -> [10, 40, 20, 70, 40]
		 * 		int[] numbers = new int[]{10, 20, 30, 40, 50};
		 * 			������ �迭 -> [10, 20, 30, 40, 50]
		 * - �迭�� ������ �� �迭�� ���̸� �����ϸ� �迭�� �� ��ҿ��� �ش� ������Ÿ���� �⺻������
		 * 	 �ʱ�ȭ�Ǿ� �ִ�.
		 * 		* �⺻ ������Ÿ�Ժ� �⺻��
		 * 		����(byte, short, int, long) --> 0
		 * 		�Ǽ�(float, double) 			--> 0.0
		 * 		����(char)					--> \u0000 (�����ڵ忡���� 0��° ����)
		 * 		��(boolean)					--> false
		 * 		* ���� ������Ÿ���� �⺻��
		 * 		�⺻ ������Ÿ���� ������ ��� ������Ÿ���� �⺻���� null�̴�.
		 * 		��� ����Ÿ���� ������ null���� ������ �� �ִ�.
		 * 		null�� ���������� ��ü�� ���̻� �������� ���ϰ� �ϴ� ���̴�.
		 */
		
		// ������ �迭
		int[] numbers1 = new int[3];
		System.out.println("0��° ����: " + numbers1[0]);
		System.out.println("1��° ����: " + numbers1[1]);
		System.out.println("2��° ����: " + numbers1[2]);
		
		// �Ǽ��� �迭
		double[] numbers2 = new double[3];
		System.out.println("0��° �Ǽ�: " + numbers2[0]);
		System.out.println("1��° �Ǽ�: " + numbers2[1]);
		System.out.println("2��° �Ǽ�: " + numbers2[2]);
		
		// String�� �迭
		String[] words = new String[3];
		System.out.println("0��° ���ڿ�: " + words[0]);
		System.out.println("1��° ���ڿ�: " + words[1]);
		System.out.println("2��° ���ڿ�: " + words[2]);
		
		// ������ �迭
		int[] scores = {10, 40, 100};
		
		// �Ǽ��� �迭
		double[] rates = {0.05, 0.001, 0.005};
		
		// String�� �迭
		String[] names = {"ȫ�浿", "������", "������"};
		System.out.println("0��° ���ڿ�: " + names[0]); //names�� 0��° ���� �����ϴ� �ּ��� ��ü���� �����ش�.
		System.out.println("1��° ���ڿ�: " + names[1]);
		System.out.println("2��° ���ڿ�: " + names[2]);
	}

}
