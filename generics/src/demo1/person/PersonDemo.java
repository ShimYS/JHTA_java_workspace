package demo1.person;

import java.util.ArrayList;

public class PersonDemo {
	
	public static void addStudentCourse (Course<? extends Student> c) {
		
	}
	
	public static void addWorkAndPersonCourse (Course<? super Worker> c) {
		
	}
	
	public static void main(String[] args) {
		
		/*
		 * 와일드카드 제네릭 타입제한
		 * 	<? extends T> 	: 상위제한 => T와 T의 자손들
		 * 	<? super T>		: 하위제한 => T와 T의 조상들
		 * 	<?>				: 제한없음=> <? extends Object>와 동일
		 * * 단, 와일드카드를 사용해서 타입제한을 하기 위해서는 해당 클래스가 
		 * 	제네릭타입 클래스여야 한다.
		 */
		
		Course<Student> c1 = new Course<Student>("전공과정");
		Course<PostGraduateStudent> c2 = new Course<PostGraduateStudent>("석사과정");
		Course<Worker> c3 = new Course<Worker>("직장인과정");
		Course<Person> c4 = new Course<Person>("일반인과정");
		
		addStudentCourse(c1);
		addStudentCourse(c2);
		//addStudentCourse(c3);
		//addStudentCourse(c4);
 		
		//addWorkAndPersonCourse(c1);
		//addWorkAndPersonCourse(c2);
		addWorkAndPersonCourse(c3);
		addWorkAndPersonCourse(c4);
		
		// <? super Worker>은 Worker와 Worker의 부모들로 타입을 제한한다.
		ArrayList<? super Worker> list2 = new ArrayList<Person>();
	}

}
