package array;

public class ArrayDemo2 {
	
	public static void main(String[] args) {
		// �迭�� �� ��ȸ/�����ϱ�
		
		// ������ �迭 ����
		int[] scores = new int[3];
		// �迭�� �� ��ҿ� ���� �����ϱ�
		scores[0] = 90;
		scores[1] = 70;
		scores[2] = 60;
		// �迭�� �� ��ҿ� ����� ������ ����ϱ�
		int total = scores[0] + scores[1] + scores[2];
		System.out.println("��������: "+ scores[0]);
		System.out.println("��������: "+ scores[1]);
		System.out.println("��������: "+ scores[2]);
		System.out.println("����: "+ total);

		// String�� �迭 ����
		String[] names = {"�̼���", "������", "ȫ�浿"};
		System.out.println("0���� ���ڿ�: "+ names[0]);
		System.out.println("1���� ���ڿ�: "+ names[1]);
		System.out.println("2���� ���ڿ�: "+ names[2]);
		//System.out.println("3���� ���ڿ�: "+ names[3]); => ���ܹ߻� ArrayIndexOutOfBoundsException�߻�
		
		names[1] = "������";
		System.out.println("0���� ���ڿ�: "+ names[0]);
		System.out.println("1���� ���ڿ�: "+ names[1]);
		System.out.println("2���� ���ڿ�: "+ names[2]);
	}
}
