package control;

public class StarDemo5 {

	public static void main(String[] args) {
	
		/*
		 
		 	1111**		i=1 공백:4 별2
		 	111****		i=2 공백:3 별4
		 	11******	i=3 공백:2 별6
		 	1********	i=4 공백:1 별8
		 	**********	i=5 공백:0 별10
		 	1********	i=6 공백:1 별8
		 	11******	i=7 공백:2 별6
		 	111****		i=8 공백:3 별4
		 	1111**		i=9 공백:4 별2
		 		 
		 */
		
		for(int i=1; i<=9; i++) {			
			
			int space = 0;
			int star = i*2;
			
			if(i<=5) {
				space = 5-i;
			} else {
				// space = (5-i) * -1;
				space = Math.abs(5-i);
				star = 10-(space*2);
			}
			
			for(int j=1; j<=space; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<=star; k++) {
				System.out.print("*");
			}
			System.out.println();
				
		}
		
		
	}

}
