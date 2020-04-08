package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookStoreService {
	
	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// ȸ����� ����
	// �̸��� ��ȭ��ȣ�� ���޹޾Ƽ� User��ü�� ���, UserService�� ȸ����ϱ���� �����Ѵ�.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
		
	// ȸ����ȸ ����
	// ȸ����ȣ�� ���޹޾Ƽ�, UserService�� ȸ����ȸ����� �����Ѵ�.
	public void retrieveUserInfo(int userNo) {		
		User user = userService.findUserByNo(userNo);
		if(user != null) {
			System.out.println("ȸ����ȣ\t�̸�\t��ȭ��ȣ\t\t����Ʈ\tŻ�𿩺�");
			System.out.println(user);
		} else {
			System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
		}
		
	}
	
	// ȸ������ ����
		// ������ ȸ�������� ���޹޾Ƽ� �ش� ȸ���� ������ �����Ѵ�.
		//		- UserService�� ȸ������ �������� �����ؼ� ȸ�������� �����Ѵ�.
	public void modifyUserInfo(User user) {
		User tempUser = userService.updateUser(user);
		if(tempUser != null) {
			System.out.println("ȸ����ȣ\t�̸�\t��ȭ��ȣ\t\t����Ʈ\tŻ�𿩺�");
			System.out.println(tempUser);		
		} else {
			System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
		}
	}
	
	// ȸ��Ż�� ����
		// Ż��ó���� ȸ����ȣ�� ���޹޾Ƽ� �ش� ȸ���� Ż��ó���Ѵ�.
		//		- UserService�� ȸ����ȸ����� �����ؼ� ȸ�������� �����޴´�.
		//		- ��ȸ�� ȸ���� Ż�𿩺θ� Ż��ó���� �����Ѵ�.
		//		- RentalService�� �ݳ������ �����ؼ� �ش� ȸ���� �뿩���� ��� å�� �ݳ�ó���Ѵ�.
	public void disabledUser(int userNo) {
		User user = userService.findUserByNo(userNo);
		if(user != null) {
			user.isDisabled = true;		
		} else {
			System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
		}
	}
	
	// ��ü ȸ����ȸ ����
		// ��ϵ� ��� ȸ������ ��ȸ�� ó���Ѵ�.
		// 	- UserService�� ��� ȸ������ ��ȸ����� �����ؼ� ��� ȸ�������� �����޴´�.
		// 	- ��ȸ�� ȸ�������� ȭ�鿡 ����Ѵ�.(nullüũ)
	public void retrieveAllUsers() {
		User[] user = userService.getAllUsers();
		System.out.println("ȸ����ȣ\t�̸�\t��ȭ��ȣ\t\t����Ʈ\tŻ�𿩺�");
		for(int i=0; i<user.length; i++) {
			System.out.println(user[i]);
		}
	}
	
	// ������� ����
	// ����, ����, ������ ���޹޾Ƽ� ���� ��� ���񽺸� ó���Ѵ�.
	// - Book��ü�� �����ؼ� ����, ����, ���� ������ �����Ѵ�.
	// - ���� 10000������ �Ѵ�.
	// - BookService�� ������ϱ���� �����Ѵ�.
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		
		bookService.insertBook(book);
	}

	// ���� �˻� ����
		// ���� ���޹޾Ƽ� ���� �˻����񽺸� ó���Ѵ�.
		// - BookService�� ���� �˻������ �����ؼ� å������ �����޴´�.
		// - ��ȸ�� å������ ȭ�鿡 ����Ѵ�.
	public void searchBooks(String title) {
		Book[] book = bookService.findBookByTitle(title);
		if(book.length != 0) {
			System.out.println("ȸ����ȣ\t������\t����\t����\t���");
			for(int i=0; i<book.length; i++) {
				System.out.println(book[i]);
			}		
		} else {
			System.out.println("�˻���� ��ġ�ϴ� ������ �������� �ʽ��ϴ�.");
		}
	}

	// ���� ���� ���� ����
		// å������ ���޹޾Ƽ� å���� �������񽺸� ó���Ѵ�.
		// - BookService�� å���� ��������� �����Ѵ�.
	public void modifyBook(Book book) {
		Book tempbook = bookService.updateBook(book);
		System.out.println("ȸ����ȣ\t������\t����\t����\t���");
		System.out.println(tempbook);
	}
	
	// ��ü���� ��ȸ ����
		// ��� å���� ��ȸ ���񽺸� ó���Ѵ�.
		// 		- BookService�� ��� å��ȸ ����� �����Ѵ�.
	public void retrieveAllBooks() {
		Book[] books = bookService.getAllBooks();
		System.out.println("ȸ����ȣ\t������\t����\t����\t���");
		for(int i=0; i<books.length; i++) {
			System.out.println(books[i]);
		}
	}

	// �뿩 ����
		// ����ڹ�ȣ�� å��ȣ�� ���޹޾Ƽ� �뿩 ���񽺸� ó���Ѵ�.
		// - Rental��ü�� �����ؼ� ����ڹ�ȣ, å��ȣ�� �����Ѵ�.
		// - �뿩���δ� �뿩������ �����Ѵ�.
		// - å��� �����ϱ�
		// - BookService���� å��ȣ�� �ش��ϴ� å���� ��ȸ��� ����
		// - ��ȸ�� å�� ��� 1���ҽ�Ų��.
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
			System.out.println("ȸ�������� ��Ȯ���� �ʽ��ϴ�.");
		}	
	}

	// �ݳ� ����
		// �뿩��ȣ�� ���޹޾Ƽ� �ݳ� ���񽺸� ó���Ѵ�.
		// - RentalService���� �뿩��ȣ�� �ش��ϴ� �뿩���� ��ȸ ����� ����
		// - ��ȸ�� �뿩������ �ݳ����θ� false�� �����Ѵ�.
		// - ���������Ʈ ����, å��� �����ϱ�
		// - UserService���� ����ڹ�ȣ�� ��������� ��ȸ�ϱ� ����
		// - BookService���� å��ȣ�� å���� ��ȸ�ϱ� ����
		// - ��ȸ�� ������� ����Ʈ�� å������ 1%��ŭ ������Ű��
		// - ��ȸ�� å������ ��� 1������Ű��
	public void returnBook(int rentNo) {
		
		Rental rental = rentalService.findRentalByNo(rentNo);
		if(rental != null) {
			rental.isRent = false;			
		} else {
			System.out.println("�뿩��ȣ�� ��Ȯ���� �ʽ��ϴ�.");
		}
		
		Book book = bookService.findBookByNo(rental.bookNo);
		if(book != null) {
			book.stock += 1;					
		} else {
			System.out.println("������ȣ�� ��Ȯ���� �ʽ��ϴ�.");
		}
		
		User user = userService.findUserByNo(rental.userNo);
		if(user != null) {
			user.point += (int)(book.price*0.01);		
		} else {
			System.out.println("ȸ����ȣ�� ��Ȯ���� �ʽ��ϴ�.");
		}
		
	}
	
	// �ϰ��ݳ� ����
		// ����ȣ�� �Է¹޾Ƽ� �� ���� �뿩���� ��� å�� �ѹ��� �ݳ�ó���ϱ�
	public void returnAllBook(int userNo) {
		Rental[] rental = rentalService.returnAllRentalByUserNo(userNo);
		
		if(rental.length != 0) {
			for(int i=0; i<rental.length; i++) {
				returnBook(rental[i].no);
			}
		} else {
			System.out.println("�뿩������ �������� �ʽ��ϴ�.");
		}
	}
	
	// �뿩��� ��ȸ ����
		// ȸ���̸��� ���޹޾Ƽ� �ش� ȸ���� �뿩����� ó���Ѵ�.
		// ȸ���̸����� ȸ����ȣ�� ã�´�.
		// - RentalService�� �뿩��� ����� �����Ѵ�.
		// - ��ȸ�� �뿩����� ȭ�鿡 ����Ѵ�.
	public void retrieveRentInfo(String name) {
		User user = userService.findUserByName(name);		
		Rental[] rental = rentalService.returnAllRentalByUserNo(user.no);
		
		if(rental != null) {
			System.out.println("ȸ���̸�\t�뿩��ȣ\tȸ����ȣ\t������ȣ\t�뿩��Ȳ");
			for(int i=0; i<rental.length; i++) {
				System.out.println(user.name+"\t"+rental[i]);
			}
		} else {
			System.out.println("�뿩����� �������� �ʽ��ϴ�.");
		}
		
	}
	
	
	// �뿩��Ȳ ��ȸ ����
		// ��� �뿩������ ��ȸ�ϴ� ���񽺸� ó���Ѵ�.
		// - RentalService�� ��ü �뿩������ȸ ����� �����Ѵ�.
		// - ��ȸ�� �뿩������ ȭ�鿡 ����Ѵ�. (nullüũ)
	public void retrieveAllRentals() {
		Rental[] rental = rentalService.getAllRentals();
		
		if(rental != null) {
			System.out.println("ȸ���̸�\t�뿩��ȣ\tȸ����ȣ\t������ȣ\t�뿩��Ȳ");
			for(int i=0; i<rental.length; i++) {
				User user = userService.findUserByNo(rental[i].userNo);
				System.out.println(user.name+"\t"+rental[i]);
			}			
		} else {
			System.out.println("�뿩������ �������� �ʽ��ϴ�.");
		}
	}
	
	
}
