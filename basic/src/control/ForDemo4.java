package control;

public class ForDemo4 {

	public static void main(String[] args) {
		/*
		 *	1~100������ �����߿��� 3�� ����� �ش��ϴ� ������ �հ踦 ����ϱ�
		 */
		
		int sum = 0;
		int sum2 = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				sum += i;
			}
		}
		System.out.println(""+sum);
	}

}
