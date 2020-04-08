package oop1;

public class personDemo2 {

	public static void main(String[] args) {
		/*
		 * Person객체를 여러 개 담는 배열을 사용해보기
		 */
		
		// Person객체 3개를 담을 수 있는 배열을 생성해서 peoplo에 대입하기
		// 객체를 반복문을 통해서 접근하려면 이름이 같은곳에 있어야 한다.
		// 따라서, p1 p2 p3를 하나의 배열(people)에 넣어줘야 한다.
		Person[] people = new Person[3];
		
		Person p1 = new Person();	// p1은 Person객체의 주소값을 가지고 있다.
		p1.name = "이순신";
		p1.email = "leesh@naver.com";
		p1.age = 60;
		
		Person p2 = new Person();	// p2은 Person객체의 주소값을 가지고 있다.
		p2.name = "류관순";
		p2.email = "ryugs@daum.net";
		p2.age = 17;
		
		Person p3 = new Person();	// p3은 Person객체의 주소값을 가지고 있다.
		p3.name = "강감찬";
		p3.email = "kang@gmail.com";
		p3.age = 80;
		
		// 생성된 각각의 Person객체의 주소값을 배열에 저장하기
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;
		
		// people 배열에 저장된 모든 Person객체의 속성을 출력하기
		for(int i=0; i<people.length; i++) {
			Person p = people[i]; //Person객체의 주소값은 Person타입의 변수에 담아야 한다.
			System.out.println(p.name +"\t"+ p.email +"\t"+ p.age);
		}
		
		
	}

}
