package control;

public class StarDemo3 {

	public static void main(String[] args) {
		/*
		 			**	i=1	����:8 ��:2
		 		  ****	i=2	����:6 ��:4
		 		******	i=3	����:4 ��:6 
		 	  ********	i=4	����:2 ��:8
		 	**********	i=5	����:0 ��:10				 
		 */
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=10-(2*i); j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=2*i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
