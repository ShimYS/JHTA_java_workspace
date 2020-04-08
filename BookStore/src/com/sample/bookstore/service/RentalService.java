package com.sample.bookstore.service;

import java.util.Arrays;

import com.sample.bookstore.vo.Rental;

public class RentalService {
	
	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;
	
	// �뿩���� ���� ���
	// ���޹��� �뿩������ db�� �����Ѵ�.
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;
		
		position++;
		rentalSequence++;
	}
	
	// �뿩���� ��ȸ���
	// �뿩��ȣ�� �ش��ϴ� �뿩������ ��ȯ�Ѵ�.
	public Rental findRentalByNo(int rentalNo) {
		Rental result = null;
		for(int i=0; i<position; i++) {
			if(rentalNo == db[i].no) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	// ȸ����ȣ�� �뿩����Ʈ ��ȸ���
	// ����ڹ�ȣ�� ���޹޾Ƽ� �� ������� ��� �뿩���� ����Ʈ�� ��ȯ
	public Rental[] returnAllRentalByUserNo(int userNo) {
		Rental[] temp = new Rental[100];
		int arrCount = 0;
		for(int i=0; i<position; i++) {
			if(userNo == db[i].userNo) {			
				temp[arrCount] = db[i];
				arrCount++;
			}
		}
		Rental[] result = new Rental[arrCount];
		result = Arrays.copyOfRange(temp, 0, arrCount);
		
		return result;
	}
	
	// �뿩��Ȳ��ȸ���
	// ��� �뿩������ ��ȯ�Ѵ�.
	public Rental[] getAllRentals() {
		Rental[] tempDb = new Rental[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
}
