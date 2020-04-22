package Quiz;

import java.util.Arrays;
import java.util.Comparator;

public class AboutStringQuiz01 {

	public static void main(String[] args) {
		String [] s1 = {"sun", "bed", "car"};
		String [] s2 = {"abce", "abcd", "cdx"};
		int n1 = 1;
		int n2 = 2;
		
		Arrays.sort(s1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.charAt(n1) - o2.charAt(n1);
			}
		});
		
		for(int i=0; i<s1.length; i++) {
			System.out.println(s1[i]); 
		}
	}
}
