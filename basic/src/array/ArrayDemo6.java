package array;

public class ArrayDemo6 {

	public static void main(String[] args) {
		
		int[][] scores = {
				{80, 70, 80},		// �������� ����, ����, ��������
				{30, 40, 50},		// �������� ����, ����, ��������
				{100, 86, 100}		// �̼����� ����, ����, ��������
		};
		
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
			
		System.out.println("��ȣ	����	����	����	����	���");
		System.out.println("===========================================");
				
		for(int i=0; i<scores.length; i++) {			
			System.out.print(i + 1 + "\t");			
			korTotal += scores[i][0];		// 0����, 1����, 2������ �������� ����
			engTotal += scores[i][1];		// 0����, 1����, 2������ �������� ����
			mathTotal += scores[i][2];		// 0����, 1����, 2������ �������� ����
			
			int total = 0;					// 0����, 1����, 2������ ������ �����ϴ� ����
			for(int j=0; j<scores[i].length; j++) {
				total += scores[i][j];		// ���ະ ���������� total�� ����
				System.out.print(scores[i][j] + "\t");	// �� �ະ ���������� ���
			}

			System.out.print(total + "\t" + total/3);		// �� �ະ ������ ����� ���
			System.out.println();
		}
		System.out.println("===========================================");
		System.out.println("����\t" + korTotal + "\t" + engTotal + "\t"+mathTotal);
		
	}

}
