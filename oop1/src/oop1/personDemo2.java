package oop1;

public class personDemo2 {

	public static void main(String[] args) {
		/*
		 * Person��ü�� ���� �� ��� �迭�� ����غ���
		 */
		
		// Person��ü 3���� ���� �� �ִ� �迭�� �����ؼ� peoplo�� �����ϱ�
		// ��ü�� �ݺ����� ���ؼ� �����Ϸ��� �̸��� �������� �־�� �Ѵ�.
		// ����, p1 p2 p3�� �ϳ��� �迭(people)�� �־���� �Ѵ�.
		Person[] people = new Person[3];
		
		Person p1 = new Person();	// p1�� Person��ü�� �ּҰ��� ������ �ִ�.
		p1.name = "�̼���";
		p1.email = "leesh@naver.com";
		p1.age = 60;
		
		Person p2 = new Person();	// p2�� Person��ü�� �ּҰ��� ������ �ִ�.
		p2.name = "������";
		p2.email = "ryugs@daum.net";
		p2.age = 17;
		
		Person p3 = new Person();	// p3�� Person��ü�� �ּҰ��� ������ �ִ�.
		p3.name = "������";
		p3.email = "kang@gmail.com";
		p3.age = 80;
		
		// ������ ������ Person��ü�� �ּҰ��� �迭�� �����ϱ�
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;
		
		// people �迭�� ����� ��� Person��ü�� �Ӽ��� ����ϱ�
		for(int i=0; i<people.length; i++) {
			Person p = people[i]; //Person��ü�� �ּҰ��� PersonŸ���� ������ ��ƾ� �Ѵ�.
			System.out.println(p.name +"\t"+ p.email +"\t"+ p.age);
		}
		
		
	}

}
