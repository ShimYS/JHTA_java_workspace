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
			System.out.println("1.ȸ������  2.�˻�  3.������  4.�ֹ�  5.���ֹ�  6.�ֹ�����  7.���ǰԽ���  0.����");
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
				
				System.out.print("�ֹ��� ���̵� �Է��ϼ���: ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> myOrders = service.���ֹ���ȸ(userId);
				if(myOrders.isEmpty()) {
					System.out.println("���̵� ["+userId+"]�� �ش��ϴ� �ֹ������� �������� �ʽ��ϴ�.");
				} else {
					System.out.println("�ֹ���ȣ\t����\t����\t���ż���");
					for(Order order : myOrders) {
						System.out.print(order.getNo()+"\t");
						System.out.print(order.getBook().getTitle()+"\t");
						System.out.print(order.getPrice()+"\t");
						System.out.println(order.getAmount()+"\t");
					}
					System.out.println("##### �� �ֹ� ���⸦ �Ϸ��߽��ϴ� #####");
				}
				
			} else if(menuNo == 6) {
				System.out.println("[�ֹ����� �󼼺���]");
				
				System.out.print("�ֹ� ��ȣ�� �Է��ϼ���: ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.�ֹ�������(orderNo);
				if(order == null) {
					System.out.println("�ֹ���ȣ "+orderNo+"�� �ش��ϴ� �ֹ������� �������� �ʽ��ϴ�.");
				} else {
					System.out.println("=================");
					System.out.println("�ֹ���ȣ: "+order.getNo());
					System.out.println("����ڸ�: "+order.getUser().getName());
					System.out.println("��      ��: "+order.getBook().getTitle());
					System.out.println("��      ��: "+order.getBook().getPrice());
					System.out.println("���Ű���: "+order.getPrice());
					System.out.println("���ż���: "+order.getAmount());
					System.out.println("�ֹ���¥: "+order.getDate());
					System.out.println("=================");
					System.out.println("##### �ֹ� ���� �󼼺��⸦ �Ϸ��߽��ϴ� #####");
				}
				
			} else if(menuNo == 7) {
				System.out.println("-------------------------------------------------");
				System.out.println("1.��ü��ȸ  2.���  3.��ȸ  4.����");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�޴��� �����ϼ���: ");
				int questionMenuNo = KeyboardUtil.nextInt();
				
				if(questionMenuNo == 1) {
					System.out.println("[���ǰԽ��� ��ü��ȸ]");
					
					List<Question> questions = service.���Ǳ���ü��ȸ();
					
					if(questions.isEmpty()) {
						System.out.println("���ǳ����� �������� �ʽ��ϴ�.");
					} else {
						System.out.println("���ǹ�ȣ\t�ۼ���\tī�װ�\t�Խñ�����\t�Խñ۳���\t��ȸ��\t��ϳ�¥\t�亯����");
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
						System.out.println("##### ���ǰԽ��� ��ü��ȸ�� �Ϸ��߽��ϴ� #####");
					}
					
				} else if(questionMenuNo == 2) {
					System.out.println("[���� ���]");
					
					System.out.print("�������̵� �Է��ϼ���: ");
					String userId = KeyboardUtil.nextString();
					System.out.print("�Խñ� ������ �Է��ϼ���: ");
					String title = KeyboardUtil.nextString();
					System.out.print("���ǳ����� �Է��ϼ���: ");
					String content = KeyboardUtil.nextString();
					System.out.print("ī�װ��� �Է��ϼ���(���, ����, ǰ��): ");
					String type = KeyboardUtil.nextString();
					
					User user = new User();
					user.setId(userId);
					Question question = new Question();
					question.setUser(user);
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);

					boolean isSuccess = service.���ǵ��(question);
					if(isSuccess) {
						System.out.println("##### ���ǵ���� �Ϸ��߽��ϴ� #####");						
					} else {
						System.out.println("�������̵� "+userId+"�� ��ġ�ϴ� ȸ�������� �������� �ʽ��ϴ�.");
					}
					
				} else if(questionMenuNo == 3) {
					System.out.println("[���Ǳ� ��ȸ]");
					
					System.out.print("���ǹ�ȣ�� �Է��ϼ���: ");
					int questionNo = KeyboardUtil.nextInt();
					
					
					Question question = service.���Ǳ���ȸ(questionNo);
					
					if(question == null) {
						System.out.println("���ǹ�ȣ "+questionNo+"�� ��ġ�ϴ� ���Ǳ��� �������� �ʽ��ϴ�.");
					} else {
						System.out.println("�� �� �� ȣ: "+question.getNo()+"\t");
						System.out.println("��   ��   ��: "+question.getUser().getId()+"\t");
						System.out.println("ī �� �� ��: "+question.getType()+"\t");
						System.out.println("�Խñ�����: "+question.getTitle()+"\t");
						System.out.println("�Խñ۳���: "+question.getContent()+"\t");
						System.out.println("��   ȸ   ��: "+question.getViewCount()+"\t");
						System.out.println("�� �� �� ¥: "+question.getRegisteredDate()+"\t");
						System.out.println("�� �� �� ��: "+question.getStatus());
						System.out.println("##### ���Ǳ� ��ȸ�� �Ϸ��߽��ϴ� #####");
					}
					
					
				} else if(questionMenuNo == 4) {
					System.out.println("[���Ǳ� ����]");
					
					System.out.print("���ǹ�ȣ�� �Է��ϼ���: ");
					int questionNo = KeyboardUtil.nextInt();
					System.out.print("�������̵� �Է��ϼ���: ");
					String userId = KeyboardUtil.nextString();
					
					boolean isSuccess = service.���Ǳۻ���(questionNo, userId);
					if(isSuccess) {	
						System.out.println("##### ���Ǳ� ������ �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("�Է��Ͻ� ������ ��ġ�ϴ� ������ �������� �ʽ��ϴ�.");
					}
				}
				
				
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
