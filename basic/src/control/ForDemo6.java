package control;

public class ForDemo6 {

	public static void main(String[] args) {
		// ����Ǭ��
		int sum = 0;

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=11-i; j++) {
				sum += i;
			}
		}
		System.out.println(sum);

		
		// ������
		int sum2 = 0;
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				sum2 += j;
			}
		}
		System.out.println(sum2);
		
	}

}
