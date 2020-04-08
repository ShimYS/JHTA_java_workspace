package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		/*
		 * 	ArrayList의 특징
		 * 		0. 저장했던 순서대로 다시 꺼낼 수 있다.(순서보장)
		 * 		1. 타입 파라미터<E>를 사용하여 특정타입만 저장하는 콜력션을 생성한다.(타입안전성)
		 * 		2. 저장소의 크기를 별도로 지정할 필요가 없다.
		 * 		3. 더이상 저장할 공간이 없으면 공간의 크기를 자동으로 조절한다.
		 * 		4. 저장할 때 인덱스를 별도로 지정할 필요가 없다.(자동으로 맨끝에 저장된다.)
		 * 		5. Enhanced-for문을 사용해서 저장된 모든 객체를 쉽게 꺼낼 수 있다.
		 * 		6. 특정 위치의 객체를 삭제하면 자동으로 그 다음에 위치하고 있는 객체들이 앞으로 이동해서 빈 곳을 채운다.
		 */
		
		// Array 생성하기 <--- String객체를 담는 ArrayList객체 생성
		ArrayList<String> names = new ArrayList<String>();
		
		// ArrayList 저장소에  String객체 담기
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("류관순");
		
		// ArrayList 저장소에 저장된 String객체 꺼내기
		// 1. Enhanced-for문 사용
		//		* 조회만 가능하다.
		//		* 삭제가 안된다.
		for(String name : names) {
			System.out.println(name);	
		}
		
		// 2. Iterator 사용
		//		* 조회가 가능하다.
		//		* 삭제가 가능하다.(Iterator에서 삭제하면 ArrayList에서도 삭제된다.)
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			// 삭제하기 연습
			/*
			if(name.equals("강감찬")) {
				itr.remove(); 			// 지금 꺼내놓은 값이 삭제됨
			}
			*/
			System.out.println(name);
		}
		
		// 3. 일반 for문 사용(List의 자손들만 가능) => 권장하지 않음
		int length = names.size();			// size() => List속 element갯수를 반환
		for(int i=0; i<length; i++) {		// names.size()를 for문 식 안에다 적으면 절대로 안된다. 반복을 100회하면 size()메소드를 100번하는 꼴이 된다.
			String name = names.get(i);
			System.out.println(name);
		}
		
		boolean empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		// 저장된 객체 전부 삭제하기
		names.clear();
		System.out.println("저장된 모든 객체 삭제됨");
		
		empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		// 저장된 객체의 갯수 조회하기
		int size = names.size();
		System.out.println("저장된 갯수: " + size);
	}

}
