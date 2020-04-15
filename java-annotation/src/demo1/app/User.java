package demo1.app;

import demo1.annotation.NotNull;

public class User {
	
	@NotNull(message = "이름은 필수입력값입니다.")
	String name;
	@NotNull(message = "이메일은 필수입력값입니다.")
	String email;
	@NotNull(message =  "전화번호는 필수입력값입니다.")
	String tel;
	
	
	public User() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
