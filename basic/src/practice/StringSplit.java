package practice;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		/*
		 * 	���ڿ��� �Է¹޴´�.
		 * 	�ش� ���ڿ����� p�� ���ڿ� y�� ���ڰ� ������ 
		 * 	true�� ��ȯ�ϰ� �׷��� ������ false�� ��ȯ�Ѵ�.
		 * 	��ҹ��ڸ� ������ �ʴ´�.
		 * 
		 * 	<�����Ѱ�>
		 * 	1. ���ڿ��� �Է¹޾Ƽ� �����ϳ��ϳ��� �迭�� ���� �����ϴ¹�
		 * 	2. '=='�� ��ü�� Ÿ���� ���ϴ°�
		 * 	3. '.equals()'�� �����͸� ���ϴ°�
		 * 	4. �迭�� for������ ������ �ʱ�ȭ���� 0���� ���ǽ��� .length���� �۰� �����Ѵ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String str = sc.next();
		
		String[] sp;
		int countP = 0;
		int countY = 0;
		String result;		
		sp = str.split("");
		
		for(int i=0; i<sp.length; i++) {
			if(sp[i].equals("p") || sp[i].equals("P") ) {
				countP++;
			} else if (sp[i].equals("y") || sp[i].equals("Y")) {
				countY++;
			}
		}
		
		if(countP == countY) {
			result = "true";
		} else {
			result = "false";
		}
		
		System.out.println(result);
		
	}

}
