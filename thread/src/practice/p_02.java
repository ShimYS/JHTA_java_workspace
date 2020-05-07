package practice;

// runnable을 사용하는 이유
// 자바는 다중상속이 불가능하기 때문에, 다른 클래스를 상속을 하면서 스레드 구현시에 
// runnable 인터페이스를 상속받는 방법밖에는 다른 방법이 없다.
public class p_02 extends testclass implements Runnable  {
	
	@Override
	public void run() {
		// 서브스레드
		try {
			for(int i=1; i<=5; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
				
		}catch(InterruptedException e) {
			
		}	
	}
	
	public static void main(String[] args) {
		// 메인스레드
		p_02 p_02 = new p_02();
		Thread thread = new Thread(p_02);
		thread.start();
	}
}
