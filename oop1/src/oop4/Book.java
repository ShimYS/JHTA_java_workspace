package oop4;

public class Book {
	
	String title;
	String writer;
	String publisher;
	int price;
	String genre;
	
	// 생성자 메소드 = 클래스이름과 똑같아야함(필수 조건)
	// 기본 생성자 메소드
	// - 클래스에 정의된 생성자가 하나도 없을 때 컴파일러가 자동으로 추가하는 생성자 메소드다. 왜????? => 어떤 클래스던 생성자가 하나 필요 => 왜????? => 객체가 생성되자마자 하고싶은일을 적기위함 => 그게뭔데? => 멤버변수의 초기화
	// 
	Book() {
		publisher = "한빛미디어";	// 거의 대부분의 책이 한빛미디어에서 출판하기 때문에
								// Book 객체 생성되고 나면 publisher를 "한빛미디어"로 설정해 버리자.
	}
	
	
	
	public Book(String title, String writer, int price, String genre) {
		super();
		this.title = title;
		this.writer = writer;
		publisher = "한빛미디어";
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



	// 일반 멤버 메소드(인스턴스 메소드)
	void printBookInfo() {
		System.out.println("------ 도서 정보 ------");
		System.out.println("제     목: " + title);
		System.out.println("저     자: " + writer);
		System.out.println("출 판 사: " + publisher);
		System.out.println("가     격: " + price);
		System.out.println("장     르: " + genre);
		System.out.println("-------------------");
	}
}
