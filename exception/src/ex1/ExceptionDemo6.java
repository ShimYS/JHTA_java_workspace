package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo6 {

	public static void main(String[] args) {
		try {
			ExceptionDemo6.saveImage("https://t1.daumcdn.net/cfile/tistory/15508239500906A00F");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void saveImage(String path) throws Exception {
		try {
			URL url = new URL(path);
			
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream("C:/files/iu.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.close();
			
		} catch(FileNotFoundException e) {
			Exception ex = new Exception("������ ã�� �� �����ϴ�.");
			// ���ܰ��� �߻���Ű��, ������ ��ȯ
			//		���ܰ��� �߻� : throw Ű���� ������ �߻���ų ���ܰ�ü�� ���´�.
			//		������ ��ȯ : �߻��� ���ܸ� ����ä��, �ٸ� ���ܸ� �߻���Ų��.
			throw ex;
		} catch(MalformedURLException e) {
			Exception ex = new Exception("URL�� �ùٸ� ������ �ƴմϴ�.");
			throw ex;
		} catch(IOException e) {
			Exception ex = new Exception("I/O�۾� �� ������ �߻��Ͽ����ϴ�.");
			throw ex;
		}
		
	}

}
