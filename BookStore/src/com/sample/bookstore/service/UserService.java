package com.sample.bookstore.service;

import com.sample.bookstore.vo.User;

public class UserService {
	
	private User[] db = new User[100];
	private int position = 0;
	private int userSequence = 10001;
	
	// ȸ����ϱ��
	// ȸ�������� ���޹޾Ƽ� db�迭�� �����Ѵ�.
	public UserService() {
		User u1 = new User(userSequence++, "ȫ�浿", "010-1111-2345", 100, false);
		User u2 = new User(userSequence++, "������", "010-2345-8899", 100, false);
		User u3 = new User(userSequence++, "������", "010-5432-1654", 100, false);
		User u4 = new User(userSequence++, "�̼���", "010-7878-5252", 100, false);
		User u5 = new User(userSequence++, "������", "010-8888-1111", 100, false);
		
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
	
	// ȸ������ ��ȸ ���
	// ȸ�������� ���޹޾Ƽ� db�迭���� ȸ�������� ã�� ��ȯ�ϴ�.
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
	
	// ȸ���̸��� ���޹޾Ƽ� db�迭���� ȸ�������� ã�� ��ȯ�Ѵ�.
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
	
	// ȸ������ ���� ���
	// ȸ�������� ���޹޾Ƽ� ȸ����ȣ�� �ش��ϴ� ȸ���� ������ db���� �˻��ؼ� ȸ�������� �����Ѵ�.
	public User updateUser(User user) {
		User result = null;
		result = findUserByNo(user.no);
		
		if(result != null) {
			result.name = user.name;
			result.tel = user.tel;
		}
		return result;
	}

	// ��ü ȸ������ ��ȸ���
	// ��ü ȸ�������� ��ȯ�Ѵ�.
	public User[] getAllUsers() {
		User[] tempDb = new User[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
}
