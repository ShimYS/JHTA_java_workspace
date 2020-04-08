package etc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		
		// 누구나 쉽게 사용할 수 있도록 외부파일을 만들고 값을 바꾸기 쉽게 만들기 위해서 사용한다.
		Properties prop = new Properties();
		prop.load(new FileReader("src/config.properties"));
		
		String url = prop.getProperty("host.url");
		String port = prop.getProperty("host.port");
		String username = prop.getProperty("host.username");
		String password = prop.getProperty("host.password");
		
		System.out.println("U  R  L: " + url);
		System.out.println("PORT번호 : " + port);
		System.out.println("아   이   디 : " + username);
		System.out.println("비 밀 번 호 : " + password);
	}

}
