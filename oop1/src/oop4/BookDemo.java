package oop4;

public class BookDemo {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		book1.title = "�ڹ��� ����";
		book1.writer = "���� ��";
		book1.price = 30000;
		book1.genre = "���/��ǻ��";
		book1.printBookInfo();
	
		Book book2 = new Book("ó�� ������ �ӽŷ���", "����ī �������", 18000, "���/��ǻ��");
		book2.printBookInfo();
		
		Book book3 = new Book("���̽� ���� ���α׷���", "������", "������", 25600, "���/��ǻ��");
		book3.printBookInfo();
	}

}
