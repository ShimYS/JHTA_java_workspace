package oop4;

public class Book {
	
	String title;
	String writer;
	String publisher;
	int price;
	String genre;
	
	// ������ �޼ҵ� = Ŭ�����̸��� �Ȱ��ƾ���(�ʼ� ����)
	// �⺻ ������ �޼ҵ�
	// - Ŭ������ ���ǵ� �����ڰ� �ϳ��� ���� �� �����Ϸ��� �ڵ����� �߰��ϴ� ������ �޼ҵ��. ��????? => � Ŭ������ �����ڰ� �ϳ� �ʿ� => ��????? => ��ü�� �������ڸ��� �ϰ�������� �������� => �װԹ���? => ��������� �ʱ�ȭ
	// 
	Book() {
		publisher = "�Ѻ��̵��";	// ���� ��κ��� å�� �Ѻ��̵��� �����ϱ� ������
								// Book ��ü �����ǰ� ���� publisher�� "�Ѻ��̵��"�� ������ ������.
	}
	
	
	
	public Book(String title, String writer, int price, String genre) {
		super();
		this.title = title;
		this.writer = writer;
		publisher = "�Ѻ��̵��";
		this.price = price;
		this.genre = genre;
	}



	public Book(String title, String writer, String publisher, int price, String genre) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.genre = genre;
	}



	// �Ϲ� ��� �޼ҵ�(�ν��Ͻ� �޼ҵ�)
	void printBookInfo() {
		System.out.println("------ ���� ���� ------");
		System.out.println("��     ��: " + title);
		System.out.println("��     ��: " + writer);
		System.out.println("�� �� ��: " + publisher);
		System.out.println("��     ��: " + price);
		System.out.println("��     ��: " + genre);
		System.out.println("-------------------");
	}
}
