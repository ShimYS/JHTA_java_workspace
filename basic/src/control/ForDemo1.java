package control;

public class ForDemo1 {
	
	public static void main(String[] args) {
		
		/*
		 * for��
		 * 		������ Ƚ����ŭ ��ϳ��� ���๮�� �����Ų��.
		 * 		�ݺ�Ƚ���� �ʱ��, ���ǽ�, �������� ����ؼ� �����Ѵ�.
		 * 		for (�ʱ��; ���ǽ�; ������){
		 * 			���๮;
		 * 		}
		 * 		*�ʱ�� : �ݺ��� Ƚ���� �����ϱ����� ������ �ʱ�ȭ�Ѵ�.
		 * 		*���ǽ� : ���ǽ��� �������� true�� �����Ǵ� ���� �ݺ��� �����Ѵ�.
		 * 		*������ : �ݺ����� �����ϱ� ���ؼ� �ʱ�Ŀ��� ������ ������ ���� �����Ų��.
		 * 
		 * 		for(int i=1; i<=3; i++) {
		 *			System.out.println("�ȳ�");
		 *      }
		 *		
		 *		�ݺ�Ƚ��	�ʱ��	���ǽ�			���๮	������
		 *		1		i=1		i<=3 -> ture	�ȳ�		i=2
		 *		2				i<=3 -> ture	�ȳ�		i=3
		 *		3				i<=3 -> ture	�ȳ�		i=4
		 *		4				i<=3 -> flase -> �ߴ�
		 *
		 */
		
		for(int i=1; i<=3; i++) {
			System.out.println("Hi");
		}
		
		for(int i=1; i<=3; i++) {
			System.out.println("�ȳ� "+i);
		}
		
		for(int i=1; i<=30; i++) {
			int num = (int)(Math.random()*45+1);
			System.out.print(num+" ");
			if(i%6==0) {
				System.out.println();
			}
		}
	}
}
