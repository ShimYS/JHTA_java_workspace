package array;

public class ArrayDemo4 {

	public static void main(String[] args) {
		
		//	�迭�� �� ��ȸ/����ϱ�
		// 	Enhanced-for��
		//	- �迭, Collection�� ���� ���� ������ �����ϴ� ����ҿ��� 
		//	  �� ����� ���� �ϳ��� ��ȸ�� �� ����ϴ� for���̴�.
		//	- �ݵ�� �迭, Collection�� ������θ� ����ؾ� �Ѵ�.
		//	- for (Ÿ��  ������ : �迭){
		//			���๮;
		//	  }
		//	* ������ �迭�� ó������ ������ ������ ���� �ϳ��� ������� �����ͼ�
		//	  ������ �����ϰ� ���๮�� �����Ѵ�.
		//	* �迭 : ��ȸ�� ���� ������ �ִ� �迭
		//	* Ÿ�� : �迭�� ����� ���� Ÿ��
		//	* ������ : �迭�� ������ ���� ������� �����ȴ�.
		
		int[] scores = {60, 70, 80};
		for(int num: scores) {
			System.out.println(num);
		}
		
		String[] names = {"�̼���", "������", "������"};
		for(String name : names) {
			System.out.println(name);
		}
	}

}
