package demo2;

public class Customer {
	
	private String name;
	private Grade grade;	// grade변수의 타입은  enum 타입이다.
	
	public Customer () {}	
	public Customer (String name, Grade grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public Customer(String name, String gradeName) {
		this.name = name;
		
		//this.grade = Enum.valueOf(Grade.class, gradeName);
		this.grade = Grade.valueOf(gradeName);
	}
	
	public String getName() {
		return name;
	}

	public Grade getGrade() {
		return grade;
	}
}
