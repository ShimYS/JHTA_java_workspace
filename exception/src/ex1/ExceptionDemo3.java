package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo3 {
	
	public static void main(String[] args) {
		
		try {
			
			URL url = new URL("https://t1.daumcdn.net/cfile/tistory/15508239500906A00F");
			InputStream in = url.openStream();
			System.out.println("�ش� ���ͳ� ���ҽ��� ������ �Ϸ�Ǿ����ϴ�.");
			
			System.out.println("���� ������ �����մϴ�.");
			FileOutputStream out = new FileOutputStream("C:/files/java.png");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.close();
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
			
		} catch (MalformedURLException e) {
			System.out.println("�ö� URL�� �ƴմϴ�.");
		} catch (IOException e) {
			System.out.println("�ش� ���ͳ� ���ҽ��� �о���� ���� ������ �߻��Ͽ����ϴ�.");
		}
	}
}


