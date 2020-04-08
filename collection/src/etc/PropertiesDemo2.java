package etc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesDemo2 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ȯ�漳�� ���� ���� ���α׷�");
		System.out.println("����URL�� �Է��ϼ���: ");
		String url = scanner.next();
		System.out.println("������ ���͹�ȣ�� �Է��ϼ���: ");
		String port = scanner.next();
		System.out.println("������ ���Ӱ����� �Է��ϼ���: ");
		String username = scanner.next();
		System.out.println("������ ���� ��й�ȣ�� �Է��ϼ���: ");
		String password = scanner.next();
		
		Properties prop = new Properties();
		prop.setProperty("mail.server.url", url);
		prop.setProperty("mail.server.port", port);
		prop.setProperty("mail.server.username", username);
		prop.setProperty("mail.server.password", password);
		
		prop.store(new FileWriter("src/mail.properties"), "mail server Configuration");
		
		scanner.close();
	}

}
