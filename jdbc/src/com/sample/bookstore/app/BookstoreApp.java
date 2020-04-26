package com.sample.bookstore.app;

import java.util.List;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;

public class BookstoreApp {
	
	public static void main(String[] args) throws Exception {
		
		BookDAO bookDao = new BookDAO();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.��ü��ȸ  2.�˻�  3.���  4.����  5.����  0.����");
			System.out.println("-------------------------------------------------");
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[��ü ���� ��ȸ]");
				List<Book> books = bookDao.getAllBooks();
				
				System.out.println("��ü ���� ����: " + books.size() + "��");
				
				displayBooks(books);
				
				System.out.println("##### ��ü��ȸ�� �Ϸ��߽��ϴ� #####");
				
				
			} else if(menuNo == 2) {
				System.out.println("[���� �˻�]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.��ȣ  2.����  3.�帣  4.����");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�˻� ������ �����ϼ���: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[å ��ȣ�� �˻�]");
					System.out.print("å ��ȣ�� �Է��ϼ���: ");
					int no = KeyboardUtil.nextInt();
					
					Book book = bookDao.getBookByNo(no);
					if(book == null) {
						System.out.println("["+no+"] å��ȣ�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
					} else {
						System.out.println("=================");
						System.out.println("��   ȣ: "+book.getNo());
						System.out.println("��   ��: "+book.getTitle());
						System.out.println("��   ��: "+book.getWriter());
						System.out.println("��   ��: "+book.getGenre());
						System.out.println("���ǻ�: "+book.getPublisher());
						System.out.println("��   ��: "+book.getPrice());
						System.out.println("���ΰ�: "+book.getDiscountPrice());
						System.out.println("�����: "+book.getRegistreredDate());
						System.out.println("=================");
					}
		
					System.out.println("##### å ��ȣ �˻��� �Ϸ��߽��ϴ� #####");					
					
				} else if(searchMenuNo == 2) {
					System.out.println("[å �������� �˻�]");
					System.out.print("å ������ �Է��ϼ���: ");
					String title = KeyboardUtil.nextString();
					
					List<Book> books = bookDao.searchBooksByTitle(title);
					
					if(books.isEmpty()) {
						System.out.println("���� ["+title+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
					} else {
						displayBooks(books);
					}	
					
					System.out.println("##### å ���� �˻��� �Ϸ��߽��ϴ� #####");
					
				} else if(searchMenuNo == 3) {
					System.out.println("[å �帣�� �˻�]");
					System.out.print("å �帣�� �Է��ϼ���: ");
					String genre = KeyboardUtil.nextString();
					
					List<Book> books = bookDao.searchBooksByGenre(genre);
					
					if(books.isEmpty()) {
						System.out.println("�帣 ["+genre+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
					} else {
						displayBooks(books);
					}					
					
					System.out.println("##### å �帣 �˻��� �Ϸ��߽��ϴ� #####");					
					
				} else if(searchMenuNo == 4) {
					System.out.println("[å ���� �˻�]");
					System.out.print("�ּ� ������ �Է��ϼ���: ");
					int minPrice = KeyboardUtil.nextInt();
					System.out.print("�ִ� ������ �Է��ϼ���: ");
					int maxPrice = KeyboardUtil.nextInt();
					
					List<Book> books = bookDao.searchBooksByPriceRange(minPrice, maxPrice);
					
					if(books.isEmpty()) {
						System.out.println("���� ["+minPrice+" ~ "+maxPrice+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
					} else {
						displayBooks(books);
					}
					
					System.out.println("##### å ���� �˻��� �Ϸ��߽��ϴ� #####");
				}
				
			} else if(menuNo == 3) {
				System.out.println("[�� å ���]");
				
				System.out.print("������ �Է��ϼ���: ");
				String title = KeyboardUtil.nextString();
				System.out.print("�帣�� �Է��ϼ���: ");
				String genre = KeyboardUtil.nextString();
				System.out.print("���ڸ� �Է��ϼ���: ");
				String writer = KeyboardUtil.nextString();
				System.out.print("���ǻ縦 �Է��ϼ���: ");
				String publisher = KeyboardUtil.nextString();
				System.out.print("������ �Է��ϼ���: ");
				int price = KeyboardUtil.nextInt();
				
				Book book = new Book();
				book.setTitle(title);
				book.setGenre(genre);
				book.setWriter(writer);
				book.setPublisher(publisher);
				book.setPrice(price);
				book.setDiscountPrice((int)(price*0.9));
				
				bookDao.addBook(book);
				
				System.out.println("##### �� å ����� �Ϸ��߽��ϴ� #####");
				
				
			} else if(menuNo == 4) {
				System.out.println("[����]");
				
			} else if(menuNo == 5) {
				System.out.println("[����]");
				
			} else if(menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("##### ���α׷��� �����մϴ� #####");
				break;
			}
								
			System.out.println();	
			System.out.println();	
			System.out.println();	
		}
		
		
	}
	
	private static void displayBooks(List<Book> books) {
		System.out.println("��ȣ\t����\t����\t�帣\t���ǻ�\t��������\t����\t���\t�����");
		for(Book book : books) {				
			System.out.print(book.getNo()+"\t");
			System.out.print(book.getTitle()+"\t");
			System.out.print(book.getWriter()+"\t");
			System.out.print(book.getGenre()+"	");
			System.out.print(book.getPublisher()+"	");
			System.out.print(book.getPrice()+"	");
			System.out.print(book.getDiscountPrice()+"	");
			System.out.print(book.getStock()+"	");		
			System.out.println(book.getRegistreredDate());			
		}
	}
}
