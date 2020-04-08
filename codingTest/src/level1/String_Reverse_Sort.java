package level1;

import java.util.*;

public class String_Reverse_Sort {

	public String solution(String s) {
		String answer = "";
		String[] temp = s.split("");
		Arrays.sort(temp);

		StringBuilder sb = new StringBuilder();
//		for (int i = temp.length - 1; i != -1; i--) {
//			sb.append(temp[i]);
//		}
		for(int i=0; i<temp.length; i++) {
			sb.append(temp[i]);
		}
		
		answer = sb.reverse().toString();
		return answer;
	}
}