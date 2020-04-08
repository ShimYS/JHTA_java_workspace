package com.sample.bookstore.vo;

public class User {
	
	public int no;
	public String name;
	public String tel;
	public int point;
	public boolean isDisabled;	// false : »ç¿ë°¡´É °í°´, true : Å»ÅðÃ³¸®µÈ °í°´
	
	public User() {}
	
	public User(int no, String name, String tel, int point, boolean isDisabled) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.point = point;
		this.isDisabled = isDisabled;
	}
	
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+tel+"\t"+point+"\t"+isDisabled;
	}
	
}
