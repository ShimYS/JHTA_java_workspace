package etc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		
		// ������ ���� ����� �� �ֵ��� �ܺ������� ����� ���� �ٲٱ� ���� ����� ���ؼ� ����Ѵ�.
		Properties prop = new Properties();
		prop.load(new FileReader("src/config.properties"));
		
		String url = prop.getProperty("host.url");
		String port = prop.getProperty("host.port");
		String username = prop.getProperty("host.username");
		String password = prop.getProperty("host.password");
		
		System.out.println("U  R  L: " + url);
		System.out.println("PORT��ȣ : " + port);
		System.out.println("��   ��   �� : " + username);
		System.out.println("�� �� �� ȣ : " + password);
	}

}
