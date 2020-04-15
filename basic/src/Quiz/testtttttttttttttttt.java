package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class testtttttttttttttttt {

	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		Arrays.sort(arr);
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			if(arr[i]%divisor == 0) {
				arrList.add(arr[i]);
			}
		}
		
		for(Integer value : arrList) {
			System.out.println(value);
		}
		
	}

}
