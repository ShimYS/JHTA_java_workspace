package com.sample.bookstore.service;

import java.util.Arrays;

import com.sample.bookstore.vo.Rental;

public class RentalService {
	
	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;
	
	// 대여정보 저장 기능
	// 전달받은 대여정보를 db에 저장한다.
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;
		
		position++;
		rentalSequence++;
	}
	
	// 대여정보 조회기능
	// 대여번호에 해당하는 대여정보를 반환한다.
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
	
	// 회원번호로 대여리스트 조회기능
	// 사용자번호를 전달받아서 그 사용자의 모든 대여도서 리스트를 반환
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
	
	// 대여현황조회기능
	// 모든 대여정보를 반환한다.
	public Rental[] getAllRentals() {
		Rental[] tempDb = new Rental[position];
		for(int i=0; i<position; i++) {
			tempDb[i] = db[i];
		}
		return tempDb;
	}
}
