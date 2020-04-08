package oop4;

public class Product {
	
	String name;
	String maker;
	String category;
	int price;
	double discountRate;
	int stock;
	boolean isSoldOut;
	
	Product(){}
	
	// ����ǰ ��ü�� ������� �ʱ�ȭ�� ������ ������ �޼ҵ�
	Product(String name, String maker, String category, int price, int stock){
		this(name, maker, category, price, 0.0, stock, false);
//		* this�޼ҵ� ����� �ڵ�
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = 0.0;
//		this.isSoldOut = false;
	}
	
	// �̿� ��ǰ ��ü�� ������� �ʱ�ȭ�� ������ ������ �޼ҵ�
	Product(String name, String maker, String category, int price, double discountRate, int stock){
		this(name, maker, category, price, discountRate, stock, false);
//		* this�޼ҵ� ����� �ڵ�
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = discountRate;
//		this.isSoldOut = false;
	}
	
	Product(String name, String maker, String category, int price, double discountRate, int stock, boolean isSoldOut){
		this.name = name;
		this.maker = maker;
		this.category = category;
		this.price = price;
		this.discountRate = discountRate;
		this.stock = stock;
		this.isSoldOut = isSoldOut;
	}
	
	void display() {
		//String name = "����";
		System.out.println("---------------- ��ǰ���� ----------------");
		System.out.println("��ǰ�̸�: " + name);
		System.out.println("����ȸ��: " + maker);
		System.out.println("ī����: " + category);
		System.out.println("�ǸŰ���: " + price);
		System.out.println("���κ���: " + discountRate);
		System.out.println("���: " + stock);
		System.out.println("���ǿ���: " + isSoldOut);
		System.out.println("---------------------------------------");
	}
	
}
