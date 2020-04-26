package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.User;

public class BookstoreUserApp {

	public static void main(String[] args) throws Exception {
		
		UserDAO userDao = new UserDAO();
		
		while (true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.��ü��ȸ  2.�˻�  3.���  4.����  5.����  0.����");
			System.out.println("-------------------------------------------------");
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = KeyboardUtil.nextInt();

			if (menuNo == 1) {

			} else if (menuNo == 2) {
				System.out.println("[�ֹ� �˻�]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.�̸�  2.�������̵�  3.�̸���  4.��ϳ�¥");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�˻� ������ �����ϼ���: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[�̸����� �˻�]");
					System.out.print("�̸��� �Է��ϼ���: ");
					String userName = KeyboardUtil.nextString();
					
					List<User> users = userDao.getUserByName(userName);
					System.out.println("���̵�\t�̸�\t�̸���\t����Ʈ\t���Գ�¥");
					for(User user : users) {
						System.out.print(user.getId()+"\t");
						System.out.print(user.getName()+"\t");
						System.out.print(user.getEmail()+"\t");
						System.out.print(user.getPoint()+"\t");
						System.out.println(user.getDate());
					}
					
					System.out.println("##### �̸��˻��� �Ϸ��߽��ϴ� #####");
				} else if(searchMenuNo == 2) {
					System.out.println("[�������̵� �˻�]");
					System.out.print("�������̵� �Է��ϼ���: ");
					String userId = KeyboardUtil.nextString();
					
					User user = userDao.getUserById(userId);
					System.out.println("���̵�\t�̸�\t�̸���\t����Ʈ\t���Գ�¥");
					System.out.print(user.getId()+"\t");
					System.out.print(user.getName()+"\t");
					System.out.print(user.getEmail()+"\t");
					System.out.print(user.getPoint()+"\t");
					System.out.println(user.getDate());
					
					System.out.println("##### �����˻��� �Ϸ��߽��ϴ� #####");
				}
				
			} else if (menuNo == 3) {
				System.out.println("[�ű����� ���]");
				
				System.out.print("�������̵� �Է��ϼ���: ");
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

				userDao.addUser(user);
				
				System.out.println("##### �ű����� ����� �Ϸ��߽��ϴ� #####");
				
			} else if (menuNo == 4) {
				

			} else if (menuNo == 5) {

			} else if (menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("##### ���α׷��� �����մϴ� #####");
				break;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

}
