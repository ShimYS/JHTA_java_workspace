package oop1;

public class PersonDemo1 {

	public static void main(String[] args) {
		
		// Person ��ü �����
		// Person p1 
		//		Person ���赵�� ������ ��ü�� �ּҰ��� ��� p1������ ������
		// new Person() 
		//		Person ���赵�� �޸𸮿� ��ü�� �����ϰ�, ������ ��ü�� �ּҰ��� ��ȯ��
		// Person p1 = new Person();
		//		Person ���赵�� �޸𸮿� ��ü�� �����ϰ�, ������ ��ü�� �ּҰ���
		//		PersonŸ���� ���� p1�� �����Ѵ�.
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		
		// p1�� �����ϴ� ��ü�� �Ӽ��� �����ϱ�
		p1.name = "������";
		p1.tel = "010-1234-5678";
		p1.email = "kimys@naver.com";
		p1.gender = "����";
		p1.age = 50;
		
		p2.name = "�̼���";
		p2.tel = "010-1234-4321";
		p2.email = "leesh@gmail.com";
		p2.gender = "����";
		p2.age = 48;
		
		p3.name = "������";
		p3.tel = "010-1234-7654";
		p3.email = "ryugs@daum.net";
		p3.gender = "����";
		p3.age = 17;
	}

}
