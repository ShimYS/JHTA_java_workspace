package practice;

// runnable�� ����ϴ� ����
// �ڹٴ� ���߻���� �Ұ����ϱ� ������, �ٸ� Ŭ������ ����� �ϸ鼭 ������ �����ÿ� 
// runnable �������̽��� ��ӹ޴� ����ۿ��� �ٸ� ����� ����.
public class p_02 extends testclass implements Runnable  {
	
	@Override
	public void run() {
		// ���꽺����
		try {
			for(int i=1; i<=5; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
				
		}catch(InterruptedException e) {
			
		}	
	}
	
	public static void main(String[] args) {
		// ���ν�����
		p_02 p_02 = new p_02();
		Thread thread = new Thread(p_02);
		thread.start();
	}
}
