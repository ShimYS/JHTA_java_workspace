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
			System.out.println("[���� �뿩�� ���� ���α׷�]");
			System.out.println("===============================================");
			System.out.println("1.ȸ������	2.��������	3.�뿩����	0.����");
			System.out.println("===============================================");
			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println();
				System.out.println("[ȸ�� ����]");
				System.out.println("===============================================");
				System.out.println("1.���	2.��ȸ	3.����	4.Ż��	5.��ü��ȸ	6.�뿩��� ��ȸ");
				System.out.println("===============================================");
				
				System.out.print("ȸ������ �޴��� �����ϼ���: ");
				int userMenuNo = scanner.nextInt();
				
				if (userMenuNo == 1) {
					System.out.println("[�ű� ȸ�� ���]");
					
					System.out.print("�̸��� �Է��ϼ���: ");
					String name = scanner.next();				
					System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
					String tel = scanner.next();
					
					service.addNewUser(name, tel);
					System.out.println("### ȸ������� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(userMenuNo == 2) {
					System.out.println("[ȸ�� ��ȸ]");
					
					System.out.print("ȸ����ȣ�� �Է��ϼ���: ");
					int userNo = scanner.nextInt();
					
					service.retrieveUserInfo(userNo);
					System.out.println("### ȸ�� ��ȸ�� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(userMenuNo == 3) {
					System.out.println("[ȸ�� ���� ����]");
					
					System.out.print("ȸ����ȣ�� �Է��ϼ���: ");
					int userNo = scanner.nextInt();
					System.out.print("������ �̸��� �Է��ϼ���: ");
					String name = scanner.next();				
					System.out.print("������ ��ȭ��ȣ�� �Է��ϼ���: ");
					String tel = scanner.next();
					
					User user = new User();
					user.name = name;
					user.tel = tel;
					user.no = userNo;
					
					service.modifyUserInfo(user);
					System.out.println("### ȸ�� ���� ������ �Ϸ�Ǿ����ϴ� ###");
					
				} else if(userMenuNo == 4) {
					System.out.println("[ȸ�� Ż��]");
					
					System.out.print("ȸ����ȣ�� �Է��ϼ���: ");
					int userNo = scanner.nextInt();
					
					service.disabledUser(userNo);
					System.out.println("### ȸ�� Ż�� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(userMenuNo == 5) {
					System.out.println("[ȸ�� ��ü��ȸ]");
					
					service.retrieveAllUsers();
					System.out.println("### ȸ�� ��ü��ȸ�� �Ϸ�Ǿ����ϴ� ###");
				} else if(userMenuNo == 6) {
					System.out.println("[�뿩��� ��ȸ]");
					
					System.out.print("ȸ�� �̸��� �Է��ϼ���: ");
					String name = scanner.next();
					
					service.retrieveRentInfo(name);
				}
				
			} else if(menuNo == 2) {
				System.out.println();
				System.out.println("[���� ����]");
				System.out.println("===============================================");
				System.out.println("1.�˻�	2.���	3.����	4.��ü��ȸ");
				System.out.println("===============================================");
				
				System.out.print("�������� �޴��� �����ϼ���: ");
				int bookMenuNo = scanner.nextInt();
				
				if (bookMenuNo == 1) {
					System.out.println("[���� �˻�]");
					
					System.out.print("�������� �Է��ϼ���: ");
					String title = scanner.next();
					
					service.searchBooks(title);
					System.out.println("### ���� �˻��� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(bookMenuNo == 2) {
					System.out.println("[���� ���]");
					
					System.out.print("�������� �Է��ϼ���: ");
					String title = scanner.next();				
					System.out.print("���ڸ� �Է��ϼ���: ");
					String writer = scanner.next();
					System.out.print("������ �Է��ϼ���: ");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, writer, price);
					System.out.println("### ��������� �Ϸ�Ǿ����ϴ� ###");
					
					
				} else if(bookMenuNo == 3) {
					System.out.println("[���� ���� ����]");
					
					System.out.print("������ȣ�� �Է��ϼ���: ");
					int bookNo = scanner.nextInt();
					System.out.print("�������� �Է��ϼ���: ");
					String title = scanner.next();
					System.out.print("���ڸ� �Է��ϼ���: ");
					String writer = scanner.next();					
					System.out.print("������ �Է��ϼ���: ");
					int price = scanner.nextInt();
					
					
					Book book = new Book();
					book.title = title;
					book.writer = writer;
					book.price = price;
					book.no = bookNo;
					
					service.modifyBook(book);
					System.out.println("### ���� ���� ������ �Ϸ�Ǿ����ϴ� ###");
					
				} else if(bookMenuNo == 4) {
					System.out.println("[���� ��ü��ȸ]");
					
					service.retrieveAllBooks();
					System.out.println("### ���� ��ü��ȸ�� �Ϸ�Ǿ����ϴ� ###");
				} 
				
			} else if(menuNo == 3) {
				System.out.println();
				System.out.println("[�뿩/�ݳ� ����]");
				System.out.println("===============================================");
				System.out.println("1.�뿩	2.�ݳ�	3.�뿩��Ȳ��ȸ	4.�ϰ��ݳ�");
				System.out.println("===============================================");
				
				System.out.print("�뿩/�ݳ� ���� �޴��� �����ϼ���: ");
				int rentalMenuNo = scanner.nextInt();
				
				if (rentalMenuNo == 1) {
					System.out.println("[���� �뿩]");
					
					System.out.print("ȸ����ȣ�� �Է��ϼ���: ");
					int userNo = scanner.nextInt();
					System.out.print("������ȣ�� �Է��ϼ���: ");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					System.out.println("### ���� �뿩�� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(rentalMenuNo == 2) {
					System.out.println("[���� �ݳ�]");
					
					System.out.print("�뿩��ȣ�� �Է��ϼ���: ");
					int rentNo = scanner.nextInt();
					
					service.returnBook(rentNo);
					System.out.println("### ���� �ݳ��� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(rentalMenuNo == 3) {
					System.out.println("[�뿩��Ȳ ��ȸ]");
					
					service.retrieveAllRentals();
					System.out.println("### ���� �뿩��Ȳ ��ȸ�� �Ϸ�Ǿ����ϴ� ###");
				} else if(rentalMenuNo == 4) {
					System.out.println("[�ϰ��ݳ� ó��]");
					
					System.out.print("ȸ����ȣ�� �Է��ϼ���: ");
					int userNo = scanner.nextInt();
					
					service.returnAllBook(userNo);
					System.out.println("### �ϰ��ݳ� ó���� �Ϸ�Ǿ����ϴ� ###");
				}
				
			} else if(menuNo == 0) {
				System.out.println("[���α׷� ����]");
				break;
			}
		}
		
		scanner.close();
	}
	

}
