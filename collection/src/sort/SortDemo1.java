package sort;


import java.util.Arrays;

public class SortDemo1 {

	public static void main(String[] args) {
		
		String[] arr = {"�̼���","������","������","������","���߱�","�豸"};
		
		Arrays.sort(arr);
		
		for(String value:arr) {
			System.out.println(value + "\t");
		}		
		
	}

}
