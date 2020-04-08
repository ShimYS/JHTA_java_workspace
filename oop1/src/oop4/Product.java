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
	
	// 신제품 객체의 멤버변수 초기화에 적합한 생성자 메소드
	Product(String name, String maker, String category, int price, int stock){
		this(name, maker, category, price, 0.0, stock, false);
//		* this메소드 사용전 코드
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = 0.0;
//		this.isSoldOut = false;
	}
	
	// 이월 제품 객체의 멤버변수 초기화에 적합한 생성자 메소드
	Product(String name, String maker, String category, int price, double discountRate, int stock){
		this(name, maker, category, price, discountRate, stock, false);
//		* this메소드 사용전 코드
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
		//String name = "응수";
		System.out.println("---------------- 상품정보 ----------------");
		System.out.println("상품이름: " + name);
		System.out.println("제조회사: " + maker);
		System.out.println("카데고리: " + category);
		System.out.println("판매가격: " + price);
		System.out.println("할인비율: " + discountRate);
		System.out.println("재고량: " + stock);
		System.out.println("절판여부: " + isSoldOut);
		System.out.println("---------------------------------------");
	}
	
}
