package com.sample.bookstore.app;

import java.util.ArrayList;
import java.util.List;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Question;

public class BookstoreApp {

	public static void main(String[] args) throws Exception {

		BookDAO bookDao = new BookDAO();
		BookstoreService service = new BookstoreService();

		while (true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.전체조회  2.검색  3.등록  4.수정  5.삭제  6.문의게시판  0.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();

			if (menuNo == 1) {
				System.out.println("[전체 도서 조회]");
				
				System.out.println("-------------------------------------------------");
				System.out.println("1.가격순  2.평점순  3.추천순");
				System.out.println("-------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요: ");
				int allBookMenuNo = KeyboardUtil.nextInt();
				
				List<Book> books = new ArrayList<Book>();
				if(allBookMenuNo == 1) {
					System.out.println("[가격순 검색]");						
					books = service.모든도서검색(1);
					
				} else if(allBookMenuNo == 2) {
					System.out.println("[평점순 검색]");
					books = service.모든도서검색(2);
					
				} else if(allBookMenuNo == 3) {
					System.out.println("[추천순 검색]");
					books = service.모든도서검색(3);						
				}
				
				if(books.isEmpty()) {
					System.out.println("도서정보가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() +"권의 책이 조회되었습니다.");
					System.out.println("번호\t제목\t저자\t출판사\t가격\t평점\t추천수");
					for(Book book : books) {				
						System.out.print(book.getNo()+"\t");
						System.out.print(book.getTitle()+"\t");
						System.out.print(book.getWriter()+"\t");						
						System.out.print(book.getPublisher()+"\t");
						System.out.print(book.getPrice()+"\t");
						System.out.print(book.getPoint()+"\t");
						System.out.println(book.getLike());
						
					}
					System.out.println("##### 전체 도서 조회를 완료했습니다 #####");
				}

			} else if (menuNo == 2) {
				System.out.println("[도서 검색]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.번호  2.제목  3.장르  4.가격");
				System.out.println("-------------------------------------------------");

				System.out.print("검색 조건을 선택하세요: ");
				int searchMenuNo = KeyboardUtil.nextInt();

				if (searchMenuNo == 1) {
					System.out.println("[책 번호로 검색]");
					System.out.print("책 번호를 입력하세요: ");
					int no = KeyboardUtil.nextInt();

					Book book = bookDao.getBookByNo(no);
					if (book == null) {
						System.out.println("[" + no + "] 책번호에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						System.out.println("=================");
						System.out.println("번   호: " + book.getNo());
						System.out.println("제   목: " + book.getTitle());
						System.out.println("저   자: " + book.getWriter());
						System.out.println("장   르: " + book.getGenre());
						System.out.println("출판사: " + book.getPublisher());
						System.out.println("가   격: " + book.getPrice());
						System.out.println("할인가: " + book.getDiscountPrice());
						System.out.println("등록일: " + book.getRegistreredDate());
						System.out.println("=================");
					}

					System.out.println("##### 책 번호 검색을 완료했습니다 #####");

				} else if (searchMenuNo == 2) {
					System.out.println("[책 제목으로 검색]");
					System.out.print("책 제목을 입력하세요: ");
					String title = KeyboardUtil.nextString();

					List<Book> books = bookDao.searchBooksByTitle(title);

					if (books.isEmpty()) {
						System.out.println("제목 [" + title + "]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}

					System.out.println("##### 책 제목 검색을 완료했습니다 #####");

				} else if (searchMenuNo == 3) {
					System.out.println("[책 장르로 검색]");
					System.out.print("책 장르를 입력하세요: ");
					String genre = KeyboardUtil.nextString();

					List<Book> books = bookDao.searchBooksByGenre(genre);

					if (books.isEmpty()) {
						System.out.println("장르 [" + genre + "]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}

					System.out.println("##### 책 장르 검색을 완료했습니다 #####");

				} else if (searchMenuNo == 4) {
					System.out.println("[책 가격 검색]");
					System.out.print("최소 가격을 입력하세요: ");
					int minPrice = KeyboardUtil.nextInt();
					System.out.print("최대 가격을 입력하세요: ");
					int maxPrice = KeyboardUtil.nextInt();

					List<Book> books = bookDao.searchBooksByPriceRange(minPrice, maxPrice);

					if (books.isEmpty()) {
						System.out.println("가격 [" + minPrice + " ~ " + maxPrice + "]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						displayBooks(books);
					}

					System.out.println("##### 책 가격 검색을 완료했습니다 #####");
				}

			} else if (menuNo == 3) {
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
				book.setDiscountPrice((int) (price * 0.9));

				bookDao.addBook(book);

				System.out.println("##### 새 책 등록을 완료했습니다 #####");

			} else if (menuNo == 4) {
				System.out.println("[수정]");

			} else if (menuNo == 5) {
				System.out.println("[삭제]");

			} else if (menuNo == 6) {
				System.out.println("[문의게시판 관리자 모드]");

				System.out.println("-------------------------------------------------");
				System.out.println("1.전체조회  2.답변등록");
				System.out.println("-------------------------------------------------");

				System.out.print("메뉴를 선택하세요: ");
				int questionMenuNo = KeyboardUtil.nextInt();

				if (questionMenuNo == 1) {
					System.out.println("[문의게시판 관리자 모드]");
					
					List<Question> questions = service.문의글전체조회();

					if (questions.isEmpty()) {
						System.out.println("문의내역이 존재하지 않습니다.");
					} else {
						System.out.println("문의번호\t작성자\t카테고리\t게시글제목\t게시글내용\t조회수\t등록날짜\t답변유무");
						for (Question question : questions) {
							System.out.print(question.getNo() + "\t");
							System.out.print(question.getUser().getId() + "\t");
							System.out.print(question.getType() + "\t");
							System.out.print(question.getTitle() + "\t");
							System.out.print(question.getContent() + "\t");
							System.out.print(question.getViewCount() + "\t");
							System.out.print(question.getRegisteredDate() + "\t");
							System.out.println(question.getStatus());
						}
						System.out.println("##### 문의게시판 전체조회를 완료했습니다 #####");
					}

				} else if (questionMenuNo == 2) {
					System.out.println("[문의글 답변작성]");
					
					System.out.print("문의글 번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					System.out.print("내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					
					boolean isSuccess = service.답변등록(questionNo, content);
					if(isSuccess) {
						System.out.println("##### 답변작성을 완료했습니다 #####");
					} else {
						System.out.println("답변등록에 실패하였습니다.");
					}
				}

			} else if (menuNo == 0) {
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
		for (Book book : books) {
			System.out.print(book.getNo() + "\t");
			System.out.print(book.getTitle() + "\t");
			System.out.print(book.getWriter() + "\t");
			System.out.print(book.getGenre() + "	");
			System.out.print(book.getPublisher() + "	");
			System.out.print(book.getPrice() + "	");
			System.out.print(book.getDiscountPrice() + "	");
			System.out.print(book.getStock() + "	");
			System.out.println(book.getRegistreredDate());
		}
	}
}
