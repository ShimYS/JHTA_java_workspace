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
			System.out.println("1.전체조회  2.검색  3.등록  4.수정  5.삭제  0.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[전체 도서 조회]");
				List<Book> books = bookDao.getAllBooks();
				
				System.out.println("전체 도서 갯수: " + books.size() + "권");
				
				displayBooks(books);
				
				System.out.println("##### 전체조회를 완료했습니다 #####");
				
				
			} else if(menuNo == 2) {
				System.out.println("[도서 검색]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.번호  2.제목  3.장르  4.가격");
				System.out.println("-------------------------------------------------");
				
				System.out.print("검색 조건을 선택하세요: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[책 번호로 검색]");
					System.out.print("책 번호를 입력하세요: ");
					int no = KeyboardUtil.nextInt();
					
					Book book = bookDao.getBookByNo(no);
					if(book == null) {
						System.out.println("["+no+"] 책번호에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						System.out.println("=================");
						System.out.println("번   호: "+book.getNo());
						System.out.println("제   목: "+book.getTitle());
						System.out.println("저   자: "+book.getWriter());
						System.out.println("장   르: "+book.getGenre());
						System.out.println("출판사: "+book.getPublisher());
						System.out.println("가   격: "+book.getPrice());
						System.out.println("할인가: "+book.getDiscountPrice());
						System.out.println("등록일: "+book.getRegistreredDate());
						System.out.println("=================");
					}
		
					System.out.println("##### 책 번호 검색을 완료했습니다 #####");					
					
				} else if(searchMenuNo == 2) {
					System.out.println("[책 제목으로 검색]");
					System.out.print("책 제목을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					
					List<Book> books = bookDao.searchBooksByTitle(title);
					
					if(books.isEmpty()) {
						System.out.println("제목 ["+title+"]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}	
					
					System.out.println("##### 책 제목 검색을 완료했습니다 #####");
					
				} else if(searchMenuNo == 3) {
					System.out.println("[책 장르로 검색]");
					System.out.print("책 장르를 입력하세요: ");
					String genre = KeyboardUtil.nextString();
					
					List<Book> books = bookDao.searchBooksByGenre(genre);
					
					if(books.isEmpty()) {
						System.out.println("장르 ["+genre+"]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}					
					
					System.out.println("##### 책 장르 검색을 완료했습니다 #####");					
					
				} else if(searchMenuNo == 4) {
					System.out.println("[책 가격 검색]");
					System.out.print("최소 가격을 입력하세요: ");
					int minPrice = KeyboardUtil.nextInt();
					System.out.print("최대 가격을 입력하세요: ");
					int maxPrice = KeyboardUtil.nextInt();
					
					List<Book> books = bookDao.searchBooksByPriceRange(minPrice, maxPrice);
					
					if(books.isEmpty()) {
						System.out.println("가격 ["+minPrice+" ~ "+maxPrice+"]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}
					
					System.out.println("##### 책 가격 검색을 완료했습니다 #####");
				}
				
			} else if(menuNo == 3) {
				System.out.println("[새 책 등록]");
				
				System.out.print("제목을 입력하세요: ");
				String title = KeyboardUtil.nextString();
				System.out.print("장르를 입력하세요: ");
				String genre = KeyboardUtil.nextString();
				System.out.print("저자를 입력하세요: ");
				String writer = KeyboardUtil.nextString();
				System.out.print("출판사를 입력하세요: ");
				String publisher = KeyboardUtil.nextString();
				System.out.print("가격을 입력하세요: ");
				int price = KeyboardUtil.nextInt();
				
				Book book = new Book();
				book.setTitle(title);
				book.setGenre(genre);
				book.setWriter(writer);
				book.setPublisher(publisher);
				book.setPrice(price);
				book.setDiscountPrice((int)(price*0.9));
				
				bookDao.addBook(book);
				
				System.out.println("##### 새 책 등록을 완료했습니다 #####");
				
				
			} else if(menuNo == 4) {
				System.out.println("[수정]");
				
			} else if(menuNo == 5) {
				System.out.println("[삭제]");
				
			} else if(menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("##### 프로그램을 종료합니다 #####");
				break;
			}
								
			System.out.println();	
			System.out.println();	
			System.out.println();	
		}
		
		
	}
	
	private static void displayBooks(List<Book> books) {
		System.out.println("번호\t제목\t저자\t장르\t출판사\t가격할인\t가격\t재고량\t등록일");
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
