package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo2 {
	
	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("c:/hii.txt");
			BufferedReader br = new BufferedReader(reader);

			String text = br.readLine();
			System.out.println("���ϳ��� " + text);
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.���ϸ��� �ٽ� Ȯ���ϼ���.");
		} catch (IOException e) {
			System.out.println("������ �о���� ���� ������ �߻��Ͽ����ϴ�.");
		} catch (Exception e) {			
			System.out.println("�������� ���� ������ �߻��Ͽ����ϴ�.");
		}		
		/*
		 *	1. catch () [] ����� ���� �� �ۼ��ؾ� �ϴ� ���
		 *			���ܸ� catch�ϴ� ������ �߿��ϴ�. �θ� Ŭ������ �Ʒ��ʿ� ��ġ�ϰ� �ۼ��ؾ� �Ѵ�.
		 *	2. �� ������ catch () [] ����� Exception ��ü�� ��´�.
		 *			catch () [] ��Ͽ��� Exception�� �����صθ� �������� ���� ���ܵ�
		 *			�ش� catch () [] ���� ���� �� �ֱ�  ������ ���α׷��� ���۽����� ����
		 *			�� ��ġ�� �� �ִ�.
		 */			
	}
}
