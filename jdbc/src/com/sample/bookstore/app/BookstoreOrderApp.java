package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Order;

public class BookstoreOrderApp {

	public static void main(String[] args) throws Exception {
		
		OrderDAO orderDao = new OrderDAO();
		
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
				System.out.println("1.�ֹ���ȣ  2.�������̵�  3.�帣  4.����");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�˻� ������ �����ϼ���: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[�ֹ���ȣ �˻�]");
					System.out.print("�ֹ���ȣ�� �Է��ϼ���: ");
					int orderNo = KeyboardUtil.nextInt();
					
					Order order = orderDao.getOrderByNo(orderNo);
					System.out.println("�ֹ���ȣ\t�̸�\t����\t����\t�����ݾ�\t���ż���\t�ֹ���¥");
					System.out.print(order.getNo()+"\t");
					System.out.print(order.getUser().getId()+"\t");
					System.out.print(order.getBook().getTitle()+"\t");
					System.out.print(order.getBook().getPrice()+"\t");
					System.out.print(order.getPrice()+"\t");
					System.out.print(order.getAmount()+"\t");
					System.out.print(order.getDate()+"\t");
					System.out.println();
					
					System.out.println("##### �ֹ���ȣ �˻��� �Ϸ��߽��ϴ� #####");
					
				} else if(searchMenuNo == 2) {
					System.out.println("[�������̵� �˻�]");
					System.out.print("�������̵� �Է��ϼ���: ");
					String userId = KeyboardUtil.nextString();
					
					List<Order> orders = orderDao.getrOrderByUserId(userId);
					
					if(orders.isEmpty()) {
						System.out.println("�������̵� ["+userId+"]�� �ش��ϴ� å������ �������� �ʽ��ϴ�.");
					} else {
						System.out.println("�ֹ���ȣ\t�̸�\t����\t����\t�����ݾ�\t���ż���\t�ֹ���¥");
						for(Order order : orders) {
							System.out.print(order.getNo()+"\t");
							System.out.print(order.getUser().getId()+"\t");
							System.out.print(order.getBook().getTitle()+"\t");
							System.out.print(order.getBook().getPrice()+"\t");
							System.out.print(order.getPrice()+"\t");
							System.out.print(order.getAmount()+"\t");
							System.out.print(order.getDate()+"\t");
							System.out.println();
						}
					}					
					
					System.out.println("##### å �帣 �˻��� �Ϸ��߽��ϴ� #####");
				} 
				
				
			} else if (menuNo == 3) {
				System.out.println("[�ֹ� ���]");
				
				System.out.print("�������̵� �Է��ϼ���: ");
				String userId = KeyboardUtil.nextString();
				System.out.print("å��ȣ�� �Է��ϼ���: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("������ �Է��ϼ���: ");
				int price = KeyboardUtil.nextInt();
				System.out.print("������ �Է��ϼ���: ");
				int amount = KeyboardUtil.nextInt();
				
				Order order = new Order();
				order.setPrice(price);
				order.setAmount(amount);
				
				orderDao.addOrder(order);
				
				System.out.println("##### å ����� �Ϸ��߽��ϴ� #####");
				
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
//System.out.println("�ֹ���ȣ\t�������̵�\tå��ȣ\t����\t���ż���\t�ֹ���¥");
//System.out.print(rs.getInt("order_no")+"\t");
//System.out.print(rs.getString("user_id")+"\t");
//System.out.print(rs.getInt("book_no")+"\t");
//System.out.print(rs.getInt("order_price")+"\t");
//System.out.print(rs.getInt("order_amount")+"\t");
//System.out.println(rs.getDate("order_registered_date"));
