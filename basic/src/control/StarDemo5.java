package control;

public class StarDemo5 {

	public static void main(String[] args) {
	
		/*
		 
		 	1111**		i=1 ����:4 ��2
		 	111****		i=2 ����:3 ��4
		 	11******	i=3 ����:2 ��6
		 	1********	i=4 ����:1 ��8
		 	**********	i=5 ����:0 ��10
		 	1********	i=6 ����:1 ��8
		 	11******	i=7 ����:2 ��6
		 	111****		i=8 ����:3 ��4
		 	1111**		i=9 ����:4 ��2
		 		 
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
