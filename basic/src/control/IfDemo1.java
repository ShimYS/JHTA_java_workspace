package control;

public class IfDemo1 {
	
	public static void main(String[] args) {
		
		/*		 
		 * if문
		 * 	- 제시된 조건식의 연산결과에 따라서 수행문이 실행된다.
		 * 	- if(조건식) {
		 * 			수행문; (조건식의 연산결과가 true로 판정될 때 실행)
		 *    }
		 *    
		 * if ~ else문
		 * 	- if(조건식) {
		 * 			수행문; (조건식이 true일때 실행)
		 * 	  } else {
		 * 			수행문; (조건식이 false일때 실행)
		 * 	  }
		 * 
		 * *조건식에는 비교연산자, 논리연산자, 'true' or 'false'를 반환받는 메소드만 사용할 수 있다.
		 */
		
		// 시험성적이 60점 이상인 경우만 합격이라고 표시하기
		int score = 41;
		if(score >= 60) {
			System.out.println("합격입니다.");
		}
				
		// 사용자의 접근권한이 관리자인 경우 "접근허용" 그 외는 "접근거부"라고 표시하기
		String userRole = "관리자";
		if(userRole.equals("관리자")) {
			System.out.println("접근허용");
		} else {
			System.out.println("접근거부");
		}
		
	}
}
