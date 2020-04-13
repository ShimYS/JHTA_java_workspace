package demo3;

public enum DepositRate {
	
	BRONZE(0.01), SILVER(0.03), GOLD(0.05), VIP(0.1);
	
	// 열거형의 멤버변수는 반드시 final로 정의해야 한다.
	private final double value;
	
	// 열거형의 생성자는 멤버변수를 초기화 해야한다.
	// 열거형의 생성자는 오직 private만 가능하다.
	// 열거형의 생성자는 열거형 내부적으로 사용된다.
	private DepositRate(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	
	// 이러한게 내부에 있다고 생각하면 된다.
//	static class BRONZE {
//		double value;
//		BRONZE(int value) {
//			this.value = value;
//		}
//		double getValue() {
//			return value;
//		}
//	}
}
