package com.sample.bookstore.service;

import java.util.ArrayList;

import com.sample.bookstore.vo.Book;

public class BookService {
	private Book[] db = new Book[100];
	private int position = 0;
	private int bookSequence = 20001;
	
	public BookService() {
		Book b1 = new Book(bookSequence++, "이것이자바다", "남궁성", 35000, 10000);
		Book b2 = new Book(bookSequence++, "머신러닝입문", "안동현", 35000, 10000);
		Book b3 = new Book(bookSequence++, "스프링입문", "박재성", 35000, 10000);
		Book b4 = new Book(bookSequence++, "JSP입문", "백기선", 35000, 10000);
		Book b5 = new Book(bookSequence++, "알고리즘연습", "백준", 35000, 10000);
		
		db[position++] = b1;
		db[position++] = b2;
		db[position++] = b3;
		db[position++] = b4;
		db[position++] = b5;
	}
	
	public void insertBook(Book book) {
		book.no = bookSequence;
		db[position] = book;
		
		position++;
		bookSequence++;
	}
	
	// 책번호를 전달받아서 db에서 책번호에 해당하는 책정보를 찾아서 반환한다.
	public Book findBookByNo(int bookNo) {
		Book result = null;
		for(int i=0; i<position; i++) {
			if(bookNo == db[i].no) {
				result = db[i];
				break;
			}
		}
		return result;
	}

	// 책제목을 전달받아서 db에서 입력한 책제목을 포함하고 있는 모든 책을 찾아서 반환한다.
	public Book[] findBookByTitle(String title) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i=0; i<position; i++) {
			if (db[i].title.contains(title)) {
				books.add(db[i]);
			}
		}
		Book[] result = new Book[books.size()];
		books.toArray(result);
		
		return result;
	}

	// 도서정보 수정 기능
	// 도서정보를 전달받아서 책번호에 해당하는 책정보를 찾아서 그 책의 정보를 새정보로 변경한다.
	public Book updateBook(Book book) {
		Book result = null;
		result = findBookByNo(book.no);
		
		if(result != null) {
			result.title = book.title;
			result.writer = book.writer;
			result.price = book.price;
		}
		return result;		
	}
	
	// 모든 책 조회 기능
	public Book[] getAllBooks() {
		Book[] tempDb = new Book[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
	
}
