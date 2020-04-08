package ex1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo5 {

	public static void main(String[] args) {
		try {
			ExceptionDemo5.saveImage("https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BBXklQl.img?h=208&w=270&m=6&q=60&o=f&l=f&x=293&y=183.png");				
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// ����ó���� saveImage() �޼ҵ带 ȣ���� ���� �����ϱ�
	// 		throws Ű���带 ����ϸ� �ش� �޼ҵ�ȿ��� �߻��� ����Ǵ� ���ܿ� ���� ó����
	//		�� �޼ҵ带 ȣ���� ���� ���ѱ� �� �ִ�.
	private static void saveImage(String path) throws MalformedURLException, IOException {
		URL url = new URL(path);
		
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("C:/files/iu.jpeg");
		
		ExceptionDemo5.copy(in, out);
	}
	
	private static void copy(InputStream in, OutputStream out) throws IOException {	
		byte[] buf = new byte[1024];
		int len = 0;
		while((in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		out.close();
	}
}
