package control;

public class ForDemo2 {
	
	public static void main(String[] args) {

		/*
		 * 1���� 100������ �հ踦 ����ϱ�
		 */		
		int sum = 0;
		
		for(int i=0; i<=100; i++) {
			System.out.print("["+i+"] ["+sum+"] -----> ");
			sum += i;
			System.out.println("["+sum+"]");
		}
	}
}
