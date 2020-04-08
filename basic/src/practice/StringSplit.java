package practice;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		/*
		 * 	문자열을 입력받는다.
		 * 	해당 문자열에서 p의 숫자와 y의 숫자가 같으면 
		 * 	true를 반환하고 그렇지 않으면 false를 반환한다.
		 * 	대소문자를 가리지 않는다.
		 * 
		 * 	<공부한것>
		 * 	1. 문자열을 입력받아서 문자하나하나씩 배열에 나눠 저장하는법
		 * 	2. '=='는 객체의 타입을 비교하는것
		 * 	3. '.equals()'는 데이터를 비교하는것
		 * 	4. 배열을 for문으로 돌릴때 초기화값은 0으로 조건식은 .length보다 작게 설정한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next();
		
		String[] sp;
		int countP = 0;
		int countY = 0;
		String result;		
		sp = str.split("");
		
		for(int i=0; i<sp.length; i++) {
			if(sp[i].equals("p") || sp[i].equals("P") ) {
				countP++;
			} else if (sp[i].equals("y") || sp[i].equals("Y")) {
				countY++;
			}
		}
		
		if(countP == countY) {
			result = "true";
		} else {
			result = "false";
		}
		
		System.out.println(result);
		
	}

}
