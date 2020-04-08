package control;

public class StarDemo4 {

	public static void main(String[] args) {
		/*
		 
		    1111**		i=1 공백:4 별2
		 	111****		i=2 공백:3 별4
		 	11******	i=3 공백:2 별6
		 	1********	i=4 공백:1 별8
		 	**********	i=5 공백:0 별10
		 
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
