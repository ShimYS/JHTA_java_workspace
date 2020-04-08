package oop2;

/**
 * 여러가지 구구단 출력을 제공하는 클래스다. 
 * @author ShimYS
 *
 */
public class Gugudan {
	// 세탁기가 기본동작을 제공하지 않으면 짜증 => 기본기능 제공
	// 1단 2단 3단 => 간단설정 제공
	// 수위 행굼횟수 코스 등등 세부설정 => 사용자설정 제공
	
	// 기본기능 제공
	/**
	 * 2단 ~ 9단까지 출력한다.
	 */
	void print99dan() {
		print99danByRange(2, 9);
	}
	
	// 간단설정기능 제공
	/**
	 * 지정된 단에 해당하는 구구단을 출력한다.
	 * @param dan 출력할 단의 숫자
	 */
	void print99danByNumber(int dan) {
		print99danByRange(dan, dan);
	}
	
	//사용자설정기능 제공
	/**
	 * 지정된 시작번호부터 끝번호까지의 구구단을 출력한다.
	 * @param begin	출력할 시작 단의 숫자
	 * @param end	출력할 끝 단의 숫자
	 */
	void print99danByRange(int begin, int end) {
		System.out.println("[구구단 출력] - ("+ begin + " ~ " + end + ")");
		for(int i=1; i<=9; i++) {
			for(int j=begin; j<=end; j++) {
				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
			}
			System.out.println();
		}
	}
	
}
