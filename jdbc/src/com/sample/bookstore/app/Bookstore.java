package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class Bookstore {

	public static void main(String[] args) throws NumberFormatException, Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.회원가입  2.검색  3.상세정보  4.주문  5.내주문  6.주문정보  7.문의게시판  0.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[회원가입]");
				
				System.out.print("아이디를 입력하세요: ");
				String id = KeyboardUtil.nextString();
				System.out.print("비밀번호를 입력하세요: ");
				String password = KeyboardUtil.nextString();
				System.out.print("이름을 입력하세요: ");
				String name = KeyboardUtil.nextString();
				System.out.print("이메일을 입력하세요: ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
			
				boolean isSuccess = service.회원가입(user); 
				if(isSuccess) {
					System.out.println("##### 신규유저 등록을 완료했습니다 #####");
				} else {
					System.out.println("##### 중복된 ID가 존재합니다 #####");
				};
				
			} else if(menuNo == 2) {
				System.out.println("[책 검색하기]");
				
				System.out.print("키워드를 입력하세요: ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.도서검색(keyword);
				if(books.isEmpty()) {
					System.out.println("키워드 ["+keyword+"]에 해당하는 책정보가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() +"권의 책이 조회되었습니다.");
					System.out.println("번호\t제목\t저자\t출판사\t가격");
					for(Book book : books) {				
						System.out.print(book.getNo()+"\t");
						System.out.print(book.getTitle()+"\t");
						System.out.print(book.getWriter()+"\t");						
						System.out.print(book.getPublisher()+"	");
						System.out.println(book.getPrice());			
					}
					System.out.println("##### 키워드 검색을 완료했습니다 #####");
				}
				
			} else if(menuNo == 3) {
				System.out.println("[책 정보 상세보기]");
				
				System.out.print("조회할 책 번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.도서상세정보(bookNo);
				if(book == null) {
					System.out.println("책 번호 ["+bookNo+"]에 해당하는 책정보가 존재하지 않습니다.");
				} else {
					System.out.println("=================");
					System.out.println("번   호: "+book.getNo());
					System.out.println("제   목: "+book.getTitle());
					System.out.println("저   자: "+book.getWriter());
					System.out.println("장   르: "+book.getGenre());
					System.out.println("출판사: "+book.getPublisher());
					System.out.println("가   격: "+book.getPrice());
					System.out.println("할인가: "+book.getDiscountPrice());
					System.out.println("재   고: "+book.getStock());					
					System.out.println("등록일: "+book.getRegistreredDate());
					System.out.println("=================");
					System.out.println("##### 책 정보 상세보기를 완료했습니다 #####");
				}
						
				
			} else if(menuNo == 4) {
				System.out.println("[주문하기]");
				
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				System.out.print("구매할 책 번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("구매할 수량을 입력하세요: ");
				int amount = KeyboardUtil.nextInt();
							
				boolean isSuccess = service.주문하기(userId, bookNo, amount);
				
				if(isSuccess) {
					System.out.println("##### 주문하기를 완료했습니다 #####");
				}else {
					System.out.println("##### 주문처리 중 오류가 발생하였습니다 #####");
				}		
				
			} else if(menuNo == 5) {
				System.out.println("[내 주문 전부 보기]");
				
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> myOrders = service.내주문조회(userId);
				if(myOrders.isEmpty()) {
					System.out.println("아이디 ["+userId+"]에 해당하는 주문내역이 존재하지 않습니다.");
				} else {
					System.out.println("주문번호\t제목\t가격\t구매수량");
					for(Order order : myOrders) {
						System.out.print(order.getNo()+"\t");
						System.out.print(order.getBook().getTitle()+"\t");
						System.out.print(order.getPrice()+"\t");
						System.out.println(order.getAmount()+"\t");
					}
					System.out.println("##### 내 주문 보기를 완료했습니다 #####");
				}
				
			} else if(menuNo == 6) {
				System.out.println("[주문정보 상세보기]");
				
				System.out.print("주문 번호를 입력하세요: ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.주문상세정보(orderNo);
				if(order == null) {
					System.out.println("주문번호 "+orderNo+"에 해당하는 주문정보가 존재하지 않습니다.");
				} else {
					System.out.println("=================");
					System.out.println("주문번호: "+order.getNo());
					System.out.println("사용자명: "+order.getUser().getName());
					System.out.println("제      목: "+order.getBook().getTitle());
					System.out.println("가      격: "+order.getBook().getPrice());
					System.out.println("구매가격: "+order.getPrice());
					System.out.println("구매수량: "+order.getAmount());
					System.out.println("주문날짜: "+order.getDate());
					System.out.println("=================");
					System.out.println("##### 주문 정보 상세보기를 완료했습니다 #####");
				}
				
			} else if(menuNo == 7) {
				System.out.println("-------------------------------------------------");
				System.out.println("1.전체조회  2.등록  3.조회  4.삭제");
				System.out.println("-------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요: ");
				int questionMenuNo = KeyboardUtil.nextInt();
				
				if(questionMenuNo == 1) {
					System.out.println("[문의게시판 전체조회]");
					
					List<Question> questions = service.문의글전체조회();
					
					if(questions.isEmpty()) {
						System.out.println("문의내역이 존재하지 않습니다.");
					} else {
						System.out.println("문의번호\t작성자\t카테고리\t게시글제목\t게시글내용\t조회수\t등록날짜\t답변유무");
						for(Question question : questions) {
							System.out.print(question.getNo()+"\t");
							System.out.print(question.getUser().getId()+"\t");
							System.out.print(question.getType()+"\t");
							System.out.print(question.getTitle()+"\t");
							System.out.print(question.getContent()+"\t");
							System.out.print(question.getViewCount()+"\t");
							System.out.print(question.getRegisteredDate()+"\t");
							System.out.println(question.getStatus());
						}
						System.out.println("##### 문의게시판 전체조회를 완료했습니다 #####");
					}
					
				} else if(questionMenuNo == 2) {
					System.out.println("[문의 등록]");
					
					System.out.print("유저아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					System.out.print("게시글 제목을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("문의내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					System.out.print("카테고리를 입력하세요(배송, 결재, 품질): ");
					String type = KeyboardUtil.nextString();
					
					User user = new User();
					user.setId(userId);
					Question question = new Question();
					question.setUser(user);
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);

					boolean isSuccess = service.문의등록(question);
					if(isSuccess) {
						System.out.println("##### 문의등록을 완료했습니다 #####");						
					} else {
						System.out.println("유저아이디 "+userId+"와 일치하는 회원정보가 존재하지 않습니다.");
					}
					
				} else if(questionMenuNo == 3) {
					System.out.println("[문의글 조회]");
					
					System.out.print("문의번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					
					
					Question question = service.문의글조회(questionNo);
					
					if(question == null) {
						System.out.println("문의번호 "+questionNo+"와 일치하는 문의글이 존재하지 않습니다.");
					} else {
						System.out.println("문 의 번 호: "+question.getNo()+"\t");
						System.out.println("작   성   자: "+question.getUser().getId()+"\t");
						System.out.println("카 테 고 리: "+question.getType()+"\t");
						System.out.println("게시글제목: "+question.getTitle()+"\t");
						System.out.println("게시글내용: "+question.getContent()+"\t");
						System.out.println("조   회   수: "+question.getViewCount()+"\t");
						System.out.println("등 록 날 짜: "+question.getRegisteredDate()+"\t");
						System.out.println("답 변 유 무: "+question.getStatus());
						System.out.println("##### 문의글 조회를 완료했습니다 #####");
					}
					
					
				} else if(questionMenuNo == 4) {
					System.out.println("[문의글 삭제]");
					
					System.out.print("문의번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					System.out.print("유저아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					boolean isSuccess = service.문의글삭제(questionNo, userId);
					if(isSuccess) {	
						System.out.println("##### 문의글 삭제를 완료했습니다 #####");
					} else {
						System.out.println("입력하신 정보와 일치하는 정보가 존재하지 않습니다.");
					}
				}
				
				
			} else if(menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("### 프로그램을 종료합니다 ###");
				break;
			}
			
			System.out.println();
			System.out.println();
		}
	}

}
