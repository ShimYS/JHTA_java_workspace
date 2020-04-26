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
			System.out.println("1.전체조회  2.검색  3.등록  4.수정  5.삭제  0.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();

			if (menuNo == 1) {

			} else if (menuNo == 2) {
				System.out.println("[주문 검색]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.이름  2.유저아이디  3.이메일  4.등록날짜");
				System.out.println("-------------------------------------------------");
				
				System.out.print("검색 조건을 선택하세요: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				
				if(searchMenuNo == 1) {
					System.out.println("[이름으로 검색]");
					System.out.print("이름을 입력하세요: ");
					String userName = KeyboardUtil.nextString();
					
					List<User> users = userDao.getUserByName(userName);
					System.out.println("아이디\t이름\t이메일\t포인트\t가입날짜");
					for(User user : users) {
						System.out.print(user.getId()+"\t");
						System.out.print(user.getName()+"\t");
						System.out.print(user.getEmail()+"\t");
						System.out.print(user.getPoint()+"\t");
						System.out.println(user.getDate());
					}
					
					System.out.println("##### 이름검색을 완료했습니다 #####");
				} else if(searchMenuNo == 2) {
					System.out.println("[유저아이디 검색]");
					System.out.print("유저아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					User user = userDao.getUserById(userId);
					System.out.println("아이디\t이름\t이메일\t포인트\t가입날짜");
					System.out.print(user.getId()+"\t");
					System.out.print(user.getName()+"\t");
					System.out.print(user.getEmail()+"\t");
					System.out.print(user.getPoint()+"\t");
					System.out.println(user.getDate());
					
					System.out.println("##### 유저검색을 완료했습니다 #####");
				}
				
			} else if (menuNo == 3) {
				System.out.println("[신규유저 등록]");
				
				System.out.print("유저아이디를 입력하세요: ");
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

				userDao.addUser(user);
				
				System.out.println("##### 신규유저 등록을 완료했습니다 #####");
				
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
