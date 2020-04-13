package demo3;

public class User {
	
	private String name;
	private DepositRate depositRate;
	private int orderPrice;
	
	public User(String name, DepositRate depositRate, int orderPrice) {
		this.name = name;
		this.depositRate = depositRate;
		this.orderPrice = orderPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public DepositRate getDepositRate() {
		return depositRate;
	}
	
	public int getOrderPrice() {
		return orderPrice;
	}
}
