package array;

public class ArrayDemo3 {

	public static void main(String[] args) {
		// �迭�� ���� ��ȸ�ϱ�
		//		�迭�̸�.length�� ��ȸ�� �� �� �ִ�.
		//		* �迭�� ���̴� �Һ��̴�. �迭�� ���̸� ������ �� ����.
		String[] names = {"�̼���", "������", "������"};
		// �迭�� ����
		int len = names.length;
		System.out.println("�迭�� ����: "+names.length);
		System.out.println("�迭�� ����: "+len);
		
		//�迭�� ���̸� Ȱ���ؼ� �迭�� �� ��Ұ� ��ȸ�ϱ�
		//System.out.println(names[0]);
		//System.out.println(names[1]);
		//System.out.println(names[2]);
		
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		int[] score = {80, 50, 67, 70, 49, 68, 86, 21, 34, 50, 94, 12, 100};
		int totalScore = 0;
		for(int i=0; i<score.length; i++) {
			System.out.println("����: " + score[i]);
			totalScore += score[i];
		}
		System.out.println("����: " + totalScore);
	}

}
