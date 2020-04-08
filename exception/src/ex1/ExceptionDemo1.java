package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		
		// ���� catch��
		try {
			
			// FileReader() ������ �޼ҵ��  FileNotFoundException �߻��� �����Ѵ�.
			FileReader reader = new FileReader("c:/hii.txt");
			BufferedReader br = new BufferedReader(reader);
			
			// BufferedReader�� readLine() �޼ҵ�� IOException �߻��� �����Ѵ�.
			String text = br.readLine();
			System.out.println("���ϳ��� " + text);
			
		} catch (FileNotFoundException e) {
			
			// FileNotFoiundException�� �߻����� �� ����Ǵ� ���๮�� �ۼ��Ѵ�.
			System.out.println("������ �������� �ʽ��ϴ�.���ϸ��� �ٽ� Ȯ���ϼ���.");
			
		} catch (IOException e) {
			
			// IOException�� �߻����� �� ����Ǵ� ���๮�� �ۼ��Ѵ�.
			System.out.println("������ �о���� ���� ������ �߻��Ͽ����ϴ�.");
			
		}

	}

}
