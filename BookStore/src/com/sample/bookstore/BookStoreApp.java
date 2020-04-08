package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookStoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookStoreApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BookStoreService service = new BookStoreService();
			
		while(true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램]");
			System.out.println("===============================================");
			System.out.println("1.회원관리	2.도서관리	3.대여관리	0.종료");
			System.out.println("===============================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println();
				System.out.println("[회원 관리]");
				System.out.println("===============================================");
				System.out.println("1.등록	2.조회	3.변경	4.탈퇴	5.전체조회	6.대여기록 조회");
				System.out.println("===============================================");
				
				System.out.print("회원관련 메뉴를 선택하세요: ");
				int userMenuNo = scanner.nextInt();
				
				if (userMenuNo == 1) {
					System.out.println("[신규 회원 등록]");
					
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();				
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					
					service.addNewUser(name, tel);
					System.out.println("### 회원등록이 완료되었습니다 ###");
					
				} else if(userMenuNo == 2) {
					System.out.println("[회원 조회]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					
					service.retrieveUserInfo(userNo);
					System.out.println("### 회원 조회가 완료되었습니다 ###");
					
				} else if(userMenuNo == 3) {
					System.out.println("[회원 정보 변경]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					System.out.print("수정할 이름을 입력하세요: ");
					String name = scanner.next();				
					System.out.print("수정할 전화번호를 입력하세요: ");
					String tel = scanner.next();
					
					User user = new User();
					user.name = name;
					user.tel = tel;
					user.no = userNo;
					
					service.modifyUserInfo(user);
					System.out.println("### 회원 정보 변경이 완료되었습니다 ###");
					
				} else if(userMenuNo == 4) {
					System.out.println("[회원 탈퇴]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					
					service.disabledUser(userNo);
					System.out.println("### 회원 탈퇴가 완료되었습니다 ###");
					
				} else if(userMenuNo == 5) {
					System.out.println("[회원 전체조회]");
					
					service.retrieveAllUsers();
					System.out.println("### 회원 전체조회가 완료되었습니다 ###");
				} else if(userMenuNo == 6) {
					System.out.println("[대여기록 조회]");
					
					System.out.print("회원 이름을 입력하세요: ");
					String name = scanner.next();
					
					service.retrieveRentInfo(name);
				}
				
			} else if(menuNo == 2) {
				System.out.println();
				System.out.println("[도서 관리]");
				System.out.println("===============================================");
				System.out.println("1.검색	2.등록	3.수정	4.전체조회");
				System.out.println("===============================================");
				
				System.out.print("도서관련 메뉴를 선택하세요: ");
				int bookMenuNo = scanner.nextInt();
				
				if (bookMenuNo == 1) {
					System.out.println("[도서 검색]");
					
					System.out.print("도서명을 입력하세요: ");
					String title = scanner.next();
					
					service.searchBooks(title);
					System.out.println("### 도서 검색이 완료되었습니다 ###");
					
				} else if(bookMenuNo == 2) {
					System.out.println("[도서 등록]");
					
					System.out.print("도서명을 입력하세요: ");
					String title = scanner.next();				
					System.out.print("저자를 입력하세요: ");
					String writer = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, writer, price);
					System.out.println("### 도서등록이 완료되었습니다 ###");
					
					
				} else if(bookMenuNo == 3) {
					System.out.println("[도서 정보 수정]");
					
					System.out.print("도서번호를 입력하세요: ");
					int bookNo = scanner.nextInt();
					System.out.print("도서명을 입력하세요: ");
					String title = scanner.next();
					System.out.print("저자를 입력하세요: ");
					String writer = scanner.next();					
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					
					
					Book book = new Book();
					book.title = title;
					book.writer = writer;
					book.price = price;
					book.no = bookNo;
					
					service.modifyBook(book);
					System.out.println("### 도서 정보 수정이 완료되었습니다 ###");
					
				} else if(bookMenuNo == 4) {
					System.out.println("[도서 전체조회]");
					
					service.retrieveAllBooks();
					System.out.println("### 도서 전체조회가 완료되었습니다 ###");
				} 
				
			} else if(menuNo == 3) {
				System.out.println();
				System.out.println("[대여/반납 관리]");
				System.out.println("===============================================");
				System.out.println("1.대여	2.반납	3.대여현황조회	4.일괄반납");
				System.out.println("===============================================");
				
				System.out.print("대여/반납 관련 메뉴를 선택하세요: ");
				int rentalMenuNo = scanner.nextInt();
				
				if (rentalMenuNo == 1) {
					System.out.println("[도서 대여]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					System.out.print("도서번호를 입력하세요: ");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					System.out.println("### 도서 대여가 완료되었습니다 ###");
					
				} else if(rentalMenuNo == 2) {
					System.out.println("[도서 반납]");
					
					System.out.print("대여번호를 입력하세요: ");
					int rentNo = scanner.nextInt();
					
					service.returnBook(rentNo);
					System.out.println("### 도서 반납이 완료되었습니다 ###");
					
				} else if(rentalMenuNo == 3) {
					System.out.println("[대여현황 조회]");
					
					service.retrieveAllRentals();
					System.out.println("### 도서 대여현황 조회가 완료되었습니다 ###");
				} else if(rentalMenuNo == 4) {
					System.out.println("[일괄반납 처리]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					
					service.returnAllBook(userNo);
					System.out.println("### 일괄반납 처리가 완료되었습니다 ###");
				}
				
			} else if(menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		
		scanner.close();
	}
	

}
