package control;

public class ForDemo2 {
	
	public static void main(String[] args) {

		/*
		 * 1부터 100까지의 합계를 계산하기
		 */		
		int sum = 0;
		
		for(int i=0; i<=100; i++) {
			System.out.print("["+i+"] ["+sum+"] -----> ");
			sum += i;
			System.out.println("["+sum+"]");
		}
	}
}
