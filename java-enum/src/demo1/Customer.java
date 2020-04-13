package demo1;

public class Customer {
	
	private String name;
	private int grade;	// VIP, Gold, Silver, Bronze
	
	public Customer () {}	
	public Customer (String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}
}
