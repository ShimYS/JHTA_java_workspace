package com.sample.bookstore.vo;

public class Rental {
	
	public int no;
	public int userNo;
	public int bookNo;
	public boolean isRent;	// false:�ݳ��Ϸ� , true:�뿩��
	
	@Override
	public String toString() {
		return no+"\t"+userNo+"\t"+bookNo+"\t"+isRent;
	}
}
