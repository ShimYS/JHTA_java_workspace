package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookStoreService {
	
	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// 회원등록 서비스
	// 이름과 전화번호를 전달받아서 User객체에 담고, UserService의 회원등록기능을 실행한다.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
		
	// 회원조회 서비스
	// 회원번호를 전달받아서, UserService의 회원조회기능을 실행한다.
	public void retrieveUserInfo(int userNo) {		
		User user = userService.findUserByNo(userNo);
		if(user != null) {
			System.out.println("회원번호\t이름\t전화번호\t\t포인트\t탈퇴여부");
			System.out.println(user);
		} else {
			System.out.println("회원정보가 존재하지 않습니다.");
		}
		
	}
	
	// 회원수정 서비스
		// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
		//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		User tempUser = userService.updateUser(user);
		if(tempUser != null) {
			System.out.println("회원번호\t이름\t전화번호\t\t포인트\t탈퇴여부");
			System.out.println(tempUser);		
		} else {
			System.out.println("회원정보가 존재하지 않습니다.");
		}
	}
	
	// 회원탈퇴 서비스
		// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
		//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
		//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
		//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User user = userService.findUserByNo(userNo);
		if(user != null) {
			user.isDisabled = true;		
		} else {
			System.out.println("회원정보가 존재하지 않습니다.");
		}
	}
	
	// 전체 회원조회 서비스
		// 등록된 모든 회원정보 조회를 처리한다.
		// 	- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
		// 	- 조회된 회원정보를 화면에 출력한다.(null체크)
	public void retrieveAllUsers() {
		User[] user = userService.getAllUsers();
		System.out.println("회원번호\t이름\t전화번호\t\t포인트\t탈퇴여부");
		for(int i=0; i<user.length; i++) {
			System.out.println(user[i]);
		}
	}
	
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	// - Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	// - 재고는 10000권으로 한다.
	// - BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		
		bookService.insertBook(book);
	}

	// 도서 검색 서비스
		// 제목를 전달받아서 도서 검색서비스를 처리한다.
		// - BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
		// - 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		Book[] book = bookService.findBookByTitle(title);
		if(book.length != 0) {
			System.out.println("회원번호\t도서명\t저자\t가격\t재고량");
			for(int i=0; i<book.length; i++) {
				System.out.println(book[i]);
			}		
		} else {
			System.out.println("검색명과 일치하는 도서가 존재하지 않습니다.");
		}
	}

	// 도서 정보 수정 서비스
		// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
		// - BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		Book tempbook = bookService.updateBook(book);
		System.out.println("회원번호\t도서명\t저자\t가격\t재고량");
		System.out.println(tempbook);
	}
	
	// 전체도서 조회 서비스
		// 모든 책정보 조회 서비스를 처리한다.
		// 		- BookService의 모든 책조회 기능을 실행한다.
	public void retrieveAllBooks() {
		Book[] books = bookService.getAllBooks();
		System.out.println("회원번호\t도서명\t저자\t가격\t재고량");
		for(int i=0; i<books.length; i++) {
			System.out.println(books[i]);
		}
	}

	// 대여 서비스
		// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
		// - Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
		// - 대여여부는 대여중으로 설정한다.
		// - 책재고 변경하기
		// - BookService에서 책번호에 해당하는 책정보 조회기능 실행
		// - 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		User user = userService.findUserByNo(userNo);
		Book book = bookService.findBookByNo(bookNo);
		if(user != null && book != null) {
			Rental rental = new Rental();
			rental.bookNo = bookNo;
			rental.userNo = userNo;
			rental.isRent = true;			
			rentalService.insertRental(rental);
			
			book.stock -= 1;			
		} else {
			System.out.println("회원정보가 정확하지 않습니다.");
		}	
	}

	// 반납 서비스
		// 대여번호를 전달받아서 반납 서비스를 처리한다.
		// - RentalService에서 대여번호에 해당하는 대여정보 조회 기능을 실행
		// - 조회된 대여정보의 반납여부를 false로 설정한다.
		// - 사용자포인트 증가, 책재고 변경하기
		// - UserService에서 사용자번호로 사용자정보 조회하기 실행
		// - BookService에서 책번호로 책정보 조회하기 실행
		// - 조회된 사용자의 포인트를 책가격의 1%만큼 증가시키기
		// - 조회된 책정보의 재고를 1증가시키기
	public void returnBook(int rentNo) {
		
		Rental rental = rentalService.findRentalByNo(rentNo);
		if(rental != null) {
			rental.isRent = false;			
		} else {
			System.out.println("대여번호가 정확하지 않습니다.");
		}
		
		Book book = bookService.findBookByNo(rental.bookNo);
		if(book != null) {
			book.stock += 1;					
		} else {
			System.out.println("도서번호가 정확하지 않습니다.");
		}
		
		User user = userService.findUserByNo(rental.userNo);
		if(user != null) {
			user.point += (int)(book.price*0.01);		
		} else {
			System.out.println("회원번호가 정확하지 않습니다.");
		}
		
	}
	
	// 일괄반납 서비스
		// 고객번호를 입력받아서 그 고객이 대여중인 모든 책을 한번에 반납처리하기
	public void returnAllBook(int userNo) {
		Rental[] rental = rentalService.returnAllRentalByUserNo(userNo);
		
		if(rental.length != 0) {
			for(int i=0; i<rental.length; i++) {
				returnBook(rental[i].no);
			}
		} else {
			System.out.println("대여정보가 존재하지 않습니다.");
		}
	}
	
	// 대여기록 조회 서비스
		// 회원이름을 전달받아서 해당 회원의 대여기록을 처리한다.
		// 회원이름으로 회원번호를 찾는다.
		// - RentalService의 대여기록 기능을 실행한다.
		// - 조회된 대여기록을 화면에 출력한다.
	public void retrieveRentInfo(String name) {
		User user = userService.findUserByName(name);		
		Rental[] rental = rentalService.returnAllRentalByUserNo(user.no);
		
		if(rental != null) {
			System.out.println("회원이름\t대여번호\t회원번호\t도서번호\t대여현황");
			for(int i=0; i<rental.length; i++) {
				System.out.println(user.name+"\t"+rental[i]);
			}
		} else {
			System.out.println("대여기록이 존재하지 않습니다.");
		}
		
	}
	
	
	// 대여현황 조회 서비스
		// 모든 대여정보를 조회하는 서비스를 처리한다.
		// - RentalService의 전체 대여정보조회 기능을 실행한다.
		// - 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		Rental[] rental = rentalService.getAllRentals();
		
		if(rental != null) {
			System.out.println("회원이름\t대여번호\t회원번호\t도서번호\t대여현황");
			for(int i=0; i<rental.length; i++) {
				User user = userService.findUserByNo(rental[i].userNo);
				System.out.println(user.name+"\t"+rental[i]);
			}			
		} else {
			System.out.println("대여정보가 존재하지 않습니다.");
		}
	}
	
	
}
