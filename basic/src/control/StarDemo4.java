package control;

public class StarDemo4 {

	public static void main(String[] args) {
		/*
		 
		    1111**		i=1 ����:4 ��2
		 	111****		i=2 ����:3 ��4
		 	11******	i=3 ����:2 ��6
		 	1********	i=4 ����:1 ��8
		 	**********	i=5 ����:0 ��10
		 
		 */
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print("1");
			}
			for(int k=1; k<=2*i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("1");
			}
			for(int k=1; k<=10-(2*i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
