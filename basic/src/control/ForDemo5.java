package control;

public class ForDemo5 {

	public static void main(String[] args) {
		// ��ø for��
		for(int i=1; i<=3; i++) {
			System.out.println("i��: "+i);
			
			for(int j=1; j<=5; j++) {
				if(j >= 3) {
					break; // ��øfor������ break�� �ش� for���� Ż���Ѵ�.
						   // �ٱ��� for���� ������ ���� �ʴ´�.
				}
				System.out.println("i��: " + i + ", j��: "+ j );
			}
		}
		

	}

}
