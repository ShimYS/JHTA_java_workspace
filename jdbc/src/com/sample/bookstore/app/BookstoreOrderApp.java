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
			System.out.println("1.전체조회  2.검색  3.등록  4.수정  5.삭제  0.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();

			if (menuNo == 1) {
				
			} else if (menuNo == 2) {
				System.out.println("[주문 검색]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.주문번호  2.유저아이디  3.장르  4.가격");
				System.out.println("-------------------------------------------------");
				
				System.out.print("검색 조건을 선택하세요: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[주문번호 검색]");
					System.out.print("주문번호를 입력하세요: ");
					int orderNo = KeyboardUtil.nextInt();
					
					Order order = orderDao.getOrderByNo(orderNo);
					System.out.println("주문번호\t이름\t제목\t가격\t결제금액\t구매수량\t주문날짜");
					System.out.print(order.getNo()+"\t");
					System.out.print(order.getUser().getId()+"\t");
					System.out.print(order.getBook().getTitle()+"\t");
					System.out.print(order.getBook().getPrice()+"\t");
					System.out.print(order.getPrice()+"\t");
					System.out.print(order.getAmount()+"\t");
					System.out.print(order.getDate()+"\t");
					System.out.println();
					
					System.out.println("##### 주문번호 검색을 완료했습니다 #####");
					
				} else if(searchMenuNo == 2) {
					System.out.println("[유저아이디 검색]");
					System.out.print("유저아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					List<Order> orders = orderDao.getrOrderByUserId(userId);
					
					if(orders.isEmpty()) {
						System.out.println("유저아이디 ["+userId+"]에 해당하는 책정보가 존재하지 않습니다.");
					} else {
						System.out.println("주문번호\t이름\t제목\t가격\t결제금액\t구매수량\t주문날짜");
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
					
					System.out.println("##### 책 장르 검색을 완료했습니다 #####");
				} 
				
				
			} else if (menuNo == 3) {
				System.out.println("[주문 등록]");
				
				System.out.print("유저아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				System.out.print("책번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("가격을 입력하세요: ");
				int price = KeyboardUtil.nextInt();
				System.out.print("수량을 입력하세요: ");
				int amount = KeyboardUtil.nextInt();
				
				Order order = new Order();
				order.setPrice(price);
				order.setAmount(amount);
				
				orderDao.addOrder(order);
				
				System.out.println("##### 책 등록을 완료했습니다 #####");
				
			} else if (menuNo == 4) {
				
			} else if (menuNo == 5) {
				
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

}
//System.out.println("주문번호\t유저아이디\t책번호\t가격\t구매수량\t주문날짜");
//System.out.print(rs.getInt("order_no")+"\t");
//System.out.print(rs.getString("user_id")+"\t");
//System.out.print(rs.getInt("book_no")+"\t");
//System.out.print(rs.getInt("order_price")+"\t");
//System.out.print(rs.getInt("order_amount")+"\t");
//System.out.println(rs.getDate("order_registered_date"));
