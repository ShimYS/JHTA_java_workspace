package practice;

public class p_01 extends Thread {

	@Override
	public void run() {
		// ���꽺����
		try {
			for(int i=1; i<=5; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch(InterruptedException e){
			
		}
	}

	public static void main(String[] args) {
		// ���ν�����
		p_01 p_01 = new p_01();
		p_01.start();
	}

}
