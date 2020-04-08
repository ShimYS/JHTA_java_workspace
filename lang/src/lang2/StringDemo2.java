package lang2;

import java.util.StringTokenizer;

public class StringDemo2 {
	
	public static void main(String[] args) {
		//split()과 StringTokenizer의 차이점		
		// * split은 구분자를 기준으로 잘랐을 때 빈 문자열도 배열에 담아둔다.
		// * StringTokenizer는 구분자를 기준으로 잘랐을 때 빈 문자열은 버린다.
		String str = "김유신,,강감찬,이순신";
		

		// split은 빈문자를 챙긴다.
		String[] items = str.split(",");
		for(String item : items) {
			System.out.println("배열의 값: [" + item + "]" );			
		}
		System.out.println();
//		배열의 값: [김유신]
//		배열의 값: []
//		배열의 값: [강감찬]
//		배열의 값: [이순신]
		
		
		// StringTokenizer은 빈문자를 챙기지 않는다.		
		StringTokenizer tokens = new StringTokenizer(str, ",");
		while(tokens.hasMoreTokens()) {
			String value = tokens.nextToken();
			System.out.println("토큰의 값: ["+value+"]");
		}
//		토큰의 값: [김유신]
//		토큰의 값: [강감찬]
//		토큰의 값: [이순신]
	}

	
	
	
}
