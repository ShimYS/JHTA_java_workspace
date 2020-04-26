package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class Bookstore {

	public static void main(String[] args) throws NumberFormatException, Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.ȸ������  2.�˻�  3.������  4.�ֹ�  5.���ֹ�  6.�ֹ�����  0.����");
			System.out.println("-------------------------------------------------");
			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[ȸ������]");
				
				System.out.print("���̵� �Է��ϼ���: ");
				String id = KeyboardUtil.nextString();
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				String password = KeyboardUtil.nextString();
				System.out.print("�̸��� �Է��ϼ���: ");
				String name = KeyboardUtil.nextString();
				System.out.print("�̸����� �Է��ϼ���: ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
			
				boolean isSuccess = service.ȸ������(user); 
				if(isSuccess) {
					System.out.println("##### �ű����� ����� �Ϸ��߽��ϴ� #####");
				} else {
					System.out.println("##### �ߺ��� ID�� �����մϴ� #####");
				};
				
			} else if(menuNo == 2) {
				System.out.println("[å �˻��ϱ�]");
				
				System.out.print("Ű���带 �Է��ϼ���: ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.�����˻�(keyword);
				if(books.isEmpty()) {
					System.out.println("Ű���� ["+keyword+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
				} else {
					System.out.println(books.size() +"���� å�� ��ȸ�Ǿ����ϴ�.");
					System.out.println("��ȣ\t����\t����\t���ǻ�\t����");
					for(Book book : books) {				
						System.out.print(book.getNo()+"\t");
						System.out.print(book.getTitle()+"\t");
						System.out.print(book.getWriter()+"\t");						
						System.out.print(book.getPublisher()+"	");
						System.out.println(book.getPrice());			
					}
					System.out.println("##### Ű���� �˻��� �Ϸ��߽��ϴ� #####");
				}
				
			} else if(menuNo == 3) {
				System.out.println("[å ���� �󼼺���]");
				
				System.out.print("��ȸ�� å ��ȣ�� �Է��ϼ���: ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.����������(bookNo);
				if(book == null) {
					System.out.println("å ��ȣ ["+bookNo+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
				} else {
					System.out.println("=================");
					System.out.println("��   ȣ: "+book.getNo());
					System.out.println("��   ��: "+book.getTitle());
					System.out.println("��   ��: "+book.getWriter());
					System.out.println("��   ��: "+book.getGenre());
					System.out.println("���ǻ�: "+book.getPublisher());
					System.out.println("��   ��: "+book.getPrice());
					System.out.println("���ΰ�: "+book.getDiscountPrice());
					System.out.println("��   ��: "+book.getStock());					
					System.out.println("�����: "+book.getRegistreredDate());
					System.out.println("=================");
					System.out.println("##### å ���� �󼼺��⸦ �Ϸ��߽��ϴ� #####");
				}
						
				
			} else if(menuNo == 4) {
				System.out.println("[�ֹ��ϱ�]");
				
				System.out.print("�ֹ��� ���̵� �Է��ϼ���: ");
				String userId = KeyboardUtil.nextString();
				System.out.print("������ å ��ȣ�� �Է��ϼ���: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("������ ������ �Է��ϼ���: ");
				int amount = KeyboardUtil.nextInt();
							
				boolean isSuccess = service.�ֹ��ϱ�(userId, bookNo, amount);
				
				if(isSuccess) {
					System.out.println("##### �ֹ��ϱ⸦ �Ϸ��߽��ϴ� #####");
				}else {
					System.out.println("##### �ֹ�ó�� �� ������ �߻��Ͽ����ϴ� #####");
				}		
				
			} else if(menuNo == 5) {
				System.out.println("[�� �ֹ� ���� ����]");
				
				
			} else if(menuNo == 6) {
				System.out.println("[�ֹ����� �󼼺���]");
				
				
			} else if(menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("### ���α׷��� �����մϴ� ###");
				break;
			}
			
			System.out.println();
			System.out.println();
		}
	}

}
