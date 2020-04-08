package control;

public class WhileDemo5 {

	public static void main(String[] args) {
		int sum = 0;
		int number = 0;
		
//		while(true) {		
//			number++;
//			
//			if(number%2 == 0) {
//				sum+=number*-1;
//			} else {
//				sum+=number;
//			}
//			
//			if(sum>=100) {
//				break;
//			}		
//		}
//		System.out.println(number);		
		
		while(sum<=99) {
			number++;
			
			if(number%2 == 0) {
				sum-=number;
			} else {
				sum+=number;
			}			
		}
		System.out.println(number);
		
	}

}
