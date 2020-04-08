package etc;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		
		// 콜렉션 프레임워크의 표준 메소드를 사용한 경우
		Stack<String> stack1 = new Stack<String>();
		stack1.add("길동");
		stack1.add("유신");
		stack1.add("순신");
		
		for(String value : stack1) {
			System.out.println(value);
		}
		
		System.out.println();
		
		
		// stack 고유의 기능을 제공하는 메소드를 사용한 경우
		// 웹페이지 뒤로가기 앞으로가기 기능 구현할때 페이지 저장
		// 되돌리기 기능
		Stack<String> stack2 = new Stack<String>();
		stack2.push("길동");		// Stack객체에 저장
		stack2.push("유신");		
		stack2.push("순신");
		
		
		while(!stack2.isEmpty()) {
			String value = stack2.pop();		// pop()으로 꺼내면 나오는 즉시 값은 삭제된다.
			System.out.println(value);
		}
		
		
		// queue
		// 프린트 출력 순서저장
	}
}
