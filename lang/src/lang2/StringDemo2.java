package lang2;

import java.util.StringTokenizer;

public class StringDemo2 {
	
	public static void main(String[] args) {
		//split()�� StringTokenizer�� ������		
		// * split�� �����ڸ� �������� �߶��� �� �� ���ڿ��� �迭�� ��Ƶд�.
		// * StringTokenizer�� �����ڸ� �������� �߶��� �� �� ���ڿ��� ������.
		String str = "������,,������,�̼���";
		

		// split�� ���ڸ� ì���.
		String[] items = str.split(",");
		for(String item : items) {
			System.out.println("�迭�� ��: [" + item + "]" );			
		}
		System.out.println();
//		�迭�� ��: [������]
//		�迭�� ��: []
//		�迭�� ��: [������]
//		�迭�� ��: [�̼���]
		
		
		// StringTokenizer�� ���ڸ� ì���� �ʴ´�.		
		StringTokenizer tokens = new StringTokenizer(str, ",");
		while(tokens.hasMoreTokens()) {
			String value = tokens.nextToken();
			System.out.println("��ū�� ��: ["+value+"]");
		}
//		��ū�� ��: [������]
//		��ū�� ��: [������]
//		��ū�� ��: [�̼���]
	}

	
	
	
}
