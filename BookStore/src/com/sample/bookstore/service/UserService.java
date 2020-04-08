package com.sample.bookstore.service;

import com.sample.bookstore.vo.User;

public class UserService {
	
	private User[] db = new User[100];
	private int position = 0;
	private int userSequence = 10001;
	
	// 회원등록기능
	// 회원정보를 전달받아서 db배열에 저장한다.
	public UserService() {
		User u1 = new User(userSequence++, "홍길동", "010-1111-2345", 100, false);
		User u2 = new User(userSequence++, "김유신", "010-2345-8899", 100, false);
		User u3 = new User(userSequence++, "강감찬", "010-5432-1654", 100, false);
		User u4 = new User(userSequence++, "이순신", "010-7878-5252", 100, false);
		User u5 = new User(userSequence++, "류관순", "010-8888-1111", 100, false);
		
		db[position++] = u1;
		db[position++] = u2;
		db[position++] = u3;
		db[position++] = u4;
		db[position++] = u5;
	}
	
	
	
	public void insertUser(User user) {
		user.no = userSequence;
		
		db[position] = user;
		position++;
		userSequence++;
	}
	
	// 회원정보 조회 기능
	// 회원정보를 전달받아서 db배열에서 회원정보를 찾아 반환하다.
	public User findUserByNo(int no) {
		User result = null;
		for(int i=0; i<position; i++) {
			if(no == db[i].no) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	// 회원이름을 전달받아서 db배열에서 회원정보를 찾아 반환한다.
	public User findUserByName(String name) {
		User result = null;
		for(int i=0; i<position; i++) {
			if(name.equals(db[i].name)) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	// 회원정보 수정 기능
	// 회원정보를 전달받아서 회원번호에 해당하는 회원의 정보를 db에서 검색해서 회원정보를 수정한다.
	public User updateUser(User user) {
		User result = null;
		result = findUserByNo(user.no);
		
		if(result != null) {
			result.name = user.name;
			result.tel = user.tel;
		}
		return result;
	}

	// 전체 회원정보 조회기능
	// 전체 회원정보를 반환한다.
	public User[] getAllUsers() {
		User[] tempDb = new User[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
}
