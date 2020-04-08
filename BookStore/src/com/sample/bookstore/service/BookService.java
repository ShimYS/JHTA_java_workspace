package com.sample.bookstore.service;

import java.util.ArrayList;

import com.sample.bookstore.vo.Book;

public class BookService {
	private Book[] db = new Book[100];
	private int position = 0;
	private int bookSequence = 20001;
	
	public BookService() {
		Book b1 = new Book(bookSequence++, "�̰����ڹٴ�", "���ü�", 35000, 10000);
		Book b2 = new Book(bookSequence++, "�ӽŷ����Թ�", "�ȵ���", 35000, 10000);
		Book b3 = new Book(bookSequence++, "�������Թ�", "���缺", 35000, 10000);
		Book b4 = new Book(bookSequence++, "JSP�Թ�", "��⼱", 35000, 10000);
		Book b5 = new Book(bookSequence++, "�˰��򿬽�", "����", 35000, 10000);
		
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
	
	// å��ȣ�� ���޹޾Ƽ� db���� å��ȣ�� �ش��ϴ� å������ ã�Ƽ� ��ȯ�Ѵ�.
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

	// å������ ���޹޾Ƽ� db���� �Է��� å������ �����ϰ� �ִ� ��� å�� ã�Ƽ� ��ȯ�Ѵ�.
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

	// �������� ���� ���
	// ���������� ���޹޾Ƽ� å��ȣ�� �ش��ϴ� å������ ã�Ƽ� �� å�� ������ �������� �����Ѵ�.
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
	
	// ��� å ��ȸ ���
	public Book[] getAllBooks() {
		Book[] tempDb = new Book[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
	
}
